package com.osdepym.hibernate.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EspecialidadDAOImpl{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	


	
	public List<Categoria> getAll() {
		List<Categoria> categorias = null;
		try {
			categorias = null;
			Session session = this.sessionFactory.getCurrentSession();
			categorias = session.createQuery("FROM com.osdepym.hibernate.entity.Categoria", Categoria.class).list();
			return categorias;
		}catch(Exception e){
			e.printStackTrace();
		}
		return categorias;
	}

	
}
