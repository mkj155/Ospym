package com.osdepym.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.TipoCarga;

@Repository
public class TipoCargaDAOImpl implements TipoCargaDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public TipoCarga get(Long id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoCarga> getAll() throws CustomException {
		List<TipoCarga> tipoCargaList = new ArrayList<TipoCarga>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT TipoCarga_ID, DescripcionTipoCarga, RequiereTipoAfiliado, NombrePlantillaXLS FROM ga.vo_TipoCarga";
			tipoCargaList = session.createNativeQuery(sqlString, TipoCarga.class).getResultList();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		
		return tipoCargaList;
	}

	@Override
	public void save(TipoCarga t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TipoCarga t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TipoCarga t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

}
