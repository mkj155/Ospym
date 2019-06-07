package com.osdepym.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.EspecialidadPrestacion;
import com.osdepym.hibernate.entity.Prestacion;

@Repository
public class EspecialidadPrestacionDAOImpl implements EspecialidadPrestacionDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public EspecialidadPrestacion get(Long id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EspecialidadPrestacion> getAll() throws CustomException {
		try {
			List<EspecialidadPrestacion> especialidadPrestacion = null;
			Session session = this.sessionFactory.getCurrentSession();
			especialidadPrestacion = session.createQuery("FROM com.osdepym.hibernate.entity.EspecialidadPrestacion", EspecialidadPrestacion.class).list();
			return especialidadPrestacion;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
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
	public List<Prestacion> getPrestacionesByEspecialidadId(Long idEspecialidad) throws CustomException {
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
	
	@Override
	public Integer getSecuence() throws CustomException {
		Integer secuence;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createNativeQuery("EXECUTE tramites_online.GET_NEXT_AUTORIZACION_VALUE");
			secuence = (Integer) query.getSingleResult();
			return secuence;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	@Override
	public void saveContacto(Contacto contacto) throws CustomException {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(contacto);
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}
	
	@Override
	public String getMailByIds(Long idEspecialidad, Long idPrestacion) throws CustomException {
		String mail = "";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT CORREO FROM tramites_online.ESPEC_PREST WHERE ID_ESPECIALIDAD = %s AND ID_PRESTACION = %s";
			sqlString = String.format(sqlString, idEspecialidad, idPrestacion);
			Query query = session.createNativeQuery(sqlString);
			mail = query.getSingleResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return mail;
	}

	@Override
	public String getEspecialidadById(Long idEspecialidad) throws CustomException {
		String especialidad = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT ETIQUETA FROM tramites_online.ESPECIALIDADES WHERE ID_ESPECIALIDAD = %s";
			sqlString = String.format(sqlString, idEspecialidad);
			Query query = session.createNativeQuery(sqlString);
			especialidad = query.getSingleResult().toString();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return especialidad;
	}

	@Override
	public String getPrestacionById(Long idPrestacion) throws CustomException {
		String prestacion = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT ETIQUETA FROM tramites_online.PRESTACIONES WHERE ID_PRESTACION = %s";
			sqlString = String.format(sqlString, idPrestacion);
			Query query = session.createNativeQuery(sqlString);
			prestacion = query.getSingleResult().toString();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return prestacion;
	}

}
