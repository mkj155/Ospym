package com.osdepym.hibernate.dao.interfaces;

import com.osdepym.hibernate.model.Persona;

public interface TestPersonaDAO extends Dao<Persona>{

	Persona getByName(String nombre);
}
