package com.osdepym.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
			hijos = session.createQuery("FROM com.osdepym.hibernate.entity.Hijos", Hijos.class).list();
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
			// creando query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Hijos> criteria = builder.createQuery(Hijos.class);
			Root<Hijos> root = criteria.from(Hijos.class);
			criteria.select(root).where(builder.equal(root.get("nombre"), nombre),builder.equal(root.get("apellido"), apellido));
			Query<Hijos> query = session.createQuery(criteria);
			// obteniendo resultado
			hijo = query.getSingleResult();
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
