package com.osdepym.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
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
import com.osdepym.form.ImportForm;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.service.SolicitudesService;
import com.osdepym.util.ExcelWriter;

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
	
	@RequestMapping(value = "/solicitudes/exportar", method = RequestMethod.POST)
	public @ResponseBody List<AfiliadoDTO> exportar(HttpServletRequest request, HttpServletResponse response, @RequestBody SolicitudesForm element) {
		List<AfiliadoDTO> afiliados = new ArrayList<AfiliadoDTO>();
		try {
			afiliados = service.buscarExportar(element);
			ExcelWriter.export(afiliados);
		} catch (Exception e) {
		}
		return afiliados;	
	}
	
	
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
	
	@RequestMapping(value = "/solicitudes/cargaMasiva", method = RequestMethod.GET)
	public ModelAndView cargaMasiva(Model model) {
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
		}
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value = "*/procesarArchivo", method = RequestMethod.POST)
	public List<AfiliadoImportDTO> procesarArchivo(@RequestParam("file") MultipartFile uploadFile) {
		List<AfiliadoImportDTO> afiliados = new ArrayList<AfiliadoImportDTO>();
		try {
		
			afiliados = getAfiliadosByFile(uploadFile);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return afiliados;
	}
	
	@RequestMapping(value = "/solicitudes/obtenerPautas", method = RequestMethod.POST)
	public @ResponseBody List<PautaDTO> getPautaByCuit(@RequestBody String cuit) {
		List<PautaDTO> pautas = null;
		try {
			pautas = service.getPautasByCuit(cuit);
		} catch (Exception e) {
			
		}
		return pautas;
	}

	@RequestMapping(value = "/solicitudes/confirmar")
	public @ResponseBody List<AfiliadoTableDTO> confirmar(@RequestBody List<AfiliadoTableDTO> afiliados) {
		try {
			if(validarPendientes(afiliados)) {
				service.obtenerSolicitudMultiple();
				for(AfiliadoTableDTO a : afiliados) {
					boolean altaAfiliado = service.confirmarAltaAfiliado(a.getRegistroID());
					a.setAnular(altaAfiliado);
				}
			}
			return afiliados;
		} catch (Exception e) {
		}
		return afiliados;
	}
	
	public boolean validarPendientes(List<AfiliadoTableDTO> afiliados) {
		for(AfiliadoTableDTO a : afiliados) {
			if(!"Pendiente".equalsIgnoreCase(a.getEstado()))
				return false;
		}
		return true;
	}
	
	@RequestMapping(value = "/solicitudes/importar", method = RequestMethod.POST)
	public ModelAndView importar(@RequestParam("uploadFile") MultipartFile uploadFile, @ModelAttribute("importForm") @Validated ImportForm importForm, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		ModelAndView view = null;
		try {
			if (!result.hasErrors()) {
				List<AfiliadoImportDTO> afiliados = getAfiliadosByFile(uploadFile);
				importForm.setAfiliados(afiliados);
				Long archivoId = service.archivoCargaMasivaObtenerIdentificar(importForm.getObraSocialId(), importForm.getTipoCargaId(), importForm.getTipoAfiliadoId(), importForm.getCuit().toString(), importForm.getPautaId(), uploadFile.getOriginalFilename());
				boolean isSuccess = service.archivoCargaMasivaCargarRegistro(archivoId, importForm);
				System.out.println("is success:" + isSuccess);
			} else {
				
			}
		} catch (Exception e) {
			view = new ModelAndView("error");
			view.addObject("error", e);
		}
		return view;	
	}
	
	
	private List<AfiliadoImportDTO> getAfiliadosByFile(MultipartFile file) throws Exception{
		List<AfiliadoImportDTO> afiliados = new ArrayList<AfiliadoImportDTO>();
	
			POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();

		    int cols = 0; // No of columns
		    int tmp = 0;
		 // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) {
		        row = sheet.getRow(i);
		        if(row != null) {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp;
		        }
		    }

		    for(int r = 1; r < rows; r++) {
		    	Boolean hasError = new Boolean(false);
		        row = sheet.getRow(r);
		        if(row != null) {
		        	AfiliadoImportDTO afiliado = new AfiliadoImportDTO();
		            for(int c = 0; c < cols; c++) {
		                cell = row.getCell((short)c);
		                if(cell != null) {
		                	
		                	switch (c) {
			                	case 0:
			                		cell.setCellType(CellType.STRING);
			                		afiliado.setCuil(cell.toString());
			                		if(cell.toString() == null || cell.toString().equals("")) {
			                			hasError = true;
			                		}
			                		break;
			                			
			                	case 1:
			                		afiliado.setApellido(cell.toString());
			                		if(cell.toString() == null || cell.toString().equals("")) {
			                			hasError = true;
			                		}
			                		break;
			                	case 2:
			                		afiliado.setNombre(cell.toString());
			                		if(cell.toString() == null || cell.toString().equals("")) {
			                			hasError = true;
			                		}
			                		break;
			                	case 3:
			                		afiliado.setTipoDocumento(cell.toString());
			                		if(cell.toString() == null || cell.toString().equals("")) {
			                			hasError = true;
			                		}
			                		break;
			                	case 4:
			                		cell.setCellType(CellType.STRING);
			                		afiliado.setNroDocumento(cell.toString());
			                		if(cell.toString() == null || cell.toString().equals("")) {
			                			hasError = true;
			                		}
			                		break;
			                	case 5:
			                		afiliado.setCodParentesco(cell.toString());
			                		break;
			                	case 6:
			                		afiliado.setDireccion(cell.toString());
			                		break;
			                	case 7:
			                		cell.setCellType(CellType.STRING);
			                		afiliado.setNumero(cell.toString());
			                		break;
			                	case 8:
			                		cell.setCellType(CellType.STRING);
			                		afiliado.setPiso(cell.toString());
			                		break;
			                	case 9:
			                		afiliado.setDepartamento(cell.toString());
			                		break;
			                	case 10:
			                		afiliado.setLocalidad(cell.toString());
			                		break;
			                	case 11:
			                		cell.setCellType(CellType.STRING);
			                		afiliado.setProvincia(cell.toString());
			                		break;
			                	case 12:
			                		cell.setCellType(CellType.STRING);
			                		afiliado.setCodigoPostal(cell.toString());
			                		break;
			                	case 13:
			                		cell.setCellType(CellType.STRING);
			                		afiliado.setTelefono(cell.toString());
			                		break;
			                	case 14:
			                		afiliado.setFechaNacimiento(cell.toString());
			                		if(cell.toString() == null || cell.toString().equals("")) {
			                			hasError = true;
			                		}
			                		break;
			                	case 15:
			                		afiliado.setSexo(cell.toString());
			                		if(cell.toString() == null || cell.toString().equals("")) {
			                			hasError = true;
			                		}
			                		break;
			                	case 16:
			                		cell.setCellType(CellType.STRING);
			                		afiliado.setEstadoCivil(cell.toString());
			                		if(cell.toString() == null || cell.toString().equals("")) {
			                			hasError = true;
			                		}
			                		break;
			                	case 17:
			                		afiliado.setFechaInicioCobertura(cell.toString());
			                		if(cell.toString() == null || cell.toString().equals("")) {
			                			hasError = true;
			                		}
			                		break;
			                	case 18:
			                		afiliado.setEmail(cell.toString());
			                		break;
			               }
		                }
		            }
		            if(hasError)
		            	afiliado.setErrorValidacion(true);
		            else
		            	afiliado.setErrorValidacion(false);
		            afiliados.add(afiliado);
		        }
		    }
		    wb.close();
		    return afiliados;
		
	}
	
	@RequestMapping(value = "/solicitudes/anular")
	public @ResponseBody boolean anular(@RequestBody AfiliadoTableDTO afiliado) {
		try {
			service.anularAfiliado(afiliado);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
