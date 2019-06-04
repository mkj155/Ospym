package com.osdepym.rest.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.osdepym.rest.dao.ModeloPersonaDAO;
import com.osdepym.rest.entity.ModeloPersona;
import com.osdepym.rest.response.BusquedaPersonaResponse;

public class ModeloPersonaService {
	
	public ModeloPersonaService() {};

	@Autowired
	private ModeloPersonaDAO modeloPersonaDAO;
	
	public BusquedaPersonaResponse getPersona(
			String tipoMensaje,
			Long cuil, 
			String tipoDocumento, 
			Long nroDocumento, 
			String apellido, 
			String nombre, 
			String sexo,
			Date fechaNacimiento) {
		BusquedaPersonaResponse response = null;
		
		try{
			List<ModeloPersona> modeloPersona = modeloPersonaDAO.getPersona(
					tipoMensaje,
					cuil, 
					tipoDocumento, 
					nroDocumento, 
					apellido, 
					nombre, 
					sexo,
					fechaNacimiento);
			/*Properties parameters = ReadPropertyFile.readFile("WSConfiguration.properties");
			BasicAuthRestTemplate restTemplate = new BasicAuthRestTemplate(parameters.getProperty("persona.user"), parameters.getProperty("persona.password"));
			response = restTemplate.getForObject(parameters.getProperty("persona.endpoint") + getParamURI(
					tipoMensaje,
					cuil, 
					tipoDocumento, 
					nroDocumento, 
					apellido, 
					nombre, 
					sexo,
					fechaNacimiento),
					BusquedaPersonaResponse.class);*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
