package com.osdepym.rest.server;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.osdepym.rest.json.Codebeautify;

@RestController
public class BusquedaPersonaREST extends RestTemplate {

	@Autowired
	private SessionFactory sessionFactory;

	Logger logger = LoggerFactory.getLogger(BeneficiarioServiceREST.class);
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@RequestMapping(value="/testjson", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Codebeautify testJson(
			@RequestBody Codebeautify jsonBody
			)  {
		 logger.info(jsonBody.toString());
		 return jsonBody;
	}
	
}

