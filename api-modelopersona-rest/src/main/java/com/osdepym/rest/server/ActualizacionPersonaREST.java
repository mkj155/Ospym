package com.osdepym.rest.server;

import javax.servlet.http.HttpServletResponse;

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

import com.osdepym.exception.CustomException;
import com.osdepym.rest.dao.ModeloPersonaDAO;
import com.osdepym.rest.json.ActualizacionPersonaFullResponse;
import com.osdepym.rest.json.ActualizacionPersonaResponse;
import com.osdepym.rest.json.BusquedaPersonaRequest;
import com.osdepym.rest.json.Mensaje;

@RestController
public class ActualizacionPersonaREST extends RestTemplate {

	Logger logger = LoggerFactory.getLogger(ActualizacionPersonaREST.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private ModeloPersonaDAO modeloPersonaDAO;

	public ModeloPersonaDAO getModeloPersonaDAO() {
		return modeloPersonaDAO;
	}

	public void setModeloPersonaDAO(ModeloPersonaDAO modeloPersonaDAO) {
		this.modeloPersonaDAO = modeloPersonaDAO;
	}

	@RequestMapping(value = "/api-modelopersona-rest/actualizarPersona", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ActualizacionPersonaFullResponse testJson(@RequestBody BusquedaPersonaRequest jsonBody, HttpServletResponse response) throws CustomException{
		boolean isSuccess = true;
		Session session = null;
		Transaction tx = null;
		ActualizacionPersonaFullResponse jsonResponse = new ActualizacionPersonaFullResponse();
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			modeloPersonaDAO.actualizarPersona(jsonBody.getPersonaFisica());
			tx.commit();
			session.close();
		}
		catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		}
		catch (Exception e) {
			tx.rollback();
			session.close();
			logger.error(e.getStackTrace().toString());
			logger.error(e.getMessage().toString());
			throw new CustomException();
		}
		
			jsonResponse.setPersonaFisica(jsonBody.getPersonaFisica());
			jsonResponse.setSender(jsonBody.getSender());
			jsonResponse.setTipoMensaje(jsonBody.getTipoMensaje());
			jsonResponse.setRespuesta(getResponse(isSuccess));
		
		return jsonResponse;
	}

	private ActualizacionPersonaResponse getResponse(boolean isSuccess) {

		ActualizacionPersonaResponse actualizacionPersonaResponse = new ActualizacionPersonaResponse();
		Mensaje mensaje = new Mensaje();

		if(isSuccess) {
			actualizacionPersonaResponse.setEncontrada(true);
			mensaje.setCodigo("000");
			mensaje.setMensaje("Datos actualizados correctamente");
		}else {
			actualizacionPersonaResponse.setEncontrada(false);
			mensaje.setCodigo("001");
			mensaje.setMensaje("Error al actualizar los datos");
		}
		
		actualizacionPersonaResponse.setMensaje(mensaje);

		return actualizacionPersonaResponse;
	}
}
