package com.osdepym.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Pauta;

@Repository
public class PautaDaoImpl implements PautaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Pauta get(Long id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pauta> getAll() throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pauta t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pauta t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pauta t) throws CustomException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Pauta> getByCUIT(String cuitNumber) throws CustomException {
		try {
			List<Pauta> pautas = new ArrayList<Pauta>();
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT P.* FROM ga.vo_Pauta P WHERE CUIT ='" + cuitNumber + "'";
			pautas = session.createNativeQuery(sqlString, Pauta.class).getResultList();
			return pautas;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}


}
