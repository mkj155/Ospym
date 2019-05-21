package com.osdepym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegulationController {
	
	@RequestMapping(value = "/reglamento/{typeAffiliate}", method = RequestMethod.GET)
	public ModelAndView loadTypeAffiliate(@PathVariable(value = "typeAffiliate") String typeAffiliate) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("reglamento");
			view.addObject("type", StringUtils.capitalize(typeAffiliate));
		} catch(Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
}
