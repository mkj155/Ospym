package com.osdepym.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.hibernate.dao.SolicitudesDAO;
import com.osdepym.hibernate.entity.Afiliado;
import com.osdepym.util.SessionUtil;

@Service("SolicitudesService")
public class SolicitudesServiceImpl implements SolicitudesService{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private SolicitudesDAO solicitudesDAO ;

	public SolicitudesDAO getSolicitudesDAO() {
		return solicitudesDAO;
	}

	public void setSolicitudesDAO(SolicitudesDAO solicitudesDAO) {
		this.solicitudesDAO = solicitudesDAO;
	}
	
	@Override
	public List<AfiliadoDTO> buscarAfiliados(AfiliadoDTO afiliadoDTO) throws CustomException {
		List<AfiliadoDTO> afiliadosDTO = new ArrayList<AfiliadoDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Afiliado> afiliados = solicitudesDAO.buscarAfiliados(afiliadoDTO);
			if (afiliados != null) {
				for (Afiliado afiliado : afiliados) {
					//afiliadosDTO.add(entityToDTO(afiliado));
				}
			}
			tx.commit();
			session.close();
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.LOAD_CONTACT_ERROR);
		}
		return afiliadosDTO;
	}
}