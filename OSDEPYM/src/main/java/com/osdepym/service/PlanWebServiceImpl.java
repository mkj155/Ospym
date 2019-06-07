package com.osdepym.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osdepym.dto.PlanItemDTO;
import com.osdepym.dto.PlanSeccionDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.dao.PlanItemDAO;
import com.osdepym.hibernate.entity.PlanItem;
import com.osdepym.util.SessionUtil;

@Service("PlanWebService")
public class PlanWebServiceImpl implements PlanWebService {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private PlanItemDAO planItemDAO;

	public PlanItemDAO getPlanItemDAO() {
		return planItemDAO;
	}

	public void setPlanItemDAO(PlanItemDAO planItemDAO) {
		this.planItemDAO = planItemDAO;
	}

	@Override
	public List<PlanSeccionDTO> getSeccionesByPlan(Long idPlan) throws CustomException {
		List<PlanSeccionDTO> secciones = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<PlanItem> items = planItemDAO.getItemsByPlan(idPlan);
			secciones = entityToDto(items);
			tx.commit();
			session.close();
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return secciones;

	}

	private List<PlanSeccionDTO> entityToDto(List<PlanItem> items) {
		HashMap<Long, PlanSeccionDTO> seccionMap = new HashMap<Long, PlanSeccionDTO>();
		HashMap<Long, PlanItemDTO> itemMap = new HashMap<Long, PlanItemDTO>();
		HashMap<Long, Long> itemToSection = new HashMap<Long, Long>();
		List<PlanItem> childItems = new ArrayList<PlanItem>();
		//Creamos todas las secciones, y obtenemos los items de primer nivel
		for (PlanItem item : items) {
			if (item.getItemPadre() == null) {
				if (seccionMap.get((Long) item.getSeccion().getIdPlanSeccion()) == null) {
					seccionMap.put((Long) item.getSeccion().getIdPlanSeccion(),
							new PlanSeccionDTO((item.getSeccion().getIdPlanSeccion()), item.getSeccion().getTitulo(), item.getSeccion().getSubtitulo(),
									new ArrayList<PlanItemDTO>()));
				}
					itemMap.put(item.getIdPlanItem(),
							new PlanItemDTO(item.getIdPlanItem(), item.getTitulo(), item.getValor(), new ArrayList<PlanItemDTO>()));
					itemToSection.put(item.getIdPlanItem(), item.getSeccion().getIdPlanSeccion());
				
			} else {
				childItems.add(item);
			}
		}
		//Seteamos todos los items de segundo nivel a los de primer nivel
		for (PlanItem subitem : childItems) {
			if (itemMap.get((Long) subitem.getItemPadre().getIdPlanItem()) != null) {
				PlanItemDTO parent = itemMap.get((Long) subitem.getItemPadre().getIdPlanItem());
				List<PlanItemDTO> childItemList = parent.getSubitemsList();
				childItemList.add(new PlanItemDTO(subitem.getIdPlanItem(), subitem.getTitulo(), subitem.getValor(), new ArrayList<PlanItemDTO>()));
				parent.setSubitemsList(childItemList);
				itemMap.put((Long) subitem.getItemPadre().getIdPlanItem(), parent);
			}
		}
		//Seteamos los items a las secciones
		for(Entry<Long, PlanItemDTO> entry : itemMap.entrySet()) {
			PlanSeccionDTO seccion = seccionMap.get(itemToSection.get(entry.getValue().getId()));
			List<PlanItemDTO> itemList = seccion.getItemsList();
			itemList.add(entry.getValue());
			seccion.setItemsList(itemList);
			seccionMap.put(itemToSection.get(entry.getValue().getId()), seccion);
		}
		
		return new ArrayList<PlanSeccionDTO>(seccionMap.values());

	}

}
