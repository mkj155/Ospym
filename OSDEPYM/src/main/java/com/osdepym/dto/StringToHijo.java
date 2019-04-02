package com.osdepym.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.hibernate.entity.Hijos;
import com.osdepym.service.TestService;

@Component
public class StringToHijo implements Converter<String, Hijos> {
	
	@Autowired
	private TestService service;
	
	public StringToHijo(TestService service) {
		this.service = service;
	}
	
	@Override
	public Hijos convert(String source) {
		return service.getHijo(Integer.valueOf(source));
	}

}

