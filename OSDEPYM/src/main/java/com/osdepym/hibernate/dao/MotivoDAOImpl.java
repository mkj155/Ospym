package com.osdepym.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Motivo;
import com.osdepym.hibernate.entity.Persona;

public class MotivoDAOImpl implements MotivoDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Motivo get(Integer id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Motivo> getAll() throws CustomException {
		try {
			List<Motivo> motivos = null;
			Session session = this.sessionFactory.getCurrentSession();
			motivos = session.createQuery("FROM com.osdepym.hibernate.entity.Motivo", Motivo.class).list();
			return motivos;
		}catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	@Override
	public void save(Motivo t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Motivo t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Motivo t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

}
