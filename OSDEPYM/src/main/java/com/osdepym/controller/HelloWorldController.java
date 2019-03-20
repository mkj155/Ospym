package com.osdepym.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.osdepym.dao.TestPersonaDAO;
import com.osdepym.model.TestPersona;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView welcomeMessage(@RequestParam(value = "name", required = false) String name) {
		
		// DAMIAN TEST
		testingHibernate();
		// FIN DAMIAN TEST
		
		// Name of your jsp file as parameter
		ModelAndView view = new ModelAndView("hello");
		view.addObject("name", name);
		return view;
	}
	
	public void testingHibernate() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		TestPersonaDAO personDAO = context.getBean(TestPersonaDAO.class);
		
		TestPersona testPersona = new TestPersona();
		testPersona.setNombre("Maria");
		testPersona.setApellido("Romero");
		testPersona.setDireccion("Rivadavia 222 1°B");
		testPersona.setCiudad("San Isidro");
		testPersona.setFechaNacimiento(new Date("06/09/1983"));
		testPersona.setNroCliente(5008);
		
		System.out.println("Agregamos una persona");
		personDAO.savePersona(testPersona);
		System.out.println("Persona: " + testPersona.getNombre());
		
		List<TestPersona> listaPersonas = personDAO.listarPersonas();
		
		System.out.println("Mostramos todas las personas");
		for(TestPersona persona : listaPersonas){
			System.out.println("Person List: " + persona.getNombre());
		}
		
		System.out.println("Borramos a todas las personas");
		for(TestPersona persona : listaPersonas){
			personDAO.deletePersona(persona);
		}		

		System.out.println("Intentamos mostramos todas las personas despues de borrarlas");
		for(TestPersona persona : listaPersonas){
			System.out.println("Person List: " + persona.getNombre());
		}
		
		context.close();
		
	}
	
}
