package com.osdepym.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Profesores;

public class TestProfesoresDAOImpl implements TestProfesoresDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return list of all Profesores
     * @throws CustomException
     */
	@Override
	public List<Profesores> getAll() throws CustomException{
		try {
			List<Profesores> profesores = null;
			Session session = this.sessionFactory.getCurrentSession();
			profesores = session.createQuery("FROM com.osdepym.hibernate.entity.Profesores", Profesores.class).list();
			return profesores;
		}catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	/**
	 * @param profesor
	 * @throws CustomException
	 */
	@Override
	public void save(Profesores profesor) throws CustomException{
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(profesor);
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}
	/**
	 * @param profesor
	 * @throws CustomException
	 */
	@Override
	public void delete(Profesores profesor) throws CustomException{
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(profesor);
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_DELETE_ERROR);
		}
	}
	/**
	 * @param profesor
	 * @throws CustomException
	 */
	@Override
	public void update(Profesores profesor) throws CustomException{
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(profesor);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}
	/**
	 * @param id
	 * @return profesor
	 * @throws CustomException
	 */
	@Override
	public Profesores get(Integer id) throws CustomException{
		try {
			Profesores profesor = null;
			Session session = this.sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Profesores> criteria = builder.createQuery(Profesores.class);
			Root<Profesores> root = criteria.from(Profesores.class);
			criteria.select(root).where(builder.equal(root.get("idProfesor"), id));
			Query<Profesores> query = session.createQuery(criteria);
			profesor = query.getSingleResult();
			return profesor;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		} 
		
	}


}
