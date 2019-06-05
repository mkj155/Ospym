package com.osdepym.rest.dao;

import java.util.List;

import com.osdepym.rest.entity.AfiliadoCompleto;
import com.osdepym.rest.json.Cuil;
import com.osdepym.rest.json.DocumentoIdentidad;
import com.osdepym.rest.json.PersonaFisicaRequest;

public interface ModeloPersonaDAO {

	public List<AfiliadoCompleto> getPersona(PersonaFisicaRequest personaFisicaRequest);

	void actualizarPersona(PersonaFisicaRequest personaFisicaRequest);

}
