package com.osdepym.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.osdepym.hibernate.entity.Profesores;

public class TestProfesoresDAOImpl implements TestProfesoresDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
	public List<Profesores> getAll() {
		List<Profesores> profesores = null;
		try {
			Session session = this.sessionFactory.openSession();
			profesores = session.createQuery("FROM com.osdepym.hibernate.entity.Profesores", Profesores.class).list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profesores;
	}

	@Override
	public boolean save(Profesores profesor) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(profesor);
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
	public boolean delete(Profesores profesor) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(profesor);
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
	public boolean update(Profesores profesor) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(profesor);
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
	public Profesores get(Integer id) {
		Session session = null;
		Profesores profesor = null;
		try {
			session = this.sessionFactory.openSession();
			// creando query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Profesores> criteria = builder.createQuery(Profesores.class);
			Root<Profesores> root = criteria.from(Profesores.class);
			criteria.select(root).where(builder.equal(root.get("idProfesor"), id));
			Query<Profesores> query = session.createQuery(criteria);
			// obteniendo resultado
			profesor = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return profesor;
	}

}
