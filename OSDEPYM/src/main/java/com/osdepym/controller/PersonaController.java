package com.osdepym.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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

@Controller
@Scope("session")
public class PersonaController {

	private TestService service = ConfigurationEnviroment.getInstance().getContext().getBean(TestService.class);
	private static final Logger logger = Logger.getLogger(PersonaController.class);

	@RequestMapping("/hello")
	public ModelAndView welcomeMessage(@RequestParam(value = "name", required = false) String name) {
		ModelAndView view = new ModelAndView("hello");
		view.addObject("name", name);
		return view;
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
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated PersonaDTO user, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {
		String response;
		try {
			if (result.hasErrors()) {
				return "personaform";
			} else {
				redirectAttributes.addFlashAttribute("css", "success");
				if (user.isNew()) {
					redirectAttributes.addFlashAttribute("msg", "User added successfully!");
				} else {
					redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
				}

				if (user.isNew()) {
					service.savePersona(user);
				} else {
					service.updatePersona(user);
				}

				// POST/REDIRECT/GET
				response = "redirect:/persona/" + user.getNroCliente();
			}
		} catch (CustomException e) {
			response = "error";
			model.addAttribute("error", e);
		}
		return response;
	}

}
