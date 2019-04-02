package com.osdepym.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.osdepym.hibernate.entity.Persona;

public class TestPersonaDAOImpl implements TestPersonaDAO {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<Persona> getAll() {
		List<Persona> personas = null;
		try {
			Session session = this.sessionFactory.openSession();
			personas = session.createQuery("FROM com.osdepym.hibernate.entity.Persona", Persona.class).list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personas;
	}

	@Override
	public boolean save(Persona persona) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(persona);
			tx.commit();
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return result;
	}

	@Override
	public boolean delete(Persona persona) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(persona);
			tx.commit();
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return result;
	}

	@Override
	public boolean update(Persona persona) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(persona);
			tx.commit();
			result = true;
		} catch (Exception e) {
 			result = false;
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return result;
	}

	@Override
	public Persona get(Integer id) {
		Session session = null;
		Persona persona = null;
		try {
			session = this.sessionFactory.openSession();
			// creando query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
			Root<Persona> root = criteria.from(Persona.class);
			criteria.select(root).where(builder.equal(root.get("nroCliente"), id));
			Query<Persona> query = session.createQuery(criteria);
			// obteniendo resultado
			persona = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return persona;
	}
	
	@Override
	public Persona getByName(String nombre) {
		Session session = null;
		Persona persona = null;
		try {
			session = this.sessionFactory.openSession();
			// creando query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
			Root<Persona> root = criteria.from(Persona.class);
			criteria.select(root).where(builder.equal(root.get("nombre"), nombre));
			Query<Persona> query = session.createQuery(criteria);
			// obteniendo resultado
			persona = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return persona;
	}
	
}
