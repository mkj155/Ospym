package com.osdepym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.osdepym.dto.PlanSeccionDTO;
import com.osdepym.service.PlanWebService;

@Controller
public class PlanController {
	@Autowired
	@Qualifier("PlanWebService")
	private PlanWebService service;
	
	@RequestMapping(value = "/plan/{idPlan}", method = RequestMethod.GET)
	public ModelAndView loadPlanConditions(@PathVariable(value = "idPlan") String idPlan) {
		ModelAndView view = null;
		try {
			List<PlanSeccionDTO> planSectionList = service.getSeccionesByPlan(Long.valueOf(idPlan));
			view = new ModelAndView("plan");
			view.addObject("planSectionList", planSectionList);
		} catch(Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
	
	
}
