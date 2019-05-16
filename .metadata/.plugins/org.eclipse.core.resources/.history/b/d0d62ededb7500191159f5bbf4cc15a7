package com.osdepym.service;

import java.util.List;

import com.osdepym.dto.EspecialidadDTO;
import com.osdepym.dto.PrestacionDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.form.AutorizacionForm;

public interface AutorizacionService {
	public List<EspecialidadDTO> getAllEspecialidades() throws CustomException;
	public List<PrestacionDTO> getPrestacionesByEspecialidadId(int idEspecialidad) throws CustomException;
	public String procesarContacto(AutorizacionForm autorizacionForm) throws CustomException;
}
