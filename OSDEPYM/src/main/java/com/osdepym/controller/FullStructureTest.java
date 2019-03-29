package com.osdepym.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.osdepym.hibernate.dao.TestCursoDAOImpl;
import com.osdepym.service.TestService;

@Controller
public class FullStructureTest{

	
	protected ClassPathXmlApplicationContext context;
	
	private TestService service;
	

	@RequestMapping("/fullStructureTest")
	public ModelAndView displayCursos(@RequestParam(value = "letter", required = false) String letter) {		
		// Name of your jsp file as parameter
		context = new ClassPathXmlApplicationContext("spring.xml");
		service = context.getBean(TestService.class);
		service.getCursosByLetter("p");
		ModelAndView view = new ModelAndView("hello");
		return view;
	}
}
