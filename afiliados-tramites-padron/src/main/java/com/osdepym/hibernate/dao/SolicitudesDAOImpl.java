package com.osdepym.hibernate.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
			/*Session session = this.sessionFactory.getCurrentSession();
			StringBuilder query = new StringBuilder("SELECT Registro_ID, ObraSocial, TipoCarga , TipoAfiliado , CUIT, CUIL, Apellido, Nombre, TipoDocumento, NroDocumento, Direccion, DireccionNumero, DireccionPiso, DireccionDepartamento, DireccionLocalidad, DireccionProvincia, CodigoPostal, Telefono, Email, FechaNacimiento, Sexo, EstadoCivil, CUILTitular, FechaInicio, CentroMedico, Plan, Estado, Solicitud_ID, Archivo, FechaCarga, CodigoError, DescripcionError FROM ga.vo_solicitud");
			Boolean isFirst = true; 
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    if(form.getApellido() != null) {
				if(isFirst)
					query.append(" WHERE Apellido = '" + form.getApellido() + "'");
				else
					query.append(" AND Apellido = '" + form.getApellido() + "'");
		    }
		    
		    if(form.getCuil() != null) {
				if(isFirst)
					query.append(" WHERE CUIL = " + form.getCuil());
				else
					query.append(" AND CUIL = " + form.getCuil());
		    }
		    
		    if(form.getCuit() != null) {
				if(isFirst)
					query.append(" WHERE CUIT = " + form.getCuit());
				else
					query.append(" AND CUIT = " + form.getCuit());
		    }

		    if(form.getDni() != null) {
				if(isFirst)
					query.append(" WHERE NroDocumento = " + form.getDni());
				else
					query.append(" AND NroDocumento = " + form.getDni());
		    }

		    if(form.getEstado() != null) {
				if(isFirst)
					query.append(" WHERE Estado = '" + form.getEstado() + "'");
				else
					query.append(" AND Estado = '" + form.getEstado() + "'");
		    }
		    
		    if(form.getFechaCarga() != null) {
				if(isFirst)
					query.append(" WHERE FechaCarga = '" + sdf.format(form.getFechaCarga()) + "'");
				else
					query.append(" AND FechaCarga = '" + sdf.format(form.getFechaCarga()) + "'");
		    }
		    
		    if(form.getNombre() != null) {
				if(isFirst)
					query.append(" WHERE Nombre = '" + form.getNombre() + "'");
				else
					query.append(" AND Nombre = '" + form.getNombre() + "'");
		    }
		    
		    if(form.getNumeroRegistro() != null) {
				if(isFirst)
					query.append(" WHERE Registro_ID = " + form.getNumeroRegistro());
				else
					query.append(" AND Registro_ID = " + form.getNumeroRegistro());
		    }
		    
		    if(form.getNumeroSolicitud() != null) {
				if(isFirst)
					query.append(" WHERE Solicitud_ID = " + form.getNumeroSolicitud());
				else
					query.append(" AND Solicitud_ID = " + form.getNumeroSolicitud());
		    }
		    
		    if(form.getObraSocial() != null) {
				if(isFirst)
					query.append(" WHERE Apellido = '" + form.getObraSocial() + "'");
				else
					query.append(" AND Apellido = '" + form.getObraSocial() + "'");
		    }
			aList = session.createNativeQuery(query.toString(), Afiliado.class).getResultList();*/
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		
		/* INICIO TEST */
		Afiliado obj1 = new Afiliado();
		obj1.setNombre("TEST 1");
		aList.add(obj1);
		
		Afiliado obj2 = new Afiliado();
		obj1.setNombre("TEST 2");
		aList.add(obj2);
		
		Afiliado obj3 = new Afiliado();
		obj1.setNombre("TEST 3");
		aList.add(obj3);
		
		Afiliado obj4 = new Afiliado();
		obj1.setNombre("TEST 4");
		aList.add(obj4);
		/* FIN TEST */
		
		return aList;
	}
	
	public List<ObraSocial> getAllObrasSociales() throws CustomException {
		List<ObraSocial> osList = new ArrayList<ObraSocial>();
		try {
			/*Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT * FROM ga.vo_ObraSocial";
			osList = session.createNativeQuery(sqlString, ObraSocial.class).getResultList();*/
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		
		/* INICIO TEST */
		ObraSocial obj1 = new ObraSocial();
		obj1.setId(new Long(1)); obj1.setNombre("Obra Social 1");
		osList.add(obj1);
		
		ObraSocial obj2 = new ObraSocial();
		obj2.setId(new Long(2)); obj2.setNombre("Obra Social 2");
		osList.add(obj2);
		
		ObraSocial obj3 = new ObraSocial();
		obj3.setId(new Long(3)); obj3.setNombre("Obra Social 3");
		osList.add(obj3);
		
		ObraSocial obj4 = new ObraSocial();
		obj4.setId(new Long(4)); obj4.setNombre("Obra Social 4");
		osList.add(obj4);
		
		ObraSocial obj5 = new ObraSocial();
		obj5.setId(new Long(5)); obj5.setNombre("Obra Social 5");
		osList.add(obj5);
		/* FIN TEST */
		
		return osList;
	}
	
	public List<Estado> getAllEstados() throws CustomException {
		List<Estado> estadoList = new ArrayList<Estado>();
		try {
			/*Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT * FROM ga.vo_RegistroEstado";
			estadoList = session.createNativeQuery(sqlString, Estado.class).getResultList();*/
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
		
		/* INICIO TEST */
		Estado obj1 = new Estado();
		obj1.setId(new Long(1)); obj1.setNombre("Estado 1");
		estadoList.add(obj1);
		
		Estado obj2 = new Estado();
		obj2.setId(new Long(2)); obj2.setNombre("Estado 2");
		estadoList.add(obj2);
		
		Estado obj3 = new Estado();
		obj3.setId(new Long(3)); obj3.setNombre("Estado 3");
		estadoList.add(obj3);
		
		Estado obj4 = new Estado();
		obj4.setId(new Long(4)); obj4.setNombre("Estado 4");
		estadoList.add(obj4);
		
		Estado obj5 = new Estado();
		obj5.setId(new Long(5)); obj5.setNombre("Estado 5");
		estadoList.add(obj5);
		/* FIN TEST */
		
		return estadoList;
	}
}
