package com.osdepym.dao;

import java.util.List;

import com.osdepym.model.TestPersona;

public interface TestPersonaDAO {

	List<TestPersona> listarPersonas();
	boolean savePersona(TestPersona testPersona);
	boolean deletePersona(TestPersona testPersona);
}
