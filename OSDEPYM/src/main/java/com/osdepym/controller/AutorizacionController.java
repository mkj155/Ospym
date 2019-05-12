package com.osdepym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osdepym.form.AutorizacionForm;

@Controller
public class AutorizacionController {
	
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
				String numeroTramite = "11111";//service.procesarContacto(contactoForm);
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
	
	private ModelAndView getAuthorizationFormView(Model model, AutorizacionForm form, String idAfiliado) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("autorizacion");
			form.setIdAfiliado(idAfiliado);
			model.addAttribute("autorizacionForm", form);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
}
