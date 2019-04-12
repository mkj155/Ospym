package com.osdepym.service;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;

import com.osdepym.dto.CategoriaDTO;
import com.osdepym.dto.MotivoCategoriaDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.form.ContactoForm;
import com.osdepym.hibernate.dao.MotivoCategoriaDAO;
import com.osdepym.hibernate.entity.Categoria;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.MotivoCategoria;
import com.osdepym.utils.Constants;
import com.osdepym.utils.MailingTLS;

public class ContactoService {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private MotivoCategoriaDAO motivoCategoriaDAO ;

	public MotivoCategoriaDAO getMotivoCategoriaDAO() {
		return motivoCategoriaDAO;
	}

	public void setMotivoCategoriaDAO(MotivoCategoriaDAO motivoCategoriaDAO) {
		this.motivoCategoriaDAO = motivoCategoriaDAO;
	}
	
	@Transactional
	public List<MotivoCategoriaDTO> getAllMotivos() throws CustomException {
		List<MotivoCategoriaDTO> motivoCategoriaDTO = new ArrayList<MotivoCategoriaDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<MotivoCategoria> motivoCategorias = motivoCategoriaDAO.getAll();
			if (motivoCategorias != null) {
				for (MotivoCategoria motivoCategoria : motivoCategorias) {
					motivoCategoriaDTO.add(entityToDTO(motivoCategoria));
				}
			}
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return motivoCategoriaDTO;
	}
	
	private MotivoCategoriaDTO entityToDTO(MotivoCategoria motivoCategoria) {
		MotivoCategoriaDTO motivoCategoriaDTO = new MotivoCategoriaDTO();
		BeanUtils.copyProperties(motivoCategoria, motivoCategoriaDTO);
		return motivoCategoriaDTO;
	}
	
	@Transactional
	private String getSecuence() throws CustomException {
		String secuence = "";
		try {
			Integer result = motivoCategoriaDAO.getSecuence();
			secuence = String.format("%06d", result);
			String year = Year.now().toString();
			String month = String.format("%02d", Calendar.getInstance().get(Calendar.MONTH));
			String day = String.format("%02d", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
			secuence = year + month + day + secuence;
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return secuence;
	}
	
	@Transactional
	private void saveContacto(Contacto contacto) throws CustomException{
		try {
			motivoCategoriaDAO.saveContacto(contacto);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
	}
	
	@Transactional
	public List<CategoriaDTO> getCategoriasByMotivoId(int idMotivo) throws CustomException{
		List<CategoriaDTO> categoriasDTO = new ArrayList<CategoriaDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Categoria> categorias = motivoCategoriaDAO.getCategoriasByMotivoId(idMotivo);
			if (categorias != null) {
				for (Categoria categoria : categorias) {
					categoriasDTO.add(entityToDTO(categoria));
				}
			}
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return categoriasDTO;
	}

	private CategoriaDTO entityToDTO(Categoria categoria) {
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		BeanUtils.copyProperties(categoria, categoriaDTO);
		return categoriaDTO;	
	}
	
	public String procesarContacto(ContactoForm contactoForm) throws CustomException {
		String nroTramite = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			String correo = getMailByIds(contactoForm.getIdMotivo(), contactoForm.getIdCategoria());
			String motivo = getMotivoById(contactoForm.getIdMotivo());
			String categoria = getCategoriaById(contactoForm.getIdCategoria());
			String message = getMessage(contactoForm, motivo, categoria);
			nroTramite = getSecuence();
			String subject = getSubject(contactoForm, nroTramite);
			
			MailingTLS mailing = new MailingTLS();
			mailing.sendMailTLS(correo, subject, message);
			
			Contacto contacto = crearContacto(contactoForm, contactoForm.getIdMotivo(), contactoForm.getIdCategoria(), correo, nroTramite);
			saveContacto(contacto);
			
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return nroTramite;
	}
	
	@Transactional 
	private String getMotivoById(String idMotivo) throws CustomException {
		String motivo = null;
		try {
			motivo = motivoCategoriaDAO.getMotivoById(idMotivo);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return motivo;
	}

	@Transactional 
	private String getCategoriaById(String idCategoria) throws CustomException {
		String categoria = null;
		try {
			categoria = motivoCategoriaDAO.getCategoriaById(idCategoria);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return categoria;
	}

	private Contacto crearContacto(ContactoForm contactoForm, String idMotivo, String idCategoria, String correo, String nroTramite) {
		Contacto contacto = new Contacto();
		
		contacto.setIdtramite(nroTramite);
		contacto.setIdAfiliado(contactoForm.getIdAfiliado());
		contacto.setIdMotivo(Integer.valueOf(idMotivo));
		contacto.setIdCateg(Integer.valueOf(idCategoria));
		contacto.setNombreCompleto(contactoForm.getNombreAfiliado().toUpperCase());
		contacto.setComentario(contactoForm.getComentario());
		contacto.setFechaCreacion(new Date());
		contacto.setCorreo(correo);
		
		return contacto;
	}

	@Transactional
	public String getMailByIds(String idMotivo, String idCategoria) throws CustomException{
		String correo = null;
		try {
			correo = motivoCategoriaDAO.getMailByIds(idMotivo,idCategoria);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return correo;
	}
	
	private String getMessage(ContactoForm contactoForm, String motivo, String categoria) {
		StringBuilder sb = new StringBuilder();

		sb.append(Constants.TIPO_TRAMITE).append(": ").append(Constants.CONTACTO).append("\n");
		sb.append(Constants.MOTIVO).append(": ").append(motivo).append("\n");
		sb.append(Constants.CATEGORIA).append(": ").append(categoria).append("\n");
		sb.append(Constants.NRO_AFILIADO).append(": ").append(contactoForm.getIdAfiliado()).append("\n");
		sb.append(Constants.TITULAR).append(": ").append(contactoForm.getNombreAfiliado().toUpperCase()).append("\n");
		sb.append(Constants.TEXTO).append(": ").append(contactoForm.getComentario()).append("\n");

		return sb.toString();
	}
	
	private String getSubject(ContactoForm contactoForm, String nroTramite) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(Constants.CONTACTO).append(" - ");
		sb.append(nroTramite).append(" - ");
		sb.append(contactoForm.getIdAfiliado()).append(" - ");
		sb.append(contactoForm.getNombreAfiliado().toUpperCase());

		return sb.toString();
	}


}
