package com.osdepym.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.osdepym.hibernate.entity.Cursos;

@Repository("testCursoDAO")
public class TestCursoDAOImpl implements TestCursoDAO{

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Cursos> getAll() {
		List<Cursos> cursos = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();
			cursos = session.createQuery("FROM com.osdepym.hibernate.entity.Cursos", Cursos.class).list();
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
	public Cursos get(Integer id) {
		Session session = null;
		Cursos curso = null;
		try {
			session = this.sessionFactory.openSession();
			// creando query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Cursos> criteria = builder.createQuery(Cursos.class);
			Root<Cursos> root = criteria.from(Cursos.class);
			criteria.select(root).where(builder.equal(root.get("idCurso"), id));
			Query<Cursos> query = session.createQuery(criteria);
			// obteniendo resultado
			curso = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return curso;
	}
	
}
