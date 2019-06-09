package com.osdepym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.osdepym.dto.AfiliadoTableDTO;
import com.osdepym.dto.EstadoDTO;
import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.service.SolicitudesService;

@Controller
public class SolicitudesController {
	
	@Autowired
	@Qualifier("SolicitudesService")
	private SolicitudesService service;

	@RequestMapping(value = "/solicitudes", method = RequestMethod.GET)
	public ModelAndView init(Model model) {
		ModelAndView view = getSolicitudesFormView(model, new SolicitudesForm());
		return view;
	}
	
	@RequestMapping(value = "/solicitudes/buscar")
	public @ResponseBody List<AfiliadoTableDTO> buscar(@RequestBody SolicitudesForm element) {
		List<AfiliadoTableDTO> afiliados = new ArrayList<AfiliadoTableDTO>();
		try {
			afiliados = service.buscar(element);
		} catch (Exception e) {
		}
		return afiliados;	
	}
	
	/*@RequestMapping(value = "/busqueda/exportar", method = RequestMethod.POST)
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
	}*/
	
	private ModelAndView getSolicitudesFormView(Model model, SolicitudesForm form) {
		ModelAndView view = null;
		try {
			view = new ModelAndView("solicitudes");
			List<ObraSocialDTO> a = service.getAllObrasSociales();
			view.addObject("obrassociales", a);
			List<EstadoDTO> b = service.getAllEstados();
			view.addObject("estados", b);
			
			model.addAttribute("solicitudesForm", form);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
}
