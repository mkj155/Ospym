package com.osdepym.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
		try {
			return service.getHijo(Integer.valueOf(source));
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}

