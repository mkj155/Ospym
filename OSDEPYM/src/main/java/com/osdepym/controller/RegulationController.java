package com.osdepym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegulationController {
	/*@Autowired
	@Qualifier("RegulationService")
	private RegulationService service; */
	
	@RequestMapping(value = "/reglamento/{idPlan}", method = RequestMethod.GET)
	public ModelAndView loadTypeAffiliate(@PathVariable(value = "idPlan") String idPlan) {
		ModelAndView view = null;
		try {
			String typeAffiliate = /*service.*/getTypeAffiliate(idPlan);
			view = new ModelAndView("reglamento");
			view.addObject("type", typeAffiliate);
		} catch(Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
	
	private String getTypeAffiliate(String idPlan) {
		return "Obligatorio";
	}
}
