package com.osdepym.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
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

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.dto.PersonaDTO;
import com.osdepym.service.TestService;


@Controller
public class HelloWorldController {
	
	protected ClassPathXmlApplicationContext context;
	
	private TestService service;

	@RequestMapping("/hello")
	public ModelAndView welcomeMessage(@RequestParam(value = "name", required = false) String name) {		
		// Name of your jsp file as parameter
		ModelAndView view = new ModelAndView("hello");
		view.addObject("name", name);
		return view;
	}
	
	@RequestMapping("/persona")
	public ModelAndView welcomePersona(@RequestParam(value = "name", required = false) String name) {
		
		service = ConfigurationEnviroment.getInstance().getContext().getBean(TestService.class);
		List<PersonaDTO> personasDTO = service.getAllPersonas();
		
		// Name of your jsp file as parameter
		ModelAndView view = new ModelAndView("persona");
		view.addObject("personas", personasDTO);
		return view;
	}
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") int id, Model model) {

		service = ConfigurationEnviroment.getInstance().getContext().getBean(TestService.class);
		PersonaDTO personaDTO = service.getPersonaById(id);
		
		if (personaDTO == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		
		model.addAttribute("persona", personaDTO);

		return "show";

	}
	
	// show add user form
	@RequestMapping(value = "/persona/{id}/update", method = RequestMethod.GET)
	public String showAddPersonForm(@PathVariable("id") Integer id,Model model) {

		service = ConfigurationEnviroment.getInstance().getContext().getBean(TestService.class);
		PersonaDTO personaDTO = service.getPersonaById(id);

		model.addAttribute("personaForm", personaDTO);
		model.addAttribute("cursoList", service.getAllCursosName());
		model.addAttribute("childrensList", service.getAllHijos());

		return "personaform";
	}
	
	@RequestMapping(value = "/persona/{id}/delete", method = RequestMethod.GET)
	public String deletePersona(@PathVariable("id") Integer id, Model model) {

		service = ConfigurationEnviroment.getInstance().getContext().getBean(TestService.class);
		service.deletePersona(id);

		return "redirect:/persona?name=Sally";
	}
	
	// show add user form
	@RequestMapping(value = "/persona/add", method = RequestMethod.GET)
	public String showAddPersonForm(Model model) {

		service = ConfigurationEnviroment.getInstance().getContext().getBean(TestService.class);

		model.addAttribute("personaForm", new PersonaDTO());
		model.addAttribute("cursoList", service.getAllCursosName());
		model.addAttribute("childrensList", service.getAllHijos());

		return "personaform";

	}
	
	// save or update user
	@RequestMapping(value = "/personaSave", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated PersonaDTO user,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "personaform";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			
			if(user.isNew()){
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			}else{
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}
			
			service = ConfigurationEnviroment.getInstance().getContext().getBean(TestService.class);
			
			if(user.isNew()) {
				service.savePersona(user);
			}else {
				service.updatePersona(user);
			}
			
			// POST/REDIRECT/GET
			return "redirect:/persona/" + user.getNroCliente();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}
		
}
