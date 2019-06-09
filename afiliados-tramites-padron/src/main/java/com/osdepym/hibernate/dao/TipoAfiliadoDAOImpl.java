package com.osdepym.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.TipoAfiliado;

@Repository
public class TipoAfiliadoDAOImpl implements TipoAfiliadoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public TipoAfiliado get(Long id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoAfiliado> getAll() throws CustomException {
		List<TipoAfiliado> tipoAfiliadoList = new ArrayList<TipoAfiliado>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT TipoAfiliado_ID, DescripcionTipoAfiliado, RequiereCUIT FROM ga.vo_TipoAfiliado";
			tipoAfiliadoList = session.createNativeQuery(sqlString, TipoAfiliado.class).getResultList();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		
		return tipoAfiliadoList;
	}

	@Override
	public void save(TipoAfiliado t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TipoAfiliado t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TipoAfiliado t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

}
