package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Categoria;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.MotivoCategoria;

public interface MotivoCategoriaDAO extends Dao<MotivoCategoria> {
	
	public Integer getSecuence() throws CustomException;
	public void saveContacto(Contacto contacto) throws CustomException;
	public List<Categoria> getCategoriasByMotivoId(int idMotivo) throws CustomException;
	public String getMailByIds(String idMotivo, String idCategoria) throws CustomException;
	public String getMotivoById(String idMotivo) throws CustomException;
	public String getCategoriaById(String idCategoria) throws CustomException;
	
}
