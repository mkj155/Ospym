package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.AutorizacionDoc;

public interface AutorizacionDocDAO extends Dao<AutorizacionDoc>{
	public List<String> getDocumentosByIdEspecialidadYIdPrestacion(Long idEspecialidad, Long idPrestacion) throws CustomException;
}
