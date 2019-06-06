package com.osdepym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.service.SolicitudesService;
import com.osdepym.util.ExcelWriter;

@Controller
public class SolicitudesController {
	
	@Autowired
	@Qualifier("SolicitudesService")
	private SolicitudesService service;

	@RequestMapping(value = "/busquedaAfiliado", method = RequestMethod.GET)
	public ModelAndView init(Model model) {
		ModelAndView view = getSolicitudesFormView(model, new SolicitudesForm());
		try {
			view = new ModelAndView("busquedaAfiliado");
		} catch(Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
	
	@RequestMapping(value = "/search")
	public @ResponseBody List<AfiliadoDTO> busquedaAfiliado(@RequestBody SolicitudesForm solicitudesForm) {
		List<AfiliadoDTO> afiliados = new ArrayList<AfiliadoDTO>();
		try {
			afiliados = service.buscarAfiliados(new AfiliadoDTO());
		} catch (Exception e) {
		}
		return afiliados;	
	}
	
	@RequestMapping(value = "/busquedaAfiliado/exportar", method = RequestMethod.POST)
	public ModelAndView exportar(@ModelAttribute("solicitudesForm") @Validated SolicitudesForm solicitudesForm, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		ModelAndView view = null;
		try {
			if (result.hasErrors()) {
				view = getSolicitudesFormView(model, solicitudesForm);
			} else {
				List<AfiliadoDTO> list = new ArrayList<AfiliadoDTO>();
				ExcelWriter.export(list);
				//view = new ModelAndView("busquedaAfiliado");
				//view.addObject("tablaAfiliados", afiliados);
				redirectAttributes.addFlashAttribute("css", "success");
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;	
	}
	
	private ModelAndView getSolicitudesFormView(Model model, SolicitudesForm form) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("solicitudes");
			view.addObject("lista1", null);
			view.addObject("lista2", null);
			
			model.addAttribute("solicitudesForm", form);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
}
