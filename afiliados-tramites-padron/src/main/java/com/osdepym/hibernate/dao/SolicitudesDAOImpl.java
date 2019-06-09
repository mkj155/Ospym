package com.osdepym.hibernate.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.hibernate.entity.Afiliado;
import com.osdepym.hibernate.entity.Estado;
import com.osdepym.hibernate.entity.ObraSocial;
import com.osdepym.util.ValidateUtil;

@Repository
public class SolicitudesDAOImpl implements SolicitudesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Afiliado get(Long id) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Afiliado> getAll() throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Afiliado t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Afiliado t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Afiliado t) throws CustomException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Afiliado> buscar(SolicitudesForm form) throws CustomException {
		List<Afiliado> aList = new ArrayList<Afiliado>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			StringBuilder query = new StringBuilder("SELECT Registro_ID, ObraSocial, TipoCarga , TipoAfiliado , CUIT, CUIL, Apellido, Nombre, TipoDocumento, NroDocumento, Direccion, DireccionNumero, DireccionPiso, DireccionDepartamento, DireccionLocalidad, DireccionProvincia, CodigoPostal, Telefono, Email, FechaNacimiento, Sexo, EstadoCivil, CUILTitular, FechaInicio, CentroMedico, CodigoPlan, Estado, Solicitud_ID, Archivo, FechaCarga, CodigoError, DescripcionError FROM ga.vo_solicitud");
			Boolean isFirst = true; 
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    if(ValidateUtil.isNotEmpty(form.getApellido())) {
				if(isFirst) {
					query.append(" WHERE Apellido = '" + form.getApellido() + "'");
					isFirst = false;
				} else {
					query.append(" AND Apellido = '" + form.getApellido() + "'");
				}
		    }
		    
		    if(ValidateUtil.isNotEmpty(form.getCuil())) {
				if(isFirst) {
					query.append(" WHERE CUIL = " + form.getCuil());
					isFirst = false;
				} else {
					query.append(" AND CUIL = " + form.getCuil());
				} 
		    }
		    
		    if(ValidateUtil.isNotEmpty(form.getCuit())) {
				if(isFirst) {
					query.append(" WHERE CUIT = " + form.getCuit());
					isFirst = false;
				} else {
					query.append(" AND CUIT = " + form.getCuit());
				} 
		    }

		    if(ValidateUtil.isNotEmpty(form.getDni())) {
				if(isFirst) {
					query.append(" WHERE NroDocumento = '" + form.getDni() + "'");
					isFirst = false;
				} else {
					query.append(" AND NroDocumento = '" + form.getDni() + "'");
				} 
		    }

		    if(ValidateUtil.isNotEmpty(form.getEstado())) {
				if(isFirst) {
					query.append(" WHERE Estado = '" + form.getEstado() + "'");
					isFirst = false;
				} else {
					query.append(" AND Estado = '" + form.getEstado() + "'");
				} 
		    }
		    
		    if(ValidateUtil.isNotEmpty(form.getFechaCarga())) {
				if(isFirst) {
					query.append(" WHERE FechaCarga = '" + sdf.format(form.getFechaCarga()) + "'");
					isFirst = false;
				} else {
					query.append(" AND FechaCarga = '" + sdf.format(form.getFechaCarga()) + "'");
				} 
		    }
		    
		    if(ValidateUtil.isNotEmpty(form.getNombre())) {
				if(isFirst) {
					query.append(" WHERE Nombre = '" + form.getNombre() + "'");
					isFirst = false;
				} else {
					query.append(" AND Nombre = '" + form.getNombre() + "'");
				} 
		    }
		    
		    if(ValidateUtil.isNotEmpty(form.getNumeroRegistro())) {
				if(isFirst) {
					query.append(" WHERE Registro_ID = " + form.getNumeroRegistro());
					isFirst = false;
				} else {
					query.append(" AND Registro_ID = " + form.getNumeroRegistro());
				} 
		    }
		    
		    if(ValidateUtil.isNotEmpty(form.getNumeroSolicitud())) {
				if(isFirst) {
					query.append(" WHERE Solicitud_ID = " + form.getNumeroSolicitud());
				 	isFirst = false;
				} else {
					query.append(" AND Solicitud_ID = " + form.getNumeroSolicitud());
				} 
		    }
		    
		    if(ValidateUtil.isNotEmpty(form.getObraSocial())) {
				if(isFirst) {
					query.append(" WHERE ObraSocial = '" + form.getObraSocial() + "'");
					isFirst = false;
				} else {
					query.append(" AND ObraSocial = '" + form.getObraSocial() + "'");
				} 
		    }
			aList = session.createNativeQuery(query.toString(), Afiliado.class).getResultList();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		
		/* INICIO TEST */
		Afiliado obj1 = new Afiliado();
		obj1.setNombre("TEST 1");
		obj1.setEstado("Pendiente");
		aList.add(obj1);
		
		Afiliado obj2 = new Afiliado();
		obj2.setNombre("TEST 2");
		obj2.setEstado("Pendiente");
		aList.add(obj2);
		
		Afiliado obj3 = new Afiliado();
		obj3.setNombre("TEST 3");
		aList.add(obj3);
		
		Afiliado obj4 = new Afiliado();
		obj4.setNombre("TEST 4");
		aList.add(obj4);
		/* FIN TEST */
		
		return aList;
	}
	
	public List<ObraSocial> getAllObrasSociales() throws CustomException {
		List<ObraSocial> osList = new ArrayList<ObraSocial>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT ObraSocial_ID, DescripcionObraSocial FROM ga.vo_ObraSocial";
			osList = session.createNativeQuery(sqlString, ObraSocial.class).getResultList();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		
		return osList;
	}
	
	public List<Estado> getAllEstados() throws CustomException {
		List<Estado> estadoList = new ArrayList<Estado>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT EstadoRegistro_ID, DescripcionEstado FROM ga.vo_EstadoRegistro";
			estadoList = session.createNativeQuery(sqlString, Estado.class).getResultList();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}

		return estadoList;
	}
	
	@Override
	public Integer obtenerSolicitudMultiple() throws CustomException {
		Integer value;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			StoredProcedureQuery storedProcedure = session.createStoredProcedureQuery("ga.spo_obtenerSolicitudMultiple");
			storedProcedure.registerStoredProcedureParameter("Solicitud_ID", Integer.class, ParameterMode.OUT);
			storedProcedure.execute();
			value = (Integer)storedProcedure.getOutputParameterValue("Solicitud_ID");
			return value;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
	
	@Override
	public boolean confirmarAltaAfiliado(Integer id) throws CustomException {
		String error;
		String mensaje;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			StoredProcedureQuery storedProcedure = session.createStoredProcedureQuery("ga.spo_confirmarAltaAfiliado");
			storedProcedure.registerStoredProcedureParameter("Registro_ID", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("Error",       String.class,  ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("Mensaje",     String.class,  ParameterMode.OUT);
			storedProcedure.setParameter("Registro_ID", id);
			storedProcedure.execute();
			error   = (String)storedProcedure.getOutputParameterValue("Error");
			mensaje = (String)storedProcedure.getOutputParameterValue("Mensaje");
			return true;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
	
}
