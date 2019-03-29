package com.osdepym.hibernate.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.hibernate.entity.Cursos;

@Repository
public class TestCursoDAOImpl implements TestCursoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Cursos> getAll() {
		List<Cursos> cursos = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			cursos = session.createQuery("FROM com.osdepym.hibernate.entity.Persona").list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cursos;
	}

	@Override
	public boolean save(Cursos curso) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(curso);
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
	public boolean delete(Cursos curso) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(curso);
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
	public boolean update(Cursos curso) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(curso);
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
	public Cursos get(long id) {
		Session session = null;
		Cursos persona = null;
		try {
			session = this.sessionFactory.openSession();
			Criteria cr = session.createCriteria(Cursos.class);
			cr.add(Restrictions.eq("id", id));
			List<Cursos> results = cr.list();
			if (results != null && results.size() > 0) {
				persona = results.get(0);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return persona;
	}
	
}
