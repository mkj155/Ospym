package com.osdepym.rest.server;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.osdepym.rest.client.ModeloPersonaService;
import com.osdepym.rest.dto.CuilDTO;
import com.osdepym.rest.dto.DniDTO;
import com.osdepym.rest.dto.MensajeDTO;
import com.osdepym.rest.dto.PersonaDTO;
import com.osdepym.rest.dto.PersonaSearchDTO;
import com.osdepym.rest.dto.RespuestaDTO;
import com.osdepym.rest.dto.SenderDTO;
import com.osdepym.rest.response.BusquedaPersonaResponse;



@RestController
public class BusquedaPersonaREST extends RestTemplate{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@RequestMapping(value="/personaFisicaBuscar", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public BusquedaPersonaResponse personaFisicaBuscar(
			@RequestParam(value="tipoMensaje", required = false) String tipoMensaje,
			@RequestParam(value="cuil", required = false) Long cuil, 
			@RequestParam(value="tipoDocumento", required = false) String tipoDocumento, 
			@RequestParam(value="nroDocumento", required = false) Long nroDocumento, 
			@RequestParam(value="apellido", required = false) String apellido, 
			@RequestParam(value="nombre", required = false) String nombre, 
			@RequestParam(value="sexo", required = false) String sexo,
			@RequestParam(value="fechaNacimiento", required = false) Date fechaNacimiento)  {
		return new ModeloPersonaService().getPersona(
				tipoMensaje,
				cuil, 
				tipoDocumento, 
				nroDocumento, 
				apellido, 
				nombre, 
				sexo,
				fechaNacimiento);  
	}
	
	// SOLO PARA TEST
	@RequestMapping(value="/personaFisicaBuscarTEST", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public BusquedaPersonaResponse personaFisicaBuscarTEST(
			@RequestParam(value="tipoMensaje", required = false) String tipoMensaje,
			@RequestParam(value="cuil", required = false) Long cuil, 
			@RequestParam(value="tipoDocumento", required = false) String tipoDocumento, 
			@RequestParam(value="nroDocumento", required = false) Long nroDocumento, 
			@RequestParam(value="apellido", required = false) String apellido, 
			@RequestParam(value="nombre", required = false) String nombre, 
			@RequestParam(value="sexo", required = false) String sexo,
			@RequestParam(value="fechaNacimiento", required = false) Date fechaNacimiento)  {
		
		int param1 = 10;
		List<PersonaDTO> personas = createPersonas(param1);
		List<PersonaDTO> returnList = new ArrayList<PersonaDTO>();
		PersonaSearchDTO search = new PersonaSearchDTO();
		SenderDTO sender = new SenderDTO();
		RespuestaDTO respuesta = new RespuestaDTO();
		MensajeDTO mensaje = new MensajeDTO(); 
		
		DniDTO dniDTO = new DniDTO();
		dniDTO.setTipo(tipoDocumento);
		dniDTO.setNumero(nroDocumento);
		
		CuilDTO cuilDTO = new CuilDTO();
		cuilDTO.setId(cuil != null ? String.valueOf(cuil) : "");
		
		List<CuilDTO> cuilList = new ArrayList<CuilDTO>();
		cuilList.add(cuilDTO);
		
		search.setDocumentoIdentidad(dniDTO);
		search.setCUIL(cuilList);
		search.setApellido(apellido);
		search.setNombre(nombre);
		search.setSexo(sexo);
		search.setFechaNacimiento(fechaNacimiento);
		
		sender.setFechaHora(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		sender.setNombre("Sender1");
		sender.setUid("UIDTEST");
		
		mensaje.setCodigo("0000");
		mensaje.setMensaje("Exitoso");
		
		for(int i = 0; i < param1; i++) {
			PersonaDTO p = (PersonaDTO) personas.get(i);
			int b = 0;
			int c = 0;
			
			if(tipoMensaje != null) c++;
			if(cuil != null) c++;
			if(tipoDocumento != null) c++;
			if(nroDocumento != null) c++;
			if(apellido != null) c++;
			if(nombre != null) c++;
			if(sexo != null) c++;
			if(fechaNacimiento != null) c++;
			
			//if(cuil != null && p.getCUIL().equals(cuil)) b++;
			//if(tipoDocumento != null && p.getTipoDocumento().equals(tipoDocumento)) b++;
			//if(nroDocumento != null && p.getNroDocumento().equals(nroDocumento)) b++;
			if(apellido != null && p.getApellido().equals(apellido)) b++;
			if(nombre != null && p.getNombre().equals(nombre)) b++;
			if(sexo != null && p.getSexo().equals(sexo)) b++;
			if(fechaNacimiento != null && p.getFechaNacimiento().equals(fechaNacimiento)) b++;
			
			if(b == c)
				returnList.add(p);
		}
		
		respuesta.setCantidad(returnList.size());
		respuesta.setEncontrada(Boolean.toString(returnList != null && !returnList.isEmpty()));
		respuesta.setPersonas(returnList);
		respuesta.setMensaje(mensaje);
		
		BusquedaPersonaResponse response = new BusquedaPersonaResponse();
		
		response.setTipoMensaje("BUSQUEDA");
		response.setPersonaFisica(search);
		response.setSender(sender);
		response.setRespuesta(respuesta);
		
		return response;
	}
	
	// SOLO PARA TEST
	private List<PersonaDTO> createPersonas(int param1) {
		List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		for(int i = 0; i < param1; i++) {
			PersonaDTO persona = new PersonaDTO();
			DniDTO dniDTO = new DniDTO();
			CuilDTO cuilDTO = new CuilDTO(); 
			
			dniDTO.setNumero(new Long("112344" + i));
			dniDTO.setTipo(i % 3 == 0 ? "DNI" : i % 2 == 0 ? "CUIL" : "CUIT");
			
			cuilDTO.setFechaInicio(new Date());
			cuilDTO.setId("000" + (i * 2));
			
			List<CuilDTO> cuilList = new ArrayList<CuilDTO>();
			cuilList.add(cuilDTO);
			
			persona.setApellido("Apellido"+i);
			persona.setCUIL(cuilList);
			persona.setFechaNacimiento(new Date());
			persona.setNombre("Nombre"+i);
			persona.setDocumentoIdentidad(dniDTO);
			persona.setSexo(i % 2 == 0 ? "F" : "M");
			
			personas.add(persona);
		}
		
		return personas;
	}
}
