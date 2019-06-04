package com.osdepym.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.rest.entity.ModeloPersona;

@Repository
public class ModeloPersonaDAOImpl implements ModeloPersonaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<ModeloPersona> getPersona(
			String tipoMensaje,
			Long cuil, 
			String tipoDocumento, 
			Long nroDocumento, 
			String apellido, 
			String nombre, 
			String sexo,
			Date fechaNacimiento) throws CustomException {
		try {
			List<ModeloPersona> b = new ArrayList<ModeloPersona>();
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT Id_Afiliado FROM dbo.v_familiares_a_cargo"; 
			
			if(tipoMensaje != null || cuil != null || tipoDocumento != null || nroDocumento != null || apellido != null || nombre != null || sexo != null || fechaNacimiento != null) { 
				sqlString += " WHERE ";
				
				sqlString += (tipoMensaje != null) ? "tipoMensaje = " + tipoMensaje + " AND " : "";
				sqlString += (cuil != null) ? "cuil = " + cuil + " AND " : "";
				sqlString += (tipoDocumento != null) ? "tipoDocumento = " + tipoDocumento + " AND " : "";
				sqlString += (nroDocumento != null) ? "nroDocumento = " + nroDocumento + " AND " : ""; 
				sqlString += (apellido != null) ? "apellido = " + apellido + " AND " : ""; 
				sqlString += (nombre != null) ? "nombre = " + nombre + " AND " : ""; 
				sqlString += (sexo != null) ? "sexo = " + sexo + " AND " : "";
				sqlString += (fechaNacimiento != null) ? "fechaNacimiento = " + fechaNacimiento + " AND " : "";
				
				sqlString = sqlString.substring(0, sqlString.lastIndexOf(" AND "));
			}
			
			b = session.createNativeQuery(sqlString, ModeloPersona.class).getResultList();
			return b;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
	
	@Override
	public void actualizarPersona(Long cuil, 
			String tipoDocumento, 
			Long nroDocumento, 
			String apellido, 
			String nombre, 
			String sexo,
			Date fechaNacimiento,
			Date fechaInicioCuil) throws CustomException {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createNativeQuery("BEGIN dbo.Spo_PersonaFisicaActualizar(TipoDocumento=>?,Nrodocumento=>?,CUIL=>?,FechaInicioCUIL=>?,Apellido=>?,Nombre=>?,FechaNacimiento=>?,Sexo=>?); END;");
			query.setParameter(1, tipoDocumento);
			query.setParameter(2, nroDocumento);
			query.setParameter(3, cuil);
			query.setParameter(4, fechaInicioCuil);
			query.setParameter(5, apellido);
			query.setParameter(6, nombre);
			query.setParameter(7, fechaNacimiento);
			query.setParameter(8, sexo);
			query.executeUpdate();
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

}
