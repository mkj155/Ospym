package com.osdepym.hibernate.dao;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Hijos;

public interface HijosDAO extends Dao<Hijos>{

	public Hijos getHijoByNombreAndApellido(String nombre,String apellido) throws CustomException;
	public void deleteHijosByPerson(Integer id) throws CustomException;
}
