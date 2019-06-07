package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.EspecialidadPrestacion;
import com.osdepym.hibernate.entity.Prestacion;

public interface EspecialidadPrestacionDAO extends Dao<EspecialidadPrestacion>{

	public List<Prestacion> getPrestacionesByEspecialidadId(Long idEspecialidad) throws CustomException;
	public Integer getSecuence() throws CustomException;
	public void saveContacto(Contacto contacto) throws CustomException;
	public String getMailByIds(Long idEspecialidad, Long idPrestacion) throws CustomException;
	public String getEspecialidadById(Long idEspecialidad) throws CustomException;
	public String getPrestacionById(Long idPrestacion) throws CustomException;
}
