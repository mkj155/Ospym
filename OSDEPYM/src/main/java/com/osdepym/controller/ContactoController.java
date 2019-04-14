package com.osdepym.controller;

import java.util.List;

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

import com.osdepym.dto.CategoriaDTO;
import com.osdepym.dto.MotivoDTO;
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
	
	
	@RequestMapping(value = "/contacto/{idAfiliado}/{nombreAfiliado}", method = RequestMethod.GET)
	public ModelAndView loadContactoForm(@PathVariable(value = "idAfiliado") String idAfiliado, @PathVariable(value = "nombreAfiliado") String nombreAfiliado, Model model) {
		ModelAndView view = null;
		try {
			List<MotivoDTO> motivos = service.getAllMotivos();
			view = new ModelAndView("contacto");
			view.addObject("motivos", motivos);
			ContactoForm form = new ContactoForm();
			form.setNombreAfiliado(nombreAfiliado);
			form.setIdAfiliado(idAfiliado);
			model.addAttribute("contactoForm", form);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
	
	@RequestMapping(value = "/contact/send", method = RequestMethod.POST)
	public ModelAndView submitContactoForm(@ModelAttribute("contactoForm") @Validated ContactoForm contactoForm, BindingResult result, final RedirectAttributes redirectAttributes) {
		ModelAndView view = null;
		try {
			String numeroTramite = service.procesarContacto(contactoForm);
			view = new ModelAndView("contactoConExito");
			view.addObject("numeroTramite", numeroTramite);
		}catch (Exception e) {
				view = new ModelAndView("error");
				view.addObject("error", e);
		}
		return view;
	
	}
	
	
	@RequestMapping(value = "/contacto/*/getCategorias")
	public @ResponseBody List<CategoriaDTO> getCategoriasByMotivoId(@RequestBody String idMotivo) {
		List<CategoriaDTO> categorias = null;
		try {
			categorias = service.getCategoriasByMotivoId(Integer.parseInt(idMotivo));
		} catch (Exception e) {
			
		}
		
		return categorias;

	}
	
	
}
