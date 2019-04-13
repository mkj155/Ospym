package com.osdepym.service;

import java.util.List;

import com.osdepym.dto.CategoriaDTO;
import com.osdepym.dto.MotivoDTO;
import com.osdepym.exception.CustomException;

public interface ContactoService {
	public List<MotivoDTO> getAllMotivos() throws CustomException;
	public List<CategoriaDTO> getCategoriasByMotivoId(int idMotivo) throws CustomException;
}