package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.EspecialidadPrestacion;
import com.osdepym.hibernate.entity.Prestacion;

public interface EspecialidadPrestacionDAO extends Dao<EspecialidadPrestacion>{

	public List<Prestacion> getPrestacionesByEspecialidadId(int idEspecialidad) throws CustomException;
	public Integer getSecuence() throws CustomException;
	public void saveContacto(Contacto contacto) throws CustomException;
	public String getMailByIds(String idEspecialidad, String idPrestacion) throws CustomException;
	public String getEspecialidadById(String idEspecialidad) throws CustomException;
	public String getPrestacionById(String idPrestacion) throws CustomException;
}
