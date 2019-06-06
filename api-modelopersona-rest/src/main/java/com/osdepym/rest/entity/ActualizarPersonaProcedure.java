package com.osdepym.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(
		name="PersonaFisicaActualizar", 
		procedureName="mp.Spo_PersonaFisicaActualizar", 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "TipoDocumento"), 
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "Nrodocumento"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "CUIL"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "FechaInicioCUIL"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "Apellido"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "Nombre"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "FechaNacimiento"),
				@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "Sexo"),
				@StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "CodigoError"),
				@StoredProcedureParameter(mode = ParameterMode.INOUT, type = String.class, name = "MensajeError")})
public class ActualizarPersonaProcedure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", updatable = false, nullable = false)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
