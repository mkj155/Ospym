package com.osdepym.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osdepym.dto.AfiliadoTableDTO;
import com.osdepym.dto.EstadoDTO;
import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.hibernate.dao.SolicitudesDAO;
import com.osdepym.hibernate.entity.Afiliado;
import com.osdepym.hibernate.entity.Estado;
import com.osdepym.hibernate.entity.ObraSocial;
import com.osdepym.util.EntityToDTOUtil;
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
	public List<AfiliadoTableDTO> buscar(SolicitudesForm form) throws CustomException {
		List<AfiliadoTableDTO> afiliadosDTO = new ArrayList<AfiliadoTableDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Afiliado> afiliados = solicitudesDAO.buscar(form);
			if (afiliados != null) {
				for (Afiliado entity : afiliados) {
					afiliadosDTO.add(EntityToDTOUtil.entityToDTO2(entity));
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
	
	@Transactional
	public List<ObraSocialDTO> getAllObrasSociales() throws CustomException {
		List<ObraSocialDTO> osDTOList = new ArrayList<ObraSocialDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<ObraSocial> osList = solicitudesDAO.getAllObrasSociales();
			if (osList != null) {
				for (ObraSocial entity : osList) {
					osDTOList.add(EntityToDTOUtil.entityToDTO(entity));
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
		return osDTOList;
	}
	
	@Transactional
	public List<EstadoDTO> getAllEstados() throws CustomException {
		List<EstadoDTO> estadoDTOList = new ArrayList<EstadoDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Estado> estadoList = solicitudesDAO.getAllEstados();
			if (estadoList != null) {
				for (Estado entity : estadoList) {
					estadoDTOList.add(EntityToDTOUtil.entityToDTO(entity));
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
		return estadoDTOList;
	}
}