package com.osdepym.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.osdepym.dto.MotivoCategoriaDTO;
import com.osdepym.dto.MotivoDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.dao.MotivoCategoriaDAO;
import com.osdepym.hibernate.dao.MotivoDAO;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.Motivo;
import com.osdepym.hibernate.entity.MotivoCategoria;

@Service("ContactService")
public class ContactoServiceImpl implements ContactoService {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MotivoCategoriaDAO motivoCategoriaDAO ;

	@Autowired
	private MotivoDAO motivoDAO;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public MotivoCategoriaDAO getMotivoCategoriaDAO() {
		return motivoCategoriaDAO;
	}

	public void setMotivoCategoriaDAO(MotivoCategoriaDAO motivoCategoriaDAO) {
		this.motivoCategoriaDAO = motivoCategoriaDAO;
	}
	
	@Transactional
	public List<MotivoDTO> getAllMotivos() throws CustomException {
		List<MotivoDTO> motivosDTO = new ArrayList<MotivoDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Motivo> motivos = motivoDAO.getAll();
			if (motivos != null) {
				for (Motivo motivo : motivos) {
					motivosDTO.add(entityToDTO(motivo));
				}
			}
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return motivosDTO;
	}
	
	private MotivoDTO entityToDTO(Motivo motivo) {
		MotivoDTO motivoDTO = new MotivoDTO();
		BeanUtils.copyProperties(motivo, motivoDTO);
		return motivoDTO;
	}
	
	@Transactional
	public String getSecuence() throws CustomException {
		String secuence = "";
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			Integer result = motivoCategoriaDAO.getSecuence();
			secuence = fillWithZero(result);
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return secuence;
	}

	private String fillWithZero(Integer result) {
		String sequence = "";
		sequence = String.format("%06d", result);
		return sequence;
	}
	
	@Transactional
	public void saveContacto(Contacto contacto) throws CustomException{
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			motivoCategoriaDAO.saveContacto(contacto);
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
	}
	
}
