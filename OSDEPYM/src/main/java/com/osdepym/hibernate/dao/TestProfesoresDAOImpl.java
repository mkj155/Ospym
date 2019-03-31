package com.osdepym.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
			profesores = session.createQuery("FROM com.osdepym.hibernate.entity.Profesores").list();
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
			Criteria cr = session.createCriteria(Profesores.class);
			cr.add(Restrictions.eq("id", id));
			List<Profesores> results = cr.list();
			if (results != null && results.size() > 0) {
				profesor = results.get(0);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return profesor;
	}

}
