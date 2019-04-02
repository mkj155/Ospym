package com.osdepym.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Persona;

public class TestPersonaDAOImpl implements TestPersonaDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Persona> getAll() throws CustomException{
		try {
			List<Persona> personas = null;
			Session session = this.sessionFactory.getCurrentSession();
			personas = session.createQuery("FROM com.osdepym.hibernate.entity.Persona", Persona.class).list();
			return personas;
		}catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	@Override
	public void save(Persona persona) throws CustomException{
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(persona);
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}

	@Override
	public void delete(Persona persona) throws CustomException{
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(persona);
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_DELETE_ERROR);
		}
	}

	@Override
	public void update(Persona persona) throws CustomException{
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(persona);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}

	@Override
	public Persona get(Integer id) throws CustomException{
		try {
			Persona persona = null;
			Session session = this.sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
			Root<Persona> root = criteria.from(Persona.class);
			criteria.select(root).where(builder.equal(root.get("nroCliente"), id));
			Query<Persona> query = session.createQuery(criteria);
			persona = query.getSingleResult();
			return persona;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		} 
		
	}

	@Override
	public Persona getByName(String nombre) throws CustomException{
		try {
			Persona persona = null;
			Session session = this.sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
			Root<Persona> root = criteria.from(Persona.class);
			criteria.select(root).where(builder.equal(root.get("nombre"), nombre));
			Query<Persona> query = session.createQuery(criteria);
			persona = query.getSingleResult();
			return persona;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		} 
		
	}

}
