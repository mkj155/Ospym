package com.osdepym.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.osdepym.hibernate.entity.Hijos;
import com.osdepym.service.TestService;
import com.osdepym.service.TestServiceImpl;

@Component
public class StringToHijo implements Converter<String, Hijos> {
	
	@Autowired
	private TestService service;
	
	public StringToHijo() {
		super();
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

