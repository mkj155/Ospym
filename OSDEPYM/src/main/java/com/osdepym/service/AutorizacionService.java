package com.osdepym.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.osdepym.dto.EspecialidadDTO;
import com.osdepym.dto.BeneficiarioDTO;
import com.osdepym.dto.PrestacionDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.form.AutorizacionForm;

public interface AutorizacionService {
	public List<EspecialidadDTO> getAllEspecialidades() throws CustomException;
	public List<PrestacionDTO> getPrestacionesByEspecialidadId(int idEspecialidad) throws CustomException;
	public List<String> getDocumentosByEspecialidadYPrestacion(int idEspecialidad, int idPrestacion) throws CustomException;
	public String procesarContacto(AutorizacionForm autorizacionForm, MultipartFile[] files) throws CustomException;
	public List<BeneficiarioDTO> getBeneficiarios(AutorizacionForm autorizacionForm) throws CustomException;
}
