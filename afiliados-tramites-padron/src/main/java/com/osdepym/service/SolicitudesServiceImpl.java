package com.osdepym.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.dto.AfiliadoImportDTO;
import com.osdepym.dto.AfiliadoTableDTO;
import com.osdepym.dto.EstadoDTO;
import com.osdepym.dto.ObraSocialDTO;
import com.osdepym.dto.PautaDTO;
import com.osdepym.dto.ResultadoImportarDTO;
import com.osdepym.dto.SPResponseDTO;
import com.osdepym.dto.TipoAfiliadoDTO;
import com.osdepym.dto.TipoCargaDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.form.ImportForm;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.hibernate.dao.PautaDAO;
import com.osdepym.hibernate.dao.SolicitudesDAO;
import com.osdepym.hibernate.dao.TipoAfiliadoDAO;
import com.osdepym.hibernate.dao.TipoCargaDAO;
import com.osdepym.hibernate.entity.Afiliado;
import com.osdepym.hibernate.entity.Estado;
import com.osdepym.hibernate.entity.ObraSocial;
import com.osdepym.hibernate.entity.Pauta;
import com.osdepym.hibernate.entity.PreSolicitud;
import com.osdepym.hibernate.entity.TipoAfiliado;
import com.osdepym.hibernate.entity.TipoCarga;
import com.osdepym.util.EntityToDTOUtil;
import com.osdepym.util.SessionUtil;

@Service("SolicitudesService")
public class SolicitudesServiceImpl implements SolicitudesService{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private SolicitudesDAO solicitudesDAO ;

	public SolicitudesDAO getSolicitudesDAO() {
		return solicitudesDAO;
	}

	public void setSolicitudesDAO(SolicitudesDAO solicitudesDAO) {
		this.solicitudesDAO = solicitudesDAO;
	}
	
	@Autowired
	private TipoCargaDAO tipoCargaDAO ;

	public TipoCargaDAO getTipoCargaDAO() {
		return tipoCargaDAO;
	}

	public void setTipoCargaDAO(TipoCargaDAO tipoCargaDAO) {
		this.tipoCargaDAO = tipoCargaDAO;
	}
	@Autowired
	private TipoAfiliadoDAO tipoAfiliadoDAO ;

	public TipoAfiliadoDAO getTipoAfiliadoDAO() {
		return tipoAfiliadoDAO;
	}

	public void setTipoAfiliadoDAO(TipoAfiliadoDAO tipoAfiliadoDAO) {
		this.tipoAfiliadoDAO = tipoAfiliadoDAO;
	}
	@Autowired
	private PautaDAO pautaDAO ;

	public PautaDAO getPautaDAO() {
		return pautaDAO;
	}

	public void setPautaDAO(PautaDAO pautaDAO) {
		this.pautaDAO = pautaDAO;
	}
	
	@Override
	public List<AfiliadoTableDTO> buscar(SolicitudesForm form) throws CustomException {
		List<AfiliadoTableDTO> afiliadosDTO = new ArrayList<AfiliadoTableDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Afiliado> afiliados = solicitudesDAO.buscar(form);
			if (afiliados != null) {
				for (Afiliado entity : afiliados) {
					afiliadosDTO.add(EntityToDTOUtil.entityToDTO2(entity));
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
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
		return afiliadosDTO;
	}
	
	public List<AfiliadoDTO> buscarExportar(SolicitudesForm form) throws CustomException {
		List<AfiliadoDTO> afiliadosDTO = new ArrayList<AfiliadoDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Afiliado> afiliados = solicitudesDAO.buscar(form);
			if (afiliados != null) {
				for (Afiliado entity : afiliados) {
					afiliadosDTO.add(EntityToDTOUtil.entityToDTO(entity));
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
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
		return afiliadosDTO;
	}
	
	@Transactional
	public List<ObraSocialDTO> getAllObrasSociales() throws CustomException {
		List<ObraSocialDTO> osDTOList = new ArrayList<ObraSocialDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<ObraSocial> osList = solicitudesDAO.getAllObrasSociales();
			if (osList != null) {
				for (ObraSocial entity : osList) {
					osDTOList.add(EntityToDTOUtil.entityToDTO(entity));
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
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
		return osDTOList;
	}
	
	@Transactional
	public List<EstadoDTO> getAllEstados() throws CustomException {
		List<EstadoDTO> estadoDTOList = new ArrayList<EstadoDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Estado> estadoList = solicitudesDAO.getAllEstados();
			if (estadoList != null) {
				for (Estado entity : estadoList) {
					estadoDTOList.add(EntityToDTOUtil.entityToDTO(entity));
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
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
		return estadoDTOList;
	}
	
	@Override
	public List<TipoCargaDTO> getAllTipoCarga() throws CustomException{
		List<TipoCargaDTO> tipoCargaDTOList = new ArrayList<TipoCargaDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<TipoCarga> tipoCargaList = tipoCargaDAO.getAll();
			if (tipoCargaList != null) {
				for (TipoCarga entity : tipoCargaList) {
					tipoCargaDTOList.add(EntityToDTOUtil.entityToDTO(entity));
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
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
		return tipoCargaDTOList;
	}

	@Override
	public List<TipoAfiliadoDTO> getAllTipoAfiliado() throws CustomException{
		List<TipoAfiliadoDTO> tipoAfiliadoDTOList = new ArrayList<TipoAfiliadoDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<TipoAfiliado> tipoAfiliadoList = tipoAfiliadoDAO.getAll();
			if (tipoAfiliadoList != null) {
				for (TipoAfiliado entity : tipoAfiliadoList) {
					tipoAfiliadoDTOList.add(EntityToDTOUtil.entityToDTO(entity));
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
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
		return tipoAfiliadoDTOList;
	}

	@Override
	public List<PautaDTO> getPautasByCuit(String cuit) throws CustomException{
		List<PautaDTO> pautaDTOList = new ArrayList<PautaDTO>();
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Pauta> pautaList = pautaDAO.getByCUIT(cuit);
			if (pautaList != null) {
				for (Pauta entity : pautaList) {
					pautaDTOList.add(EntityToDTOUtil.entityToDTO(entity));
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
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
		return pautaDTOList;
	}
	
	@Override
	public String[] confirmarAltaAfiliado(Integer id) throws CustomException {
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			String[] response = solicitudesDAO.confirmarAltaAfiliado(id);
			tx.commit();
			session.close();
			return response; 
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
	}
	
	public String[] anularAfiliado(AfiliadoTableDTO afiliado) throws CustomException {
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			String[] response = solicitudesDAO.anularAfiliado(afiliado);
			tx.commit();
			session.close();
			return response;
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
	}

	@Override
	public Integer obtenerSolicitudMultiple() throws CustomException {
		Session session = null;
		Transaction tx = null;
		Integer value;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			value = solicitudesDAO.obtenerSolicitudMultiple();
			tx.commit();
			session.close();
			return value; 
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
	}

	@Override
	public ResultadoImportarDTO procesarArchivoXLS(ImportForm form, String fileName, List<AfiliadoImportDTO> afiliados) throws CustomException{
		Session session = null;
		Transaction tx = null;
		Long archivoId;
		ResultadoImportarDTO result = new ResultadoImportarDTO();
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			SPResponseDTO spResponse = solicitudesDAO.archivoCargaMasivaObtenerIdentificar(form.getObraSocialId(), form.getTipoCargaId(), form.getTipoAfiliadoId(), form.getCuit(),
					form.getPautaId(), fileName);
			if(!spResponse.getMensaje().equals("") && !spResponse.getMensaje().equals("0")) {
				result.setError(spResponse.getMensaje());
				result.setAfiliados(new ArrayList<AfiliadoImportDTO>());
				return result;
			}
			archivoId = spResponse.getIdArchivo();
			for(int i = 0; i < afiliados.size(); i++) {
				AfiliadoImportDTO afiliado = afiliados.get(i);
				spResponse = solicitudesDAO.archivoCargaMasivaCargarRegistro(archivoId, afiliado);
			}
			List <PreSolicitud> preSolicitudesEntity = solicitudesDAO.getPreSolicitudes(archivoId);
			afiliados.clear();
			for(PreSolicitud entity : preSolicitudesEntity) {
				AfiliadoImportDTO afiliado = EntityToDTOUtil.entityToDTO(entity);
				afiliados.add(afiliado);
			}
			result.setAfiliados(afiliados);
			tx.commit();
			session.close();
			return result; 
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
	}
	
	@Override
	public SPResponseDTO confirmarCargaMasiva(Long idArchivo) throws CustomException{
		Session session = null;
		Transaction tx = null;
		Long archivoId;
		SPResponseDTO response = new SPResponseDTO();
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			response = solicitudesDAO.archivoCargaMasivaConfirmar(idArchivo);
			tx.commit();
			session.close();
			return response; 
		} catch (CustomException e) {
			SessionUtil.rollbackTransaction(session, tx);
			throw e;
		} catch (Exception e) {
			SessionUtil.rollbackTransaction(session, tx);
			e.printStackTrace();
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_SP_ERROR);
		}
	}
}