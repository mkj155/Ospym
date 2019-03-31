package com.osdepym.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.hibernate.entity.Hijos;

@Repository
public class HijosDAOImpl implements HijosDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Hijos> getAll() {
		List<Hijos> hijos = null;
		try {
			Session session = this.sessionFactory.openSession();
			hijos = session.createQuery("FROM com.osdepym.hibernate.entity.Hijos").list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hijos;
	
	}

	@Override
	public boolean save(Hijos hijo) {return true;}

	@Override
	public boolean delete(Hijos curso) {return true;}

	@Override
	public boolean update(Hijos curso) {return true;}

	
	public Hijos getHijoByNombreAndApellido(String nombre,String apellido) {
		Session session = null;
		Hijos hijo = null;
		try {
			session = this.sessionFactory.openSession();
			Criteria cr = session.createCriteria(Hijos.class);
			cr.add(Restrictions.eq("nombre", nombre));
			cr.add(Restrictions.eq("apellido", apellido));
			List<Hijos> results = cr.list();
			if (results != null && results.size() > 0) {
				hijo = results.get(0);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return hijo;
	}

	@Override
	public Hijos get(Integer id) {
		return new Hijos();
	}
	
}
