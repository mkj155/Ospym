package com.osdepym.rest.client;

import java.util.Properties;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.rest.BasicAuthRestTemplate;
import com.osdepym.rest.response.AfiliadosResponse;
import com.osdepym.util.ReadPropertyFile;

public class AfiliadosService {
	
	public AfiliadosService(){};

	public AfiliadosResponse getAfiliado(String idAfiliado) throws CustomException {
		AfiliadosResponse response = new AfiliadosResponse();
		try{
			Properties parameters = ReadPropertyFile.readFile("WSConfiguration.properties");
			BasicAuthRestTemplate restTemplate = new BasicAuthRestTemplate(parameters.getProperty("afiliado.user"), parameters.getProperty("afiliado.password"));
			response = restTemplate.getForObject(parameters.getProperty("afiliado.endpoint") + idAfiliado,
					AfiliadosResponse.class);
		}catch(Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		return response;
	}

}
