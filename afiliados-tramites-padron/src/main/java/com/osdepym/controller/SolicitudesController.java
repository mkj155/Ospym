package com.osdepym.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.dto.AfiliadoImportDTO;
import com.osdepym.dto.AfiliadoTableDTO;
import com.osdepym.dto.EstadoDTO;
import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.dto.PautaDTO;
import com.osdepym.dto.TipoAfiliadoDTO;
import com.osdepym.dto.TipoCargaDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.form.ImportForm;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.service.SolicitudesService;
import com.osdepym.util.Constants;
import com.osdepym.util.ExcelWriter;
import com.osdepym.util.ValidateUtil;

@Controller
public class SolicitudesController {
	
	@Autowired
	@Qualifier("SolicitudesService")
	private SolicitudesService service;

	@RequestMapping(value = "/solicitudes", method = RequestMethod.GET)
	public ModelAndView init(Model model) throws CustomException {
		ModelAndView view = getSolicitudesFormView(model, new SolicitudesForm());
		return view;
	}
	
	@RequestMapping(value = "/solicitudes/buscar")
	public @ResponseBody List<AfiliadoTableDTO> buscar(@RequestBody SolicitudesForm element) throws CustomException {
		List<AfiliadoTableDTO> afiliados = new ArrayList<AfiliadoTableDTO>();
		try {
			afiliados = service.buscar(element);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return afiliados;	
	}
	
	@RequestMapping(value = "/solicitudes/exportar", method = RequestMethod.POST)
	public @ResponseBody List<AfiliadoDTO> exportar(HttpServletRequest request, HttpServletResponse response,
			@RequestBody SolicitudesForm element) throws CustomException {
		List<AfiliadoDTO> afiliados = new ArrayList<AfiliadoDTO>();
		try {
			afiliados = service.buscarExportar(element);
			ExcelWriter.export(afiliados);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return afiliados;	
	}
	
	@RequestMapping(value = "/solicitudes/confirmar")
	public @ResponseBody List<AfiliadoTableDTO> confirmar(@RequestBody List<AfiliadoTableDTO> afiliados) throws CustomException {
		try {
			if(ValidateUtil.validarPendientes(afiliados)) {
				service.obtenerSolicitudMultiple();
				for(AfiliadoTableDTO a : afiliados) {
					String[] response = service.confirmarAltaAfiliado(a.getRegistroID());
					a.setAnular(!Constants.ERROR_SP.equals(response[0]));
					a.setErrorConfirmar(response[0]);
					a.setMessageErrorConfirmar(response[1]);
					if(!Constants.ERROR_SP.equals(response[0])) {
						a.setEstado(Constants.ESTADO_AFILIADO_CONFIRMADO);
						a.setEstadoRegistroID(3);
					}
				}
			}
			return afiliados;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
	
	@RequestMapping(value = "/solicitudes/anular")
	public @ResponseBody AfiliadoTableDTO anular(@RequestBody AfiliadoTableDTO afiliado) throws CustomException {
		try {
			String[] response = service.anularAfiliado(afiliado);
			afiliado.setAnular(Constants.ERROR_SP.equals(response[0]));
			afiliado.setErrorAnular(response[0]);
			afiliado.setMessageErrorAnular(response[1]);
			if(!Constants.ERROR_SP.equals(response[0])) {
				afiliado.setEstado(Constants.ESTADO_AFILIADO_ANULADO);
				afiliado.setEstadoRegistroID(4);
			}
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return afiliado;
	}
	
	@RequestMapping(value = "/solicitudes/descargarPlantilla", method = RequestMethod.POST)
	public @ResponseBody void descargarPlantilla(HttpServletRequest request, HttpServletResponse response) throws CustomException {
		FileInputStream inputStream;
		File tempFile = new File("File1.xlsx");
		try {
			inputStream = new FileInputStream(new File(getClass().getResource("/File1.xlsx").toURI()));
			tempFile = File.createTempFile(String.valueOf(inputStream.hashCode()), ".xlsx");
			Desktop dt = Desktop.getDesktop();
        	dt.open(tempFile);
        	inputStream.close();
		} catch(Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
	
	@RequestMapping(value = "/solicitudes/cargaMasiva", method = RequestMethod.GET)
	public ModelAndView cargaMasiva(Model model) throws CustomException {
		ModelAndView view = new ModelAndView("importar");
		try {
			
			List<ObraSocialDTO> obrasSociales = service.getAllObrasSociales();
			List<TipoCargaDTO> tipoCargas = service.getAllTipoCarga();
			List<TipoAfiliadoDTO> tipoAfiliados = service.getAllTipoAfiliado();
			view.addObject("obrassociales", obrasSociales);
			view.addObject("tipocargas", tipoCargas);
			view.addObject("tipoafiliados", tipoAfiliados);
			model.addAttribute("importForm", new ImportForm());
		}catch(Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value = "*/procesarArchivo", method = RequestMethod.POST)
	public List<AfiliadoImportDTO> procesarArchivo(@RequestParam("file") MultipartFile uploadFile) throws CustomException {
		List<AfiliadoImportDTO> afiliados = new ArrayList<AfiliadoImportDTO>();
		try {
			if(uploadFile.getOriginalFilename().endsWith("xls"))
				afiliados = ExcelWriter.getAfiliadosByFileXLS(uploadFile);
			else
				afiliados = ExcelWriter.getAfiliadosByFileXLSX(uploadFile);
		
		}catch(Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return afiliados;
	}
	
	@RequestMapping(value = "/solicitudes/obtenerPautas", method = RequestMethod.POST)
	public @ResponseBody List<PautaDTO> getPautaByCuit(@RequestBody String cuit) throws CustomException {
		List<PautaDTO> pautas = null;
		try {
			pautas = service.getPautasByCuit(cuit);
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return pautas;
	}

	@RequestMapping(value = "/solicitudes/importar", method = RequestMethod.POST)
	public ModelAndView importar(@RequestParam("uploadFile") MultipartFile uploadFile,
			@ModelAttribute("importForm") @Validated ImportForm importForm, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) throws CustomException {
		ModelAndView view = null;
		try {
			if (!result.hasErrors()) {
				List<AfiliadoImportDTO> afiliados = new ArrayList<AfiliadoImportDTO>();
				if(uploadFile.getOriginalFilename().endsWith("xls"))
					afiliados = ExcelWriter.getAfiliadosByFileXLS(uploadFile);
				else
					afiliados = ExcelWriter.getAfiliadosByFileXLSX(uploadFile);
				importForm.setAfiliados(afiliados);
				boolean isSuccess = service.procesarArchivoXLS(importForm, uploadFile.getOriginalFilename());
				System.out.println("is success:" + isSuccess);
				view = new ModelAndView("importar");
				List<ObraSocialDTO> obrasSociales = service.getAllObrasSociales();
				List<TipoCargaDTO> tipoCargas = service.getAllTipoCarga();
				List<TipoAfiliadoDTO> tipoAfiliados = service.getAllTipoAfiliado();
				view.addObject("obrassociales", obrasSociales);
				view.addObject("tipocargas", tipoCargas);
				view.addObject("tipoafiliados", tipoAfiliados);
				model.addAttribute("importForm", new ImportForm());
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return view;	
	}
	
	private ModelAndView getSolicitudesFormView(Model model, SolicitudesForm form) throws CustomException {
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
