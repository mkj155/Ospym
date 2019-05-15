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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osdepym.dto.AutorizacionDocDTO;
import com.osdepym.dto.FamiliaresACargoDTO;
import com.osdepym.dto.PrestacionDTO;
import com.osdepym.form.AutorizacionForm;
import com.osdepym.service.AutorizacionService;

@Controller
public class AutorizacionController {
	
	@Autowired
	@Qualifier("AutorizacionService")
	private AutorizacionService service;
	
	@RequestMapping(value = "/autorizacion/{idAfiliado}/{nombreAfiliado}", method = RequestMethod.GET)
	public ModelAndView loadAuthorizationForm(@PathVariable(value = "idAfiliado") String idAfiliado, @PathVariable(value = "nombreAfiliado") String nombreAfiliado, Model model) {
		ModelAndView view = getAuthorizationFormView(model, new AutorizacionForm(), idAfiliado, nombreAfiliado);
		return view;
	}
	
	@RequestMapping(value = "/autorizacion/send", method = RequestMethod.POST)
	public ModelAndView submitAuthorizationForm(@RequestParam("uploadFiles") MultipartFile[] uploadFiles, @ModelAttribute("autorizacionForm") @Validated AutorizacionForm autorizacionForm, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		ModelAndView view = null;
		try {
			if (result.hasErrors()) {
				view = getAuthorizationFormView(model, autorizacionForm, autorizacionForm.getIdAfiliado(), autorizacionForm.getNombreAfiliado());
			} else {
				String numeroTramite = service.procesarContacto(autorizacionForm, uploadFiles);
				view = new ModelAndView("autorizacionConExito");
				view.addObject("numeroTramite", numeroTramite);
				redirectAttributes.addFlashAttribute("css", "success");
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;	
	}
	
	@RequestMapping(value = "/autorizacion/*/*/getFamiliaresACargo")
	public @ResponseBody List<FamiliaresACargoDTO> getFamiliaresACargo(AutorizacionForm form) {
		List<FamiliaresACargoDTO> familiaresACargo = null;
		try {
			familiaresACargo = /*service.*/getFamiliaresACargoTest(form);
		} catch (Exception e) {
			
		}
		return familiaresACargo;
	}
	
	@RequestMapping(value = "/autorizacion/*/*/getPrestaciones")
	public @ResponseBody List<PrestacionDTO> getPrestacionesByEspecialidadId(@RequestBody String idEspecialidad) {
		List<PrestacionDTO> prestaciones = null;
		try {
			prestaciones = service.getPrestacionesByEspecialidadId(Integer.parseInt(idEspecialidad));
		} catch (Exception e) {
		}
		return prestaciones;
	}
	
	@RequestMapping(value = "/autorizacion/*/*/getDocumentos")
	public @ResponseBody List<String> getDocumentos(@RequestBody AutorizacionDocDTO obj) {
		List<String> documentos = null;
		try {
			documentos = service.getDocumentosByEspecialidadYPrestacion(obj.getIdEspecialidad(), obj.getIdPrestacion());
		} catch (Exception e) {
		}
		return documentos;
	}
	
	@RequestMapping(value = "/autorizacion/getDocumentos")
	public @ResponseBody List<String> getDocumentosAfterError(@RequestBody AutorizacionDocDTO obj) {
		List<String> documentos = null;
		try {
			documentos = service.getDocumentosByEspecialidadYPrestacion(obj.getIdEspecialidad(), obj.getIdPrestacion());
		} catch (Exception e) {
		}
		return documentos;
	}
	
	private ModelAndView getAuthorizationFormView(Model model, AutorizacionForm form, String idAfiliado, String nombreAfiliado) {
		ModelAndView view = null;
		try {
			form.setIdAfiliado(idAfiliado);
			form.setNombreAfiliado(nombreAfiliado);
			view = new ModelAndView("autorizacion");
			view.addObject("familiaresACargo", getFamiliaresACargo(form));
			view.addObject("especialidades", service.getAllEspecialidades());
			
			model.addAttribute("autorizacionForm", form);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
	
	private List<FamiliaresACargoDTO> getFamiliaresACargoTest(AutorizacionForm form) {
		List<FamiliaresACargoDTO> x = new ArrayList<FamiliaresACargoDTO>();
		int idAfiliado = Integer.valueOf(form.getIdAfiliado());
		x.add(new FamiliaresACargoDTO(idAfiliado, idAfiliado, form.getNombreAfiliado(), ""));
		x.add(new FamiliaresACargoDTO(2, idAfiliado, "Familiar 1", "A cargo 1"));
		x.add(new FamiliaresACargoDTO(3, idAfiliado, "Familiar 2", "A cargo 2"));
		x.add(new FamiliaresACargoDTO(4, idAfiliado, "Familiar 3", "A cargo 3"));
		x.add(new FamiliaresACargoDTO(5, idAfiliado, "Familiar 4", "A cargo 4"));
		x.add(new FamiliaresACargoDTO(6, idAfiliado, "Familiar 5", "A cargo 5"));
		return x;
	}
}
