package com.osdepym.hibernate.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.hibernate.entity.Hijos;
import com.osdepym.hibernate.entity.Persona;

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
	public boolean save(Hijos hijo) {

		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(hijo);
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
	
	public int deleteHijosByPerson(Integer id) {
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			/* Obtengo todos los hijos, a partir del id de la persona */
			Transaction tx = session.beginTransaction();
			List<Hijos> hijos = (List<Hijos>) session.createCriteria(Hijos.class)
	                    .add(Restrictions.eq("persona.id", id)).list();
			/* Borro los hijos anteriores, para luego insertar los nuevos hijos */
			if(hijos != null) {
				for(Hijos hijo : hijos) {
					session.delete(hijo);
				}				
			}

			 tx.commit();
			 session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		
		return 0;
	}

	@Override
	public boolean delete(Hijos hijo) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(hijo);
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
	public boolean update(Hijos hijo) {
		boolean result;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(hijo);
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
		Hijos hijo = null;
	try {
		Session session = this.sessionFactory.openSession();
		hijo = session.find(Hijos.class, id);
		session.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		return hijo;
	}
	
}
