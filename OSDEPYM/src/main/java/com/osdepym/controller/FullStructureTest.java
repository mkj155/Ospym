package com.osdepym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.osdepym.dto.TestDTO;
import com.osdepym.hibernate.dao.TestCursoDAOImpl;
import com.osdepym.service.TestService;

@Controller
public class FullStructureTest{

	
	protected ClassPathXmlApplicationContext context;
	

	@RequestMapping("/fullStructureTest")
	public ModelAndView displayCursos(@RequestParam(value = "letter", required = false) String letter) {		
		// Name of your jsp file as parameter
		context = new ClassPathXmlApplicationContext("spring.xml");
		TestCursoDAOImpl dao = context.getBean(TestCursoDAOImpl.class);
		dao.getAll();
		ModelAndView view = new ModelAndView("fullStructureTest");
		//List<TestDTO> testDTO = testService.getCursosByLetter(letter);
		//view.addObject("cursos", testDTO);
		return view;
	}
}
