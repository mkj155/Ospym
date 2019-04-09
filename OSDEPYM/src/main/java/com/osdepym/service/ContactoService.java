package com.osdepym.service;

import java.util.List;

import com.osdepym.dto.MotivoCategoriaDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Contacto;

public interface ContactoService {
	public List<MotivoCategoriaDTO> getAllMotivos() throws CustomException;
	public String getSecuence() throws CustomException;
	public void saveContacto(Contacto contacto) throws CustomException;
}
