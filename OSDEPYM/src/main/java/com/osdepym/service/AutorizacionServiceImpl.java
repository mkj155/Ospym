package com.osdepym.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.osdepym.dto.BeneficiarioDTO;
import com.osdepym.dto.EspecialidadDTO;
import com.osdepym.dto.PrestacionDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.form.AutorizacionForm;
import com.osdepym.hibernate.dao.AutorizacionDocDAO;
import com.osdepym.hibernate.dao.BeneficiarioDAO;
import com.osdepym.hibernate.dao.EspecialidadDAO;
import com.osdepym.hibernate.dao.EspecialidadPrestacionDAO;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.Especialidad;
import com.osdepym.hibernate.entity.Prestacion;
import com.osdepym.rest.response.BeneficiariosResponse;
import com.osdepym.rest.server.BeneficiarioServiceREST;
import com.osdepym.util.Constants;
import com.osdepym.util.MailingUtil;
import com.osdepym.util.ReadPropertyFile;
import com.osdepym.util.SessionUtil;

@Service("AutorizacionService")
public class AutorizacionServiceImpl implements AutorizacionService{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private EspecialidadPrestacionDAO especialidadPrestacionDAO ;

	public EspecialidadPrestacionDAO getEspecialidadPrestacionDAO() {
		return especialidadPrestacionDAO;
	}

	public void setEspecialidadPrestacionDAO(EspecialidadPrestacionDAO especialidadPrestacionDAO) {
		this.especialidadPrestacionDAO = especialidadPrestacionDAO;
	}
	
	@Autowired
	private BeneficiarioDAO beneficiarioDAO ;

	public BeneficiarioDAO getBeneficiarioDAO() {
		return beneficiarioDAO;
	}

	public void setBeneficiarioDAO(BeneficiarioDAO beneficiarioDAO) {
		this.beneficiarioDAO = beneficiarioDAO;
	}
	
	@Autowired
	private EspecialidadDAO especialidadDAO ;

	public EspecialidadDAO getEspecialidadDAO() {
		return especialidadDAO;
	}

	public void setEspecialidadDAO(EspecialidadDAO especialidadDAO) {
		this.especialidadDAO = especialidadDAO;
	}
	
	@Autowired
	private AutorizacionDocDAO autorizacionDocDAO ;

	public AutorizacionDocDAO getAutorizacionDocDAO() {
		return autorizacionDocDAO;
	}

	public void setAutorizacionDocDAO(AutorizacionDocDAO autorizacionDocDAO) {
		this.autorizacionDocDAO = autorizacionDocDAO;
	}

	@Override
	public List<EspecialidadDTO> getAllEspecialidades() throws CustomException {
		List<EspecialidadDTO> especialidadesDTO = new ArrayList<EspecialidadDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Especialidad> especialidades = especialidadDAO.getAll();
			if (especialidades != null) {
				for (Especialidad especialidad : especialidades) {
					especialidadesDTO.add(entityToDTO(especialidad));
				}
			}
			tx.commit();
			session.close();
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.LOAD_CONTACT_ERROR);
		}
		return especialidadesDTO;
	}
	
	@Override
	public List<PrestacionDTO> getPrestacionesByEspecialidadId(Long idEspecialidad) throws CustomException {
		List<PrestacionDTO> prestacionsDTO = new ArrayList<PrestacionDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Prestacion> prestacions = especialidadPrestacionDAO.getPrestacionesByEspecialidadId(idEspecialidad);
			if (prestacions != null) {
				for (Prestacion prestacion : prestacions) {
					prestacionsDTO.add(entityToDTO(prestacion));
				}
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
		return prestacionsDTO;
	}
	
	@Override
	public List<String> getDocumentosByEspecialidadYPrestacion(Long idEspecialidad, Long idPrestacion) throws CustomException {
		List<String> documentos = new ArrayList<String>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			documentos = autorizacionDocDAO.getDocumentosByIdEspecialidadYIdPrestacion(idEspecialidad, idPrestacion);
			
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
		return documentos;
	}
	
	public List<BeneficiarioDTO> getBeneficiarios(AutorizacionForm form) throws CustomException {
		Properties parameters = ReadPropertyFile.readFile("WSConfiguration.properties");
		String uri = parameters.getProperty("beneficiario.uri");
		BeneficiarioServiceREST beneficiarioRest = new BeneficiarioServiceREST();
		BeneficiariosResponse beneficiarios = beneficiarioRest.getForObject(uri + form.getIdAfiliado(), BeneficiariosResponse.class);
		return beneficiarios.getBeneficiarios();
	}
	
	public String procesarContacto(AutorizacionForm autorizacionForm, MultipartFile[] files) throws CustomException {
		String nroTramite = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			String correo = getMailByIds(Long.valueOf(autorizacionForm.getIdEspecialidad()), Long.valueOf(autorizacionForm.getIdPrestacion()));
			String especialidad = getEspecialidadById(Long.valueOf(autorizacionForm.getIdEspecialidad()));
			String prestacion = getPrestacionById(Long.valueOf(autorizacionForm.getIdPrestacion()));
			String message = getMessage(autorizacionForm, especialidad, prestacion);
			nroTramite = getSecuence();
			String subject = getSubject(autorizacionForm, nroTramite);
			
			MailingUtil mailing = new MailingUtil(); 
			mailing.sendMailTLS(correo, subject, message, files);
			
			Contacto contacto = crearContacto(autorizacionForm, autorizacionForm.getIdEspecialidad(), autorizacionForm.getIdPrestacion(), correo, nroTramite, "Autorización");
			saveContacto(contacto);
			
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
		return nroTramite;
	}
	
	
	
	private PrestacionDTO entityToDTO(Prestacion prestacion) {
		PrestacionDTO prestacionDTO = new PrestacionDTO();
		BeanUtils.copyProperties(prestacion, prestacionDTO);
		return prestacionDTO;	
	}
	private EspecialidadDTO entityToDTO(Especialidad especialidad) {
		EspecialidadDTO especialidadDTO = new EspecialidadDTO();
		BeanUtils.copyProperties(especialidad, especialidadDTO);
		return especialidadDTO;
	}

	/*
	 * private BeneficiarioDTO entityToDTO(Beneficiario beneficiario) {
	 * //BeanUtils.copyProperties(beneficiario, beneficiarioDTO); return new
	 * BeneficiarioDTO(beneficiario.getIdAfiliado(), beneficiario.getIdTitular(),
	 * beneficiario.getApellido(), beneficiario.getNombre()); }
	 */
	@Transactional
	public String getMailByIds(Long idEspecialidad, Long idPrestacion) throws CustomException{
		String correo = null;
		try {
			correo = especialidadPrestacionDAO.getMailByIds(idEspecialidad,idPrestacion);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return correo;
	}
	
	@Transactional 
	private String getEspecialidadById(Long idEspecialidad) throws CustomException {
		String motivo = null;
		try {
			motivo = especialidadPrestacionDAO.getEspecialidadById(idEspecialidad);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return motivo;
	}

	@Transactional 
	private String getPrestacionById(Long idPrestacion) throws CustomException {
		String categoria = null;
		try {
			categoria = especialidadPrestacionDAO.getPrestacionById(idPrestacion);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return categoria;
	}
	
	@Transactional
	private String getSecuence() throws CustomException {
		String secuence = "";
		try {
			Integer result = especialidadPrestacionDAO.getSecuence();
			secuence = Long.toString(result);
			String year = String.format("%04d", LocalDate.now().getYear());
			String month = String.format("%02d", LocalDate.now().getMonthValue());
			String day = String.format("%02d", LocalDate.now().getDayOfMonth());
			secuence = year + month + day + secuence;
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return secuence;
	}
	
	private String getMessage(AutorizacionForm autorizacionForm, String especialidad, String prestacion) {
		StringBuilder sb = new StringBuilder();

		sb.append(Constants.TIPO_TRAMITE).append(": ").append(Constants.AUTORIZACION).append("\n");
		sb.append(Constants.ESPECIALIDAD).append(": ").append(especialidad).append("\n");
		sb.append(Constants.PRESTACION).append(": ").append(prestacion).append("\n");
		sb.append(Constants.PRESTADOR).append(": ").append(autorizacionForm.getPrestador()).append("\n");
		sb.append(Constants.COMENTARIOS_ADICIONALES).append(": ").append(autorizacionForm.getComentario()).append("\n");
		sb.append(Constants.TITULAR).append(": ").append(autorizacionForm.getIdAfiliado()).append(" - ").append(autorizacionForm.getNombreAfiliado().toUpperCase()).append("\n");
		sb.append(Constants.BENEFICIARIO).append(": ").append(autorizacionForm.getIdBeneficiario()).append(" - ").append(autorizacionForm.getNombreBeneficiario().toUpperCase()).append("\n");

		return sb.toString();
	}
	
	private String getSubject(AutorizacionForm autorizacionForm, String nroTramite) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(Constants.AUTORIZACION).append(" - ");
		sb.append(nroTramite).append(" - ");
		//sb.append(autorizacionForm.getIdAfiliado()).append(" - ");
		//sb.append(autorizacionForm.getNombreAfiliado().toUpperCase());
		sb.append(autorizacionForm.getIdBeneficiario()).append(" - ");
		sb.append(autorizacionForm.getNombreBeneficiario().toUpperCase());

		return sb.toString();
	}
	
	private Contacto crearContacto(AutorizacionForm autorizacionForm, String idEspecialidad, String idPrestacion, String correo, String nroTramite, String tipo) {
		Contacto contacto = new Contacto();
		
		contacto.setIdtramite(nroTramite);
		contacto.setIdAfiliado(autorizacionForm.getIdAfiliado());
		contacto.setIdBenef(autorizacionForm.getIdBeneficiario());
		contacto.setNombreBenef(autorizacionForm.getNombreBeneficiario());
		contacto.setIdEspecialidad(Integer.valueOf(idEspecialidad));
		contacto.setIdPrestacion(Integer.valueOf(idPrestacion));
		contacto.setPrestador(autorizacionForm.getPrestador());
		contacto.setNombreCompleto(autorizacionForm.getNombreAfiliado().toUpperCase());
		contacto.setComentario(autorizacionForm.getComentario());
		contacto.setCorreo(correo);
		contacto.setTipo(tipo);
		
		return contacto;
	}
	
	@Transactional
	private void saveContacto(Contacto contacto) throws CustomException{
		try {
			especialidadPrestacionDAO.saveContacto(contacto);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
	}

}
