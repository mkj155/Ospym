package com.osdepym.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.MotivoCategoria;

public class MotivoCategoriaDAOImpl implements MotivoCategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public MotivoCategoria get(Integer id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MotivoCategoria> getAll() throws CustomException {
		try {
			List<MotivoCategoria> motivoCategoria = null;
			Session session = this.sessionFactory.getCurrentSession();
			motivoCategoria = session.createQuery("FROM com.osdepym.hibernate.entity.MotivoCategoria", MotivoCategoria.class).list();
			return motivoCategoria;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	@Override
	public void save(MotivoCategoria t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MotivoCategoria t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MotivoCategoria t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

}
