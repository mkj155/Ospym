package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.PlanItem;

public interface PlanItemDAO extends Dao<PlanItem>{

	public List<PlanItem> getItemsByPlan(Long idPlan) throws CustomException;
}
