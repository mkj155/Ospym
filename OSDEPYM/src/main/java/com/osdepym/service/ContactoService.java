package com.osdepym.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;

import com.osdepym.dto.MotivoCategoriaDTO;
import com.osdepym.dto.MotivoDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.dao.MotivoCategoriaDAO;
import com.osdepym.hibernate.dao.MotivoDAO;
import com.osdepym.hibernate.entity.Motivo;
import com.osdepym.hibernate.entity.MotivoCategoria;

public class ContactoService {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private MotivoCategoriaDAO motivoCategoriaDAO ;

	public MotivoCategoriaDAO getMotivoCategoriaDAO() {
		return motivoCategoriaDAO;
	}

	public void setMotivoCategoriaDAO(MotivoCategoriaDAO motivoCategoriaDAO) {
		this.motivoCategoriaDAO = motivoCategoriaDAO;
	}
	
	private MotivoDAO motivoDAO ;

	public MotivoDAO getMotivoDAO() {
		return motivoDAO;
	}

	public void setMotivoDAO(MotivoDAO motivoDAO) {
		this.motivoDAO = motivoDAO;
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
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return motivosDTO;
	}
	
	
	
	private MotivoDTO entityToDTO(Motivo motivo) {
		MotivoDTO motivoDTO = new MotivoDTO();
		BeanUtils.copyProperties(motivo, motivoDTO);
		return motivoDTO;
	}
	
}
