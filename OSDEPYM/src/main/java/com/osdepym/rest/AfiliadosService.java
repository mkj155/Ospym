package com.osdepym.rest;

import java.util.Properties;

import com.osdepym.rest.response.AfiliadosResponse;
import com.osdepym.util.ReadPropertyFile;

public class AfiliadosService {
	
	public AfiliadosService(){};

	public AfiliadosResponse getAfiliado(String idAfiliado) {
		AfiliadosResponse response = new AfiliadosResponse();
		try{
			Properties parameters = ReadPropertyFile.readFile("WSConfiguration.properties");
			BasicAuthRestTemplate restTemplate = new BasicAuthRestTemplate(parameters.getProperty("afiliado.user"), parameters.getProperty("afiliado.password"));
			response = restTemplate.getForObject(parameters.getProperty("afiliado.endpoint") + idAfiliado,
					AfiliadosResponse.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
