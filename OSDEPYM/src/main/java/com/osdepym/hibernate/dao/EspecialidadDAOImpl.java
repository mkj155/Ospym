package com.osdepym.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Especialidad;

@Repository
public class EspecialidadDAOImpl implements EspecialidadDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Especialidad get(Integer id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Especialidad> getAll() throws CustomException {
		try {
			List<Especialidad> especialidades = null;
			Session session = this.sessionFactory.getCurrentSession();
			especialidades = session.createQuery("FROM com.osdepym.hibernate.entity.Especialidad", Especialidad.class).list();
			return especialidades;
		}catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	@Override
	public void save(Especialidad t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Especialidad t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Especialidad t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

}
