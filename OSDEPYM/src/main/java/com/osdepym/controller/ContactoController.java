package com.osdepym.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.dto.CategoriaDTO;
import com.osdepym.dto.MotivoDTO;
import com.osdepym.dto.PersonaDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.form.ContactoForm;
import com.osdepym.service.ContactoService;
import com.osdepym.validator.ContactoFormValidator;

@Controller
public class ContactoController {

	@Autowired
	@Qualifier("ContactService")
	private ContactoService service;
	
	@Autowired
	ContactoFormValidator contactFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(contactFormValidator);
	}
	
	private static final Logger logger = Logger.getLogger(ContactoController.class);
	
	private ModelAndView getViewContacto(String nombreAfiliado,String idAfiliado,ContactoForm form,Model model) {
		ModelAndView view;
		try {
			List<MotivoDTO> motivos = service.getAllMotivos();
			view = new ModelAndView("contacto");
			view.addObject("motivos", motivos);
			form.setNombreAfiliado(nombreAfiliado);
			form.setIdAfiliado(idAfiliado);
			model.addAttribute("contactoForm", form);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}

		return view;
	}
	
	
	@RequestMapping(value = "/contacto/{idAfiliado}/{nombreAfiliado}", method = RequestMethod.GET)
	public ModelAndView welcomeMessage(@PathVariable(value = "idAfiliado") String idAfiliado, @PathVariable(value = "nombreAfiliado") String nombreAfiliado, Model model) {
			return getViewContacto(nombreAfiliado, idAfiliado,new ContactoForm(), model);
	}
	
	@RequestMapping(value = "/contact/send", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateUser(@ModelAttribute("contactoForm") @Validated ContactoForm contactoForm, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		String response;

			if (result.hasErrors()) {
				return getViewContacto(contactoForm.getNombreAfiliado(), contactoForm.getIdAfiliado(),contactoForm, model);
			} else {
					redirectAttributes.addFlashAttribute("css", "success");
				return null;
			}
	}
	
	
	@RequestMapping(value = "/contacto/*/getCategorias")
	public @ResponseBody List<CategoriaDTO> getSearchResultViaAjax(@RequestBody String idMotivo) {
		List<CategoriaDTO> categorias = null;
		try {
			categorias = service.getCategoriasByMotivoId(Integer.parseInt(idMotivo));
		} catch (Exception e) {
			
		}
		return categorias;

	}
}
