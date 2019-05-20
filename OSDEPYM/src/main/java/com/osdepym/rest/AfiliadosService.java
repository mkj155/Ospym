package com.osdepym.rest;

import java.util.Properties;
import org.springframework.web.client.RestTemplate;
import com.osdepym.rest.response.AfiliadosResponse;
import com.osdepym.util.ReadPropertyFile;

public class AfiliadosService {

	public AfiliadosResponse getAfiliado(String idAfiliado) {
		AfiliadosResponse response = new AfiliadosResponse();
		try{
			RestTemplate restTemplate = new RestTemplate();
			Properties parameters = ReadPropertyFile.readFile("WSConfiguration.properties");
			response = restTemplate.getForObject(parameters.getProperty("afiliado.endpoint") + idAfiliado,
					AfiliadosResponse.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
