package com.osdepym.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osdepym.dto.CategoriaDTO;
import com.osdepym.form.ContactoForm;
import com.osdepym.form.ImpExpForm;

@Controller
public class ImpExpController {

	// http://localhost:8080/OSDEPYM/impExp
	
	@RequestMapping(value = "/impExp", method = RequestMethod.GET)
	public ModelAndView loadContactoForm(Model model) {
		ModelAndView view = getImpExpFormView(model, new ImpExpForm());
		return view;
	}
	
	private ModelAndView getImpExpFormView(Model model, ImpExpForm form) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("mainSolicitud");
			model.addAttribute("impExpForm", form);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
	
	@RequestMapping(value = "/impExp/showGrid", method = RequestMethod.POST)
	public ModelAndView submitContactoForm(@ModelAttribute("impExpForm") @Validated ContactoForm contactoForm, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		ModelAndView view = null;
		try {
			if (result.hasErrors()) {
				// view = getContactoFormView(model, contactoForm, contactoForm.getNombreAfiliado(), contactoForm.getIdAfiliado());
			} else {
//				String numeroTramite = service.procesarContacto(contactoForm);
				view = new ModelAndView("showGrid");
//				view.addObject("numeroTramite", numeroTramite);
				redirectAttributes.addFlashAttribute("css", "success");
			}
		}catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	
	}
	
}
