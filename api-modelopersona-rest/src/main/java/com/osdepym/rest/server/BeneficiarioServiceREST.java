package com.osdepym.rest.server;

import java.util.List;

import javax.sql.DataSource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.osdepym.hibernate.entity.Categoria;
import com.osdepym.hibernate.entity.EspecialidadDAOImpl;

@RestController
public class BeneficiarioServiceREST extends RestTemplate {

	@Autowired
	private SessionFactory sessionFactory;
	
	Logger logger = LoggerFactory.getLogger(BeneficiarioServiceREST.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private DataSource dataSource;
	@Autowired
	private Environment env;

	@Autowired
	private EspecialidadDAOImpl especialidadPrestacionDAO;

	public EspecialidadDAOImpl getEspecialidadPrestacionDAO() {
		return especialidadPrestacionDAO;
	}

	public void setEspecialidadPrestacionDAO(EspecialidadDAOImpl especialidadPrestacionDAO) {
		this.especialidadPrestacionDAO = especialidadPrestacionDAO;
	}

	@RequestMapping(value="/getBeneficiarios", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void getBeneficiarios(@RequestParam(value="idAfiliado") Long idAfiliado) {
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Categoria> categorias = especialidadPrestacionDAO.getAll();
			System.out.println(categorias.size());
			logger.error("ererereadssadsadsada asda sd adas das das dasd ada das das dasd asd adgfdgfdg");
			tx.commit();
			session.close();
		}catch(Exception e){
			logger.error(e.getStackTrace().toString());
		}
	}

}
