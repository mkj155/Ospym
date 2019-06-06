package com.osdepym.rest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.exception.CustomException;
import com.osdepym.rest.entity.AfiliadoCompleto;
import com.osdepym.rest.json.Cuil;
import com.osdepym.rest.json.DocumentoIdentidad;
import com.osdepym.rest.json.PersonaFisicaRequest;

@Repository
public class ModeloPersonaDAOImpl implements ModeloPersonaDAO {

	Logger logger = LoggerFactory.getLogger(ModeloPersonaDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<AfiliadoCompleto> getPersona(PersonaFisicaRequest personaFisicaRequest){
	
		try {
			ArrayList<DocumentoIdentidad> documentos = personaFisicaRequest.getDocumentoIdeantidad();
			Cuil cuil = personaFisicaRequest.getCUIL();
			String whereClause = "";
			if(documentos.size() > 0) {
				whereClause += "(";
				for(DocumentoIdentidad doc : documentos) {
					if(!whereClause.equals("(")) {
						whereClause += " OR ";
					}
					whereClause += "(TipoDocumento = '" + doc.getTipo() + "' AND NroDocumento = '" + doc.getNumero() + "')";
				}
				whereClause += ") ";
			}
			
			
			if(!personaFisicaRequest.getApellido().equals("")) {
				if(!whereClause.equals("")) {
					whereClause += " AND ";
				}
				whereClause += "Apellido = '" + personaFisicaRequest.getApellido() + "'";
			}
			
			
			if(!personaFisicaRequest.getNombre().equals("")) {
				if(!whereClause.equals("")) {
					whereClause += " AND ";
				}
				whereClause += "Nombre = '" + personaFisicaRequest.getNombre() + "'";
			}
			
			
			if(!personaFisicaRequest.getFechaNacimiento().equals("")) {
				if(!whereClause.equals("")) {
					whereClause += " AND ";
				}
				whereClause += "CAST(FechaNacimiento AS DATE) = CAST('" + personaFisicaRequest.getFechaNacimiento() + "' AS DATE)";
			}
			
			
			if(!cuil.getId().equals("")) {
				if(!whereClause.equals("")) {
					whereClause += " AND ";
				}
				whereClause += "CUIL = '" + cuil.getId() + "'";
			}
			
			if(!cuil.getFechaInicio().equals("")) {
				if(!whereClause.equals("")) {
					whereClause += " AND ";
				}
				whereClause += "CAST(FechaVigenciaDesdeCUIL AS DATE) = CAST('" + cuil.getFechaInicio() + "' AS DATE)";
			}
			
			List<AfiliadoCompleto> b = new ArrayList<AfiliadoCompleto>();
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT Persona_ID, Apellido, Nombre, FechaNacimiento, Sexo, CUIL, FechaVigenciaDesdeCUIL, TipoDocumento, NroDocumento FROM mp.vo_PersonaFisicaAfiliadoCompleto WHERE " + whereClause;
			b = session.createNativeQuery(sqlString, AfiliadoCompleto.class).getResultList();
			return b;
		}catch(Exception e){
			logger.error(e.getStackTrace().toString());
			logger.error(e.getMessage());
			throw e;
		}
		
	}
	
	
	@Override
	public void actualizarPersona(PersonaFisicaRequest personaFisicaRequest) throws CustomException{
		try {
			StoredProcedureQuery query = sessionFactory.createEntityManager().createNamedStoredProcedureQuery("PersonaFisicaActualizar");
			query.setParameter("TipoDocumento", personaFisicaRequest.getDocumentoIdeantidad().get(0).getTipo());
			query.setParameter("Nrodocumento", personaFisicaRequest.getDocumentoIdeantidad().get(0).getNumero().toString());
			query.setParameter("CUIL", personaFisicaRequest.getCUIL().getId());
			query.setParameter("FechaInicioCUIL", personaFisicaRequest.getCUIL().getFechaInicio());
			query.setParameter("Apellido", personaFisicaRequest.getApellido());
			query.setParameter("Nombre", personaFisicaRequest.getNombre());
			query.setParameter("FechaNacimiento", personaFisicaRequest.getFechaNacimiento());
			query.setParameter("Sexo", personaFisicaRequest.getSexo());
			query.execute();
		}catch(Exception e){
			logger.error(e.getStackTrace().toString());
			logger.error(e.getMessage());
			throw new CustomException();
		}
		
	}

}
