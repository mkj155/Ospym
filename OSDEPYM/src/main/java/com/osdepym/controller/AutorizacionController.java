package com.osdepym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.osdepym.dto.BeneficiarioDTO;
import com.osdepym.dto.PrestacionDTO;
import com.osdepym.exception.CustomException;
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
	public ModelAndView submitAuthorizationForm(@RequestParam("uploadFiles") MultipartFile[] uploadFiles, @ModelAttribute("autorizacionForm") @Validated AutorizacionForm autorizacionForm, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		ModelAndView view = null;
		try {
			if (result.hasErrors()) {
				view = getAuthorizationFormView(model, autorizacionForm, autorizacionForm.getIdAfiliado());
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
	
	@RequestMapping(value = "/autorizacion/getBeneficiarios")
	public @ResponseBody List<BeneficiarioDTO> getBeneficiarios(AutorizacionForm form) {
		List<BeneficiarioDTO> beneficiarios = null;
		try {
			beneficiarios = service.getBeneficiarios(form);
		} catch (Exception e) {
			beneficiarios = new ArrayList<BeneficiarioDTO>();
		}
		return beneficiarios;
	}
	
	@RequestMapping(value = "/autorizacion/getPrestaciones")
	public @ResponseBody List<PrestacionDTO> getPrestacionesByEspecialidadId(@RequestBody String idEspecialidad) {
		List<PrestacionDTO> prestaciones = null;
		try {
			prestaciones = service.getPrestacionesByEspecialidadId(Long.valueOf(idEspecialidad));
		} catch (Exception e) {
		}
		return prestaciones;
	}
	
	@RequestMapping(value = "/autorizacion/*/getPrestaciones")
	public @ResponseBody List<PrestacionDTO> getPrestacionesByEspecialidadIdAfterError(@RequestBody String idEspecialidad) {
		List<PrestacionDTO> prestaciones = null;
		try {
			prestaciones = service.getPrestacionesByEspecialidadId(Long.valueOf(idEspecialidad));
		} catch (Exception e) {
		
		}
		return prestaciones;
	}
	
	@RequestMapping(value = "/autorizacion/*/getDocumentos")
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
	
	private ModelAndView getAuthorizationFormView(Model model, AutorizacionForm form, String idAfiliado) {
		ModelAndView view = null;
		try {
			form.setIdAfiliado(idAfiliado);
			List<BeneficiarioDTO> beneficiarios = getBeneficiarios(form);
			for(BeneficiarioDTO b : beneficiarios) {
				for(BeneficiarioDTO c : beneficiarios) {
					if(b.getId().equals(Long.valueOf(c.getTitular()))) {
						form.setIdAfiliado(b.getId().toString());
						form.setNombreAfiliado(b.getNombreCompleto());
						break;
					}
				}
			}

			view = new ModelAndView("autorizacion");
			view.addObject("beneficiarios", beneficiarios);
			view.addObject("especialidades", service.getAllEspecialidades());
			
			model.addAttribute("autorizacionForm", form);
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;
	}
	
	@ExceptionHandler({ CustomException.class })
	public void handleException() {
		System.out.println();
	}
	
}
