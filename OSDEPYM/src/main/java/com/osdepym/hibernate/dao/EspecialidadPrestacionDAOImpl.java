package com.osdepym.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Categoria;
import com.osdepym.hibernate.entity.EspecialidadPrestacion;
import com.osdepym.hibernate.entity.Prestacion;

public class EspecialidadPrestacionDAOImpl implements EspecialidadPrestacionDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public EspecialidadPrestacion get(Integer id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EspecialidadPrestacion> getAll() throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(EspecialidadPrestacion t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EspecialidadPrestacion t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EspecialidadPrestacion t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prestacion> getPrestacionesByEspecialidadId(int idEspecialidad) throws CustomException {
		try {
			List<Prestacion> prestaciones = new ArrayList<Prestacion>();
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT P.* FROM tramites_online.PRESTACIONES P INNER JOIN tramites_online.ESPEC_PREST EP ON EP.ID_PRESTACION = P.ID_PRESTACION WHERE EP.ID_ESPECIALIDAD = " + idEspecialidad;
			prestaciones = session.createNativeQuery(sqlString, Prestacion.class).getResultList();
			return prestaciones;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

}
