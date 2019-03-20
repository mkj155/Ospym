package com.osdepym.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.osdepym.model.TestPersona;

public class TestPersonaDAOImpl implements TestPersonaDAO {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<TestPersona> listarPersonas() {
		List<TestPersona> testPersona = null;
		try {
			Session session = this.sessionFactory.openSession();
			testPersona = session.createQuery("FROM TESTPERSONA").list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testPersona;
	}

	@Override
	public boolean savePersona(TestPersona testPersona) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(testPersona);
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
	public boolean deletePersona(TestPersona testPersona) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(testPersona);
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
	
}
