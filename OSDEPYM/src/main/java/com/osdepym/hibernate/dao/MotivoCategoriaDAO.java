package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Categoria;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.MotivoCategoria;

public interface MotivoCategoriaDAO extends Dao<MotivoCategoria> {
	
	public Integer getSecuence() throws CustomException;
	public void saveContacto(Contacto contacto) throws CustomException;
	public List<Categoria> getCategoriasByMotivoId(Long idMotivo) throws CustomException;
	public String getMailByIds(Long idMotivo, Long idCategoria) throws CustomException;
	public String getMotivoById(Long idMotivo) throws CustomException;
	public String getCategoriaById(Long idCategoria) throws CustomException;
	
}