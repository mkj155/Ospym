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

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.dto.AfiliadoTableDTO;
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
			int numberOfRecords = 500;
			StringBuilder query = new StringBuilder("SELECT TOP " + numberOfRecords + " Registro_ID, ObraSocial, TipoCarga , TipoAfiliado , CUIT, CUIL, Apellido, Nombre, TipoDocumento, NroDocumento, Direccion, DireccionNumero, DireccionPiso, DireccionDepartamento, DireccionLocalidad, DireccionProvincia, CodigoPostal, Telefono, Email, FechaNacimiento, Sexo, EstadoCivil, CUILTitular, FechaInicio, CentroMedico, CodigoPlan, Estado, Solicitud_ID, Archivo, FechaCarga, CodigoError, DescripcionError FROM ga.vo_solicitud");
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
		obj1.setRegistroID(1);
		obj1.setNombre("TEST 1");
		obj1.setEstado("Pendiente");
		aList.add(obj1);
		
		Afiliado obj2 = new Afiliado();
		obj2.setRegistroID(2);
		obj2.setNombre("TEST 2");
		obj2.setEstado("Pendiente");
		aList.add(obj2);
		
		Afiliado obj3 = new Afiliado();
		obj3.setRegistroID(3);
		obj3.setNombre("TEST 3");
		aList.add(obj3);
		
		Afiliado obj4 = new Afiliado();
		obj4.setRegistroID(4);
		obj4.setNombre("TEST 4");
		aList.add(obj4);
		
		Afiliado obj5 = new Afiliado();
		obj5.setRegistroID(5);
		obj5.setNombre("TEST 5");
		obj5.setEstado("Pendiente");
		aList.add(obj5);
		
		Afiliado obj6 = new Afiliado();
		obj6.setRegistroID(6);
		obj6.setNombre("TEST 6");
		obj6.setEstado("Pendiente");
		aList.add(obj6);
		
		Afiliado obj7 = new Afiliado();
		obj7.setRegistroID(7);
		obj7.setNombre("TEST 7");
		aList.add(obj7);
		
		Afiliado obj8 = new Afiliado();
		obj8.setRegistroID(8);
		obj8.setNombre("TEST 8");
		aList.add(obj8);
		
		Afiliado obj9 = new Afiliado();
		obj9.setRegistroID(9);
		obj9.setNombre("TEST 9");
		obj9.setEstado("Pendiente");
		aList.add(obj9);
		
		Afiliado obj10 = new Afiliado();
		obj10.setRegistroID(10);
		obj10.setNombre("TEST 10");
		obj10.setEstado("Pendiente");
		aList.add(obj10);
		
		Afiliado obj11 = new Afiliado();
		obj11.setRegistroID(11);
		obj11.setNombre("TEST 11");
		aList.add(obj11);
		
		Afiliado obj12 = new Afiliado();
		obj12.setRegistroID(12);
		obj12.setNombre("TEST 12");
		aList.add(obj12);
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
	
	@Override
	public Integer archivoCargaMasivaObtenerIdentificar(Integer obraSocial, Integer tipoCarga, Integer tipoAfiliado, String cuit, Integer pauta, String nombreArchivo) throws CustomException {
		Integer archivoId;
		String error;
		String mensaje;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			StoredProcedureQuery storedProcedure = session.createStoredProcedureQuery("ga.spo_ArchivoCargaMasivaObtenerIdentificar");
			storedProcedure.registerStoredProcedureParameter("ObraSocial_ID", 	Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("TipoCarga_ID", 	Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("TipoAfiliado_ID", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("CUIT", 			String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("Pauta_ID", 		Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("ArchivoNombre", 	String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("Archivo_id",		Integer.class, ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("Error",			String.class,  ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("Mensaje",			String.class,  ParameterMode.OUT);
			storedProcedure.setParameter("ObraSocial_ID", 	obraSocial);
			storedProcedure.setParameter("TipoCarga_ID", 	tipoCarga);
			storedProcedure.setParameter("TipoAfiliado_ID", tipoAfiliado);
			storedProcedure.setParameter("CUIT", 			cuit);
			storedProcedure.setParameter("Pauta_ID", 		pauta);
			storedProcedure.setParameter("ArchivoNombre", 	nombreArchivo);
			storedProcedure.execute();
			archivoId = (Integer)storedProcedure.getOutputParameterValue("Error");
			error     = (String) storedProcedure.getOutputParameterValue("Error");
			mensaje   = (String) storedProcedure.getOutputParameterValue("Mensaje");
			return archivoId;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	@Override
	public boolean archivoCargaMasivaCargarRegistro(Integer archivoId, AfiliadoDTO afiliado) throws CustomException {
		String error;
		String mensaje;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			StoredProcedureQuery storedProcedure = session.createStoredProcedureQuery("ga.spo_ArchivoCargaMasivaCargarRegistro");
			storedProcedure.registerStoredProcedureParameter("Archivo_ID",				Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("CUIL",					String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("Apellido",				String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("Nombre",					String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("TipoDocumento",			String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("NroDocumento",			String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DireccionCalle",			String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DireccionNumero",			String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DireccionPiso",			String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DireccionDepartamento",	String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DireccionLocalidad",		String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DireccionProvincia",		String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DireccionCodigoPostal",	String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DireccionTelefono",		String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("FechaNacimiento",			String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("Sexo",					String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("EstadoCivil",				String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("FechaInicioCobertura",	String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("Email",					String.class,  ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("Error",					String.class,  ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("Mensaje",					String.class,  ParameterMode.OUT);
			storedProcedure.setParameter("Archivo_ID", 				archivoId);
			storedProcedure.setParameter("CUIL",					afiliado.getCuil());
			storedProcedure.setParameter("Apellido",				afiliado.getApellido());
			storedProcedure.setParameter("Nombre",					afiliado.getNombre());
			storedProcedure.setParameter("TipoDocumento",			afiliado.getTipoDocumento());
			storedProcedure.setParameter("NroDocumento",			afiliado.getNroDocumento());
			storedProcedure.setParameter("DireccionCalle",			afiliado.getDireccion());
			storedProcedure.setParameter("DireccionNumero",			afiliado.getDireccionNumero());
			storedProcedure.setParameter("DireccionPiso",			afiliado.getDireccionPiso());
			storedProcedure.setParameter("DireccionDepartamento",	afiliado.getDireccionDepartamento());
			storedProcedure.setParameter("DireccionLocalidad",		afiliado.getDireccionLocalidad());
			storedProcedure.setParameter("DireccionProvincia",		afiliado.getDireccionProvincia());
			storedProcedure.setParameter("DireccionCodigoPostal",	afiliado.getCodigoPostal());
			storedProcedure.setParameter("DireccionTelefono",		afiliado.getTelefono());
			storedProcedure.setParameter("FechaNacimiento",			afiliado.getFechaNacimiento());
			storedProcedure.setParameter("Sexo",					afiliado.getSexo());
			storedProcedure.setParameter("EstadoCivil",				afiliado.getEstadoCivil());
			storedProcedure.setParameter("FechaInicioCobertura",	afiliado.getFechaInicio());
			storedProcedure.setParameter("Email",					afiliado.getEmail());
			storedProcedure.execute();
			error   = (String) storedProcedure.getOutputParameterValue("Error");
			mensaje = (String) storedProcedure.getOutputParameterValue("Mensaje");
			return true;
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}

	@Override
	public void anularAfiliado(AfiliadoTableDTO afiliado) throws CustomException {
		String error;
		String mensaje;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			StoredProcedureQuery storedProcedure = session.createStoredProcedureQuery("a.definir");
			/*storedProcedure.registerStoredProcedureParameter("Registro_ID", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("Error",       String.class,  ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("Mensaje",     String.class,  ParameterMode.OUT);
			storedProcedure.setParameter("Registro_ID", afiliado.getRegistroID());*/
			storedProcedure.execute();
			error   = (String)storedProcedure.getOutputParameterValue("Error");
			mensaje = (String)storedProcedure.getOutputParameterValue("Mensaje");
		} catch(Exception e){
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
}