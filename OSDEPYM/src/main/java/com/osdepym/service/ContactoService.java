package com.osdepym.service;

import java.util.List;

import com.osdepym.dto.CategoriaDTO;
import com.osdepym.dto.MotivoDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.form.ContactoForm;

public interface ContactoService {
	public List<MotivoDTO> getAllMotivos() throws CustomException;
	public List<CategoriaDTO> getCategoriasByMotivoId(Long idMotivo) throws CustomException;
	public String procesarContacto(ContactoForm contactoForm) throws CustomException;
}