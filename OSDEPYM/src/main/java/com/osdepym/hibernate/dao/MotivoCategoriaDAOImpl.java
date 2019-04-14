package com.osdepym.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Categoria;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.MotivoCategoria;

@Repository
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
			String sqlString = "SELECT C.* FROM CATEGORIAS C INNER JOIN MOTIVOS_CATEGORIAS MC ON MC.ID_CATEGORIA = C.ID_CATEGORIA WHERE MC.ID_MOTIVO = " + idMotivo;
			Query query = session.createNativeQuery(sqlString, Categoria.class);
			categorias = query.getResultList();
			return categorias;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	@Override
	public String getMailByIds(String idMotivo, String idCategoria) throws CustomException {
		String mail = "";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT CORREO FROM MOTIVOS_CATEGORIAS WHERE ID_MOTIVO = %s AND ID_CATEGORIA = %s";
			sqlString = String.format(sqlString, idMotivo, idCategoria);
			Query query = session.createNativeQuery(sqlString);
			mail = query.getSingleResult().toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return mail;
	}

	@Override
	public String getMotivoById(String idMotivo) throws CustomException {
		String motivo = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT ETIQUETA FROM MOTIVOS WHERE ID_MOTIVO = %s";
			sqlString = String.format(sqlString, idMotivo);
			Query query = session.createNativeQuery(sqlString);
			motivo = query.getSingleResult().toString();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return motivo;
	}

	@Override
	public String getCategoriaById(String idCategoria) throws CustomException {
		String categoria = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT ETIQUETA FROM CATEGORIAS WHERE ID_CATEGORIA = %s";
			sqlString = String.format(sqlString, idCategoria);
			Query query = session.createNativeQuery(sqlString);
			categoria = query.getSingleResult().toString();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return categoria;
	}

}