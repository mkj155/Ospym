package com.osdepym.service;

import java.util.List;
import com.osdepym.dto.PlanSeccionDTO;
import com.osdepym.exception.CustomException;

public interface PlanWebService {

	public List<PlanSeccionDTO> getSeccionesByPlan(Long idPlan) throws CustomException;
	
}
