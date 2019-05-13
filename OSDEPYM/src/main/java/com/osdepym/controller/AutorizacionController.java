package com.osdepym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osdepym.dto.PrestacionDTO;
import com.osdepym.form.AutorizacionForm;
import com.osdepym.service.AutorizacionService;

@Controller
public class AutorizacionController {
	
	@Autowired
	@Qualifier("AutorizacionService")
	private AutorizacionService service;
	
	@RequestMapping(value = "/autorizacion/{idAfiliado}", method = RequestMethod.GET)
	public ModelAndView loadAuthorizationForm(@PathVariable(value = "idAfiliado") String idAfiliado, Model model) {
		ModelAndView view = getAuthorizationFormView(model, new AutorizacionForm(), idAfiliado);
		return view;
	}
	
	@RequestMapping(value = "/autorizacion/send", method = RequestMethod.POST)
	public ModelAndView submitAuthorizationForm(@ModelAttribute("autorizacionForm") @Validated AutorizacionForm autorizacionForm, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		ModelAndView view = null;
		try {
			if (result.hasErrors()) {
				view = getAuthorizationFormView(model, autorizacionForm, autorizacionForm.getIdAfiliado());
			} else {
				autorizacionForm.setNombreAfiliado("test nmombre afiliado");
				String numeroTramite = service.procesarContacto(autorizacionForm);
				view = new ModelAndView("autorizacionConExito");
				view.addObject("numeroTramite", numeroTramite);
				redirectAttributes.addFlashAttribute("css", "success");
			}
		}catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	
	}
	

	@RequestMapping(value = "/autorizacion/getPrestaciones")
	public @ResponseBody List<PrestacionDTO> getPrestacionesByEspecialidadId(@RequestBody String idEspecialidad) {
		List<PrestacionDTO> prestaciones = null;
		try {
			prestaciones = service.getPrestacionesByEspecialidadId(Integer.parseInt(idEspecialidad));
		} catch (Exception e) {
		}
		return prestaciones;
	}
	
	
	
	
	private ModelAndView getAuthorizationFormView(Model model, AutorizacionForm form, String idAfiliado) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("autorizacion");
			view.addObject("especialidades", service.getAllEspecialidades());
			form.setIdAfiliado(idAfiliado);
			model.addAttribute("autorizacionForm", form);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
}
