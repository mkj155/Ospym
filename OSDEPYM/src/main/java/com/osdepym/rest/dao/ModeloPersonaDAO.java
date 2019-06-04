package com.osdepym.rest.dao;

import java.util.Date;
import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.dao.Dao;
import com.osdepym.rest.entity.ModeloPersona;

public interface ModeloPersonaDAO extends Dao<ModeloPersona> {
		public List<ModeloPersona> getPersona(
				String tipoMensaje,
				Long cuil, 
				String tipoDocumento, 
				Long nroDocumento, 
				String apellido, 
				String nombre, 
				String sexo,
				Date fechaNacimiento) throws CustomException;
}
