package com.osdepym.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.osdepym.dto.AfiliadoDTO;
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
	public @ResponseBody List<AfiliadoDTO> exportar(@RequestBody SolicitudesForm element) {
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
	
	@RequestMapping(value = "/solicitudes/importar", method = RequestMethod.GET)
	public ModelAndView importar(Model model) {
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
	

	@RequestMapping(value = "*/procesarArchivo", method = RequestMethod.POST)
	public List<AfiliadoDTO> procesarArchivo(@RequestParam("file") MultipartFile uploadFile) {
		List<AfiliadoDTO> afiliados = new ArrayList<AfiliadoDTO>();
		try {
			POIFSFileSystem fs = new POIFSFileSystem(uploadFile.getInputStream());
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
		        row = sheet.getRow(r);
		        if(row != null) {
		        	AfiliadoDTO afiliado = new AfiliadoDTO();
		            for(int c = 0; c < cols; c++) {
		                cell = row.getCell((short)c);
		                if(cell != null) {
		                	switch (c) {
			                	case 0:
			                	//	afiliado.setCuil(Long.valueOf(cell.toString()));
			                	case 1:
			                		afiliado.setApellido(cell.toString());
			                	case 2:
			                		afiliado.setNombre(cell.toString());
			                	case 3:
			                		afiliado.setTipoDocumento(cell.toString());
			                	case 4:
			                		afiliado.setNroDocumento(cell.toString());
			                	case 5:
			                		
			                	case 6:
			                		afiliado.setDireccion(cell.toString());
			                	case 7:
			                		afiliado.setDireccionNumero(cell.toString());
			                	case 8:
			                		afiliado.setDireccionPiso(cell.toString());
			                	case 9:
			                		afiliado.setDireccionDepartamento(cell.toString());
			                	case 10:
			                		afiliado.setDireccionLocalidad(cell.toString());
			                	case 11:
			                		afiliado.setDireccionProvincia(cell.toString());
			                	case 12:
			                		afiliado.setCodigoPostal(cell.toString());
			                	case 13:
			                		afiliado.setTelefono(cell.toString());
			                	case 14:
			                		//afiliado.setFechaNacimiento(cell.toString());
			                	case 15:
			                		//afiliado.setNombre(cell.toString());
			                	case 16:
			                		//afiliado.setNombre(cell.toString());
			                	case 17:
			                		//afiliado.setNombre(cell.toString());
			                	case 18:
			                		//afiliado.setNombre(cell.toString());
			                	
			               }
	
		                    	

		                }
		            }
		            afiliados.add(afiliado);
		        }
		    }
			
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
	public @ResponseBody List<AfiliadoTableDTO> confirmar(@RequestBody SolicitudesForm element) {
		List<AfiliadoTableDTO> afiliados = new ArrayList<AfiliadoTableDTO>();
		try {
			// Validar si están en pendientes
			Integer id = 666; 
			if(validarPendientes(element)) {
				service.obtenerSolicitudMultiple();
				service.confirmarAltaAfiliado(id);
			}
			return afiliados;
		} catch (Exception e) {
		}
		return afiliados;
	}
	
	public boolean validarPendientes(SolicitudesForm element) {
		return true;
	}
	
}
