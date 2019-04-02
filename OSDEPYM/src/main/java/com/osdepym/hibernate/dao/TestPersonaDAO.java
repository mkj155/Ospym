package com.osdepym.hibernate.dao;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Persona;

public interface TestPersonaDAO extends Dao<Persona>{

	Persona getByName(String nombre) throws CustomException;
	
}
