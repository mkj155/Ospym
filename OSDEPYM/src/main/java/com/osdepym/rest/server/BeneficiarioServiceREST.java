package com.osdepym.rest.server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.osdepym.dto.BeneficiarioDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.dao.BeneficiarioDAO;
import com.osdepym.hibernate.entity.Beneficiario;
import com.osdepym.rest.response.BeneficiariosResponse;
import com.osdepym.util.SessionUtil;


@RestController
public class BeneficiarioServiceREST extends RestTemplate{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private BeneficiarioDAO beneficiarioDAO ;

	public BeneficiarioDAO getBeneficiarioDAO() {
		return beneficiarioDAO;
	}

	public void setBeneficiarioDAO(BeneficiarioDAO beneficiarioDAO) {
		this.beneficiarioDAO = beneficiarioDAO;
	}
	
	@RequestMapping(value="/getBeneficiarios", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public BeneficiariosResponse getBeneficiarios(@RequestParam(value="idAfiliado") Long idAfiliado) throws CustomException {
		List<BeneficiarioDTO> beneficiariosList = new ArrayList<BeneficiarioDTO>();
		BeneficiariosResponse beneficiariosResponse = new BeneficiariosResponse(beneficiariosList);
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Beneficiario> beneficiarios = beneficiarioDAO.getBeneficiariosByIdAfiliado(idAfiliado);
			if (beneficiarios != null) {
				for (Beneficiario element : beneficiarios) {
					beneficiariosList.add(entityToDTO(element));
				}
				beneficiariosResponse = new BeneficiariosResponse(beneficiariosList);
			}
			tx.commit();
			session.close();
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return beneficiariosResponse;
	}
	
	private BeneficiarioDTO entityToDTO(Beneficiario beneficiario) {
		return new BeneficiarioDTO(beneficiario.getIdAfiliado(), beneficiario.getIdTitular(), beneficiario.getApellido(), beneficiario.getNombre());
	}
}
