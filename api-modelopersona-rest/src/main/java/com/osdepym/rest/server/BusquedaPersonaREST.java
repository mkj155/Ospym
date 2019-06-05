package com.osdepym.rest.server;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.osdepym.rest.dao.ModeloPersonaDAO;
import com.osdepym.rest.entity.AfiliadoCompleto;
import com.osdepym.rest.json.BusquedaPersonaFullResponse;
import com.osdepym.rest.json.BusquedaPersonaRequest;
import com.osdepym.rest.json.BusquedaPersonaResponse;
import com.osdepym.rest.json.Cuil;
import com.osdepym.rest.json.DocumentoIdentidad;
import com.osdepym.rest.json.Mensaje;
import com.osdepym.rest.json.PersonaFisicaResponse;

@RestController
public class BusquedaPersonaREST extends RestTemplate {

	@Autowired
	private SessionFactory sessionFactory;

	Logger logger = LoggerFactory.getLogger(BusquedaPersonaREST.class);
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private ModeloPersonaDAO modeloPersonaDAO ;

	public ModeloPersonaDAO getModeloPersonaDAO() {
		return modeloPersonaDAO;
	}

	public void setModeloPersonaDAO(ModeloPersonaDAO modeloPersonaDAO) {
		this.modeloPersonaDAO = modeloPersonaDAO;
	}
	
	
	@RequestMapping(value="/api-modelopersona-rest/buscarPersona", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public BusquedaPersonaFullResponse testJson(@RequestBody BusquedaPersonaRequest jsonBody)  {
		Session session = null;
		Transaction tx = null;
		BusquedaPersonaFullResponse response = new BusquedaPersonaFullResponse();
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<AfiliadoCompleto> afiliados = modeloPersonaDAO.getPersona(jsonBody.getPersonaFisica());
			response.setRespuesta(getResponse(afiliados));
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			tx.rollback();
			session.close();
			logger.error(e.getMessage().toString());
			response.setRespuesta(getErrorResponse());
		}finally {
			response.setPersonaFisica(jsonBody.getPersonaFisica());
			response.setSender(jsonBody.getSender());
			response.setTipoMensaje(jsonBody.getTipoMensaje());
			
		}
		return response;
	}
	
	private BusquedaPersonaResponse getResponse(List<AfiliadoCompleto> afiliados) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		BusquedaPersonaResponse busquedaPersonaResponse = new BusquedaPersonaResponse();
		Mensaje mensaje = new Mensaje();
		if(afiliados.size() > 0) {
			busquedaPersonaResponse.setEncontrada(true);
			mensaje.setCodigo("000");
			mensaje.setMensaje("Existe la persona");
		}else {
			busquedaPersonaResponse.setEncontrada(false);
			mensaje.setCodigo("001");
			mensaje.setMensaje("No existe la persona");
		}
		busquedaPersonaResponse.setCantidad(afiliados.size());
		busquedaPersonaResponse.setMensaje(mensaje);
		ArrayList<PersonaFisicaResponse> personas = new ArrayList<PersonaFisicaResponse>();
		for(AfiliadoCompleto afiliado : afiliados){
			PersonaFisicaResponse persona = new PersonaFisicaResponse();
			Cuil cuil = new Cuil();
			cuil.setId(afiliado.getCUIL());
			
			
			cuil.setFechaInicio(dateFormat.format(afiliado.getFechaVigenciaDesdeCUIL()));
			DocumentoIdentidad documentoIdentidad = new DocumentoIdentidad();
			documentoIdentidad.setNumero(afiliado.getNroDocumento());
			documentoIdentidad.setTipo(afiliado.getTipoDocumento());
			persona.setApellido(afiliado.getApellido());
			persona.setCUIL(cuil);
			ArrayList<DocumentoIdentidad> listaDocumentos = new ArrayList<DocumentoIdentidad>();
			listaDocumentos.add(documentoIdentidad);
			persona.setDocumentoIdentidad(listaDocumentos);
			persona.setFechaNacimiento(dateFormat.format(afiliado.getFechaNacimiento()));
			persona.setNombre(afiliado.getNombre());
			persona.setPersonaID(afiliado.getPersonaId());
			persona.setSexo(afiliado.getSexo());
			
			personas.add(persona);
		}
		busquedaPersonaResponse.setPersonas(personas);
		return busquedaPersonaResponse;
	}
	
	private BusquedaPersonaResponse getErrorResponse() {
		BusquedaPersonaResponse busquedaPersonaResponse = new BusquedaPersonaResponse();
		Mensaje mensaje = new Mensaje();
		
			busquedaPersonaResponse.setEncontrada(false);
			mensaje.setCodigo("002");
			mensaje.setMensaje("Error al intentar realizar la búsqueda, verifique los datos enviados");
		
		busquedaPersonaResponse.setMensaje(mensaje);
		
		
		return busquedaPersonaResponse;
	}
	
	
	
}

