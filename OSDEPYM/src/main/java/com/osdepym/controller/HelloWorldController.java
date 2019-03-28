package com.osdepym.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osdepym.hibernate.model.Persona;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView welcomeMessage(@RequestParam(value = "name", required = false) String name) {		
		// Name of your jsp file as parameter
		ModelAndView view = new ModelAndView("hello");
		view.addObject("name", name);
		return view;
	}
	
	@RequestMapping("/persona")
	public ModelAndView welcomePersona(@RequestParam(value = "name", required = false) String name) {
		
		Persona testPersona = new Persona();
		testPersona.setNombre("Maria");
		testPersona.setApellido("Romero");
		testPersona.setDireccion("Rivadavia 222 1°B");
		testPersona.setCiudad("San Isidro");
		testPersona.setFechaNacimiento(new Date("06/09/1983"));
		testPersona.setNroCliente(5008);
		
		List<Persona> testPersonas = new ArrayList<Persona>();
		testPersonas.add(testPersona);
		
		// Name of your jsp file as parameter
		ModelAndView view = new ModelAndView("persona");
		view.addObject("personas", testPersonas);
		view.addObject("name", name);
		return view;
	}
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") int id, Model model) {

		Persona testPersona = new Persona();
		testPersona.setNombre("Maria");
		testPersona.setApellido("Romero");
		testPersona.setDireccion("Rivadavia 222 1°B");
		testPersona.setCiudad("San Isidro");
		testPersona.setFechaNacimiento(new Date("06/09/1983"));
		testPersona.setNroCliente(5008);
		
		if (testPersona == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		
		model.addAttribute("persona", testPersona);

		return "show";

	}
	
	// show add user form
	@RequestMapping(value = "/persona/add", method = RequestMethod.GET)
	public String showAddPersonForm(Model model) {

		Persona testPersona = new Persona();
		testPersona.setNombre("Maria");
		testPersona.setApellido("Romero");
		testPersona.setDireccion("Rivadavia 222 1°B");
		testPersona.setCiudad("San Isidro");
		testPersona.setFechaNacimiento(new Date("06/09/1983"));
		testPersona.setNroCliente(5008);

		model.addAttribute("personaForm", testPersona);

		populateDefaultModel(model);

		return "personaform";

	}
	
	private void populateDefaultModel(Model model) {

		List<String> frameworksList = new ArrayList<String>();
		frameworksList.add("Spring MVC");
		frameworksList.add("Struts 2");
		frameworksList.add("JSF 2");
		frameworksList.add("GWT");
		frameworksList.add("Play");
		frameworksList.add("Apache Wicket");
		model.addAttribute("frameworkList", frameworksList);

		Map<String, String> skill = new LinkedHashMap<String, String>();
		skill.put("Hibernate", "Hibernate");
		skill.put("Spring", "Spring");
		skill.put("Struts", "Struts");
		skill.put("Groovy", "Groovy");
		skill.put("Grails", "Grails");
		model.addAttribute("javaSkillList", skill);

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		model.addAttribute("numberList", numbers);

		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		model.addAttribute("countryList", country);

	}
	
		// save or update user
		@RequestMapping(value = "/personaSave", method = RequestMethod.POST)
		public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated Persona user,
				BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

			if (result.hasErrors()) {
				populateDefaultModel(model);
				return "personaform";
			} else {

				redirectAttributes.addFlashAttribute("css", "success");
				
				if(user.isNew()){
					redirectAttributes.addFlashAttribute("msg", "User added successfully!");
				}else{
					redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
				}
				
				//userService.saveOrUpdate(user);
				
				// POST/REDIRECT/GET
				return "redirect:/persona/" + user.getNroCliente();

				// POST/FORWARD/GET
				// return "user/list";

			}

		}
		
}
