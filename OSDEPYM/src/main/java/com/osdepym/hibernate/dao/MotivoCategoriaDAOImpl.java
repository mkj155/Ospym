package com.osdepym.hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.MotivoCategoria;

public class MotivoCategoriaDAOImpl implements MotivoCategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public MotivoCategoria get(Integer id) throws CustomException {
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
	}

	@Override
	public void update(MotivoCategoria t) throws CustomException {
	}

	@Override
	public void delete(MotivoCategoria t) throws CustomException {
	}

	@Override
	public Integer getSecuence() throws CustomException {
		Integer secuence;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String queryString = "SELECT NEXT VALUE FOR contacto_seq AS sequenceValue";
			Query query = session.createNativeQuery(queryString).addScalar("sequenceValue", StandardBasicTypes.INTEGER);
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

}
