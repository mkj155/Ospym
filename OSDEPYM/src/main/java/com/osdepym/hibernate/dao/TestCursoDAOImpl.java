package com.osdepym.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Cursos;

@Repository("testCursoDAO")
public class TestCursoDAOImpl implements TestCursoDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return list of all Cursos
	 * @throws CustomException
	 */
	@Override
	public List<Cursos> getAll() throws CustomException {
		try {
			List<Cursos> cursos = null;
			Session session = this.sessionFactory.getCurrentSession();
			cursos = session.createQuery("FROM com.osdepym.hibernate.entity.Cursos", Cursos.class).list();
			return cursos;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	/**
	 * @param curso
	 * @throws CustomException
	 */
	@Override
	public void save(Cursos curso) throws CustomException {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(curso);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}

	/**
	 * @param curso
	 * @throws CustomException
	 */
	@Override
	public void delete(Cursos curso) throws CustomException {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(curso);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_DELETE_ERROR);
		}
	}

	/**
	 * @param curso
	 * @throws CustomException
	 */
	@Override
	public void update(Cursos curso) throws CustomException {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(curso);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}

	/**
	 * @param id
	 * @return curso
	 * @throws CustomException
	 */
	@Override
	public Cursos get(Integer id) throws CustomException {
		try {
			Cursos curso = null;
			Session session = this.sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Cursos> criteria = builder.createQuery(Cursos.class);
			Root<Cursos> root = criteria.from(Cursos.class);
			criteria.select(root).where(builder.equal(root.get("idCurso"), id));
			Query<Cursos> query = session.createQuery(criteria);
			curso = query.getSingleResult();
			return curso;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}

	}

}
