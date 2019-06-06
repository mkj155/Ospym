package com.osdepym.rest.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.rest.entity.AfiliadoCompleto;
import com.osdepym.rest.json.PersonaFisicaRequest;

public interface ModeloPersonaDAO {

	public List<AfiliadoCompleto> getPersona(PersonaFisicaRequest personaFisicaRequest) throws CustomException;

	void actualizarPersona(PersonaFisicaRequest personaFisicaRequest) throws CustomException;

}
