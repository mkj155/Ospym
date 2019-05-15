package com.osdepym.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Beneficiario;

@Repository
public class BeneficiarioDAOImpl implements BeneficiarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Beneficiario get(Integer id) throws CustomException {
		return null;
	}

	@Override
	public void save(Beneficiario t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Beneficiario t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Beneficiario t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Beneficiario> getAll() throws CustomException {
		try {
			List<Beneficiario> beneficiario = null;
			Session session = this.sessionFactory.getCurrentSession();
			beneficiario = session.createQuery("FROM com.osdepym.hibernate.entity.Beneficiario", Beneficiario.class).list();
			return beneficiario;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
	
	@Override
	public List<Beneficiario> getBeneficiariosByIdAfiliado(int idAfiliado) throws CustomException {
		try {
			List<Beneficiario> b = new ArrayList<Beneficiario>();
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT Id_Afiliado, Id_Titular, Apellido, Nombre FROM dbo.v_familiares_a_cargo WHERE Id_Titular = " + idAfiliado;
			b = session.createNativeQuery(sqlString, Beneficiario.class).getResultList();
			return b;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
}
