package com.osdepym.hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.PlanItem;

@Repository
public class PlanItemDAOImpl implements PlanItemDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public List<PlanItem> getAll() throws CustomException {
		try {
			List<PlanItem> planItems = null;
			Session session = this.sessionFactory.getCurrentSession();
			planItems = session.createQuery("FROM com.osdepym.hibernate.entity.PlanItem", PlanItem.class).list();
			return planItems;
		}catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
	

	@Override
	public PlanItem get(Long id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(PlanItem t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PlanItem t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PlanItem t) throws CustomException {
		// TODO Auto-generated method stub
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PlanItem> getItemsByPlan(String idPlan) throws CustomException {
		List<PlanItem> items = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "FROM com.osdepym.hibernate.entity.PlanItem WHERE ID_PLAN = '%s' ORDER BY ID_PLAN_ITEM";
			sqlString = String.format(sqlString, idPlan);
			Query query = session.createQuery(sqlString, PlanItem.class);
			items = query.getResultList();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return items;
	}
}
