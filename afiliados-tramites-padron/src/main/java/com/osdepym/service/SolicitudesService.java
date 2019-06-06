package com.osdepym.service;

import java.util.List;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.form.SolicitudesForm;

public interface SolicitudesService {
	public List<AfiliadoDTO> buscarAfiliados(AfiliadoDTO afiliadoSearch) throws CustomException;
}
