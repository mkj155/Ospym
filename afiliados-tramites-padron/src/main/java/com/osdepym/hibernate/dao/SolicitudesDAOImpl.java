package com.osdepym.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.entity.Afiliado;

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
	public List<Afiliado> buscarAfiliados(AfiliadoDTO afiliadoDTO) throws CustomException {
		try {
			/*List<Afiliado> documentos = new ArrayList<String>();
			Session session = this.sessionFactory.getCurrentSession();
			String sqlString = "SELECT DC.ID_AUTORIZACION_DOC, DC.ID_ESPEC_PREST, DC.DOCUMENTACION FROM tramites_online.AUTORIZACIONES_DOC DC INNER JOIN tramites_online.ESPEC_PREST EP ON EP.ID_ESPEC_PREST = DC.ID_ESPEC_PREST WHERE EP.ID_ESPECIALIDAD = " + idEspecialidad + " AND EP.ID_PRESTACION = " + idPrestacion;
			String sqlString= "";
			List<AutorizacionDoc> autorizacionDocList = session.createNativeQuery(sqlString, AutorizacionDoc.class).getResultList();
			for(AutorizacionDoc element : autorizacionDocList) {
				documentos.add(element.getDocumentacion());
			}*/
			return new ArrayList<Afiliado>();
		} catch (Exception e) {
			throw new CustomException(e.getMessage(), ErrorMessages.DATABASE_GET_ERROR);
		}
	}
}
