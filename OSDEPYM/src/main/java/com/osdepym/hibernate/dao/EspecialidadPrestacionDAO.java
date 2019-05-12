package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.EspecialidadPrestacion;
import com.osdepym.hibernate.entity.Prestacion;

public interface EspecialidadPrestacionDAO extends Dao<EspecialidadPrestacion>{

	public List<Prestacion> getPrestacionesByEspecialidadId(int idEspecialidad) throws CustomException;
}
