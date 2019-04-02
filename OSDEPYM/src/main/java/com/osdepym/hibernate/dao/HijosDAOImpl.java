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

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Hijos;

@Repository
public class HijosDAOImpl implements HijosDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
     * @return list of all Hijos
     * @throws CustomException
     */
	@Override
	public List<Hijos> getAll() throws CustomException{
		try {
			List<Hijos> hijos = null;
			Session session = this.sessionFactory.getCurrentSession();
			hijos = session.createQuery("FROM com.osdepym.hibernate.entity.Hijos", Hijos.class).list();
			return hijos;
		}catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	/**
	 * @param hijo
	 * @throws CustomException
	 */
	@Override
	public void save(Hijos hijo) throws CustomException{
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(hijo);
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}
	/**
	 * @param hijo
	 * @throws CustomException
	 */
	@Override
	public void delete(Hijos hijo) throws CustomException{
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(hijo);
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_DELETE_ERROR);
		}
	}
	/**
	 * @param hijo
	 * @throws CustomException
	 */
	@Override
	public void update(Hijos hijo) throws CustomException{
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(hijo);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}
	/**
	 * @param id
	 * @return hijo
	 * @throws CustomException
	 */
	@Override
	public Hijos get(Integer id) throws CustomException{
		try {
			Hijos hijo = null;
			Session session = this.sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Hijos> criteria = builder.createQuery(Hijos.class);
			Root<Hijos> root = criteria.from(Hijos.class);
			criteria.select(root).where(builder.equal(root.get("idHijo"), id));
			Query<Hijos> query = session.createQuery(criteria);
			hijo = query.getSingleResult();
			return hijo;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		} 
		
	}


	/**
	 * @param nombre, apellido
	 * @return hijo
	 * @throws CustomException
	 */
	public Hijos getHijoByNombreAndApellido(String nombre,String apellido) throws CustomException{
		try {
			Hijos hijo = null;
			Session session = this.sessionFactory.getCurrentSession();
			// creando query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Hijos> criteria = builder.createQuery(Hijos.class);
			Root<Hijos> root = criteria.from(Hijos.class);
			criteria.select(root).where(builder.equal(root.get("nombre"), nombre),builder.equal(root.get("apellido"), apellido));
			Query<Hijos> query = session.createQuery(criteria);
			// obteniendo resultado
			hijo = query.getSingleResult();
			return hijo;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		} 
		
	}

	
}
