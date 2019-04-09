package com.osdepym.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
import com.osdepym.exception.CustomException;
import com.osdepym.service.TestService;
import com.osdepym.service.TestServiceImpl;


@Controller
@Scope("session")
public class OsdepymController {
	
	@Autowired
	private TestService service;
	
	private static final Logger logger = Logger.getLogger(OsdepymController.class);
	
	@RequestMapping("/")
	public String welcomeMessage() {		
		return "redirect:/persona/";
	}
	
	@RequestMapping("/persona")
	public ModelAndView welcomePersona(@RequestParam(value = "name", required = false) String name,
			HttpServletRequest request) {
		ModelAndView view = null;
		try {
			request.getSession().setAttribute("VAS", "vas");
			List<PersonaDTO> personasDTO = service.getAllPersonas();
			view = new ModelAndView("persona");
			view.addObject("personas", personasDTO);
		} catch (CustomException e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		String response;
		try {
			String attInSession = (String) request.getSession().getAttribute("VAS");
			logger.info("Obtuve la variable en session: " + attInSession);
			logger.debug("Obtuve la variable en session: " + attInSession);
			logger.error("Obtuve la variable en session: " + attInSession);
			PersonaDTO personaDTO = service.getPersonaById(id);
			if (personaDTO == null) {
				model.addAttribute("css", "danger");
				model.addAttribute("msg", "User not found");
			}
			model.addAttribute("persona", personaDTO);
			response = "show";
		} catch (CustomException e) {
			response = "error";
			model.addAttribute("error", e);
		}
		return response;
	}
	
	@RequestMapping(value = "/persona/{id}/update", method = RequestMethod.GET)
	public String showAddPersonForm(@PathVariable("id") Integer id, Model model) {
		String response;
		try {
			PersonaDTO personaDTO = service.getPersonaById(id);

			model.addAttribute("personaForm", personaDTO);
			model.addAttribute("cursoList", service.getAllCursosName());
			model.addAttribute("childrensList", service.getAllHijos());

			response = "personaform";
		} catch (CustomException e) {
			response = "error";
			model.addAttribute("error", e);
		}
		return response;
	}
	
	@RequestMapping(value = "/persona/{id}/delete", method = RequestMethod.GET)
	public String deletePersona(@PathVariable("id") Integer id, Model model) {
		String response;
		try {
			service.deletePersona(id);
			response = "redirect:/persona?name=Sally";
		} catch (CustomException e) {
			response = "error";
			model.addAttribute("error", e);
		}
		return response;
	}
	
	@RequestMapping(value = "/persona/add", method = RequestMethod.GET)
	public String showAddPersonForm(Model model) {
		String response;
		try {
			model.addAttribute("personaForm", new PersonaDTO());
			model.addAttribute("cursoList", service.getAllCursosName());
			model.addAttribute("childrensList", service.getAllHijos());

			response = "personaform";
		} catch (CustomException e) {
			response = "error";
			model.addAttribute("error", e);
		}
		return response;
	}
	
	@RequestMapping(value = "/personaSave", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("personaForm") @Validated PersonaDTO personaDTO, BindingResult result, final RedirectAttributes redirectAttributes) {
		String response;
		try {
			if (result.hasErrors()) {
				return "personaform";
			} else {
				redirectAttributes.addFlashAttribute("css", "success");
				if(personaDTO.isNew()){
					redirectAttributes.addFlashAttribute("msg", "Persona agregada correctamente!");
				}else{
					redirectAttributes.addFlashAttribute("msg", "Persona actualizada correctamente!");
				}
				
				if(personaDTO.isNew()) {
					service.savePersona(personaDTO);
				}else {
					service.updatePersona(personaDTO);
				}
				
				response = "redirect:/persona/" + personaDTO.getNroCliente();
			}
		} catch (CustomException e) {
			response = "error";
		}
	return response;
	}
}
