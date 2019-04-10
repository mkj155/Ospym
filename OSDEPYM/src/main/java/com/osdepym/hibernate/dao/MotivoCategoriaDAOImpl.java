package com.osdepym.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Categoria;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.MotivoCategoria;

public class MotivoCategoriaDAOImpl implements MotivoCategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public MotivoCategoria get(Integer id) throws CustomException {
		return null;
	}

	@Override
	public List<MotivoCategoria> getAll() throws CustomException {
		try {
			List<MotivoCategoria> motivoCategoria = null;
			Session session = this.sessionFactory.getCurrentSession();
			motivoCategoria = session.createQuery("FROM com.osdepym.hibernate.entity.MotivoCategoria", MotivoCategoria.class).list();
			return motivoCategoria;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
	
	@Override
	public void save(MotivoCategoria t) throws CustomException {
	}

	@Override
	public void update(MotivoCategoria t) throws CustomException {
	}

	@Override
	public void delete(MotivoCategoria t) throws CustomException {
	}

	@Override
	public Integer getSecuence() throws CustomException {
		Integer secuence;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String queryString = "SELECT NEXT VALUE FOR contacto_seq AS sequenceValue";
			Query query = session.createNativeQuery(queryString).addScalar("sequenceValue", StandardBasicTypes.INTEGER);
			secuence = (Integer) query.getSingleResult();
			return secuence;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	@Override
	public void saveContacto(Contacto contacto) throws CustomException {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(contacto);
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SAVE_ERROR);
		}
	}

	@Override
	public List<Categoria> getCategoriasByMotivoId(int idMotivo) throws CustomException {
		try {
			List<Categoria> categorias = new ArrayList<Categoria>();
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT C.* FROM CATEG_CONTACTO C INNER JOIN MOTIVO_CATEGORIA MC ON MC.IDCATEG = C.IDCATEG WHERE MC.IDMOTIVO = " + idMotivo;
			Query query = session.createNativeQuery(sqlString, Categoria.class);
			categorias = query.getResultList();
			return categorias;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
	
	
//	try {
//		Cursos curso = null;
//		Session session = this.sessionFactory.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Cursos> criteria = builder.createQuery(Cursos.class);
//		Root<Cursos> root = criteria.from(Cursos.class);
//		criteria.select(root).where(builder.equal(root.get("idCurso"), id));
//		Query<Cursos> query = session.createQuery(criteria);
//		curso = query.getSingleResult();
//		tx.commit();
//		return curso;
//	} catch (Exception e) {
//		throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
//	}

}
