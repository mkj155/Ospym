package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.form.SolicitudesForm;
import com.osdepym.hibernate.entity.Afiliado;
import com.osdepym.hibernate.entity.Estado;
import com.osdepym.hibernate.entity.ObraSocial;

public interface SolicitudesDAO extends Dao<Afiliado>{
	public List<Afiliado> buscar(SolicitudesForm form) throws CustomException;
	public List<ObraSocial> getAllObrasSociales() throws CustomException;
	public List<Estado> getAllEstados() throws CustomException;
}
