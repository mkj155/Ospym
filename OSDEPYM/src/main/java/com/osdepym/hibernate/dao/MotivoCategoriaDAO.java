package com.osdepym.hibernate.dao;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.MotivoCategoria;

public interface MotivoCategoriaDAO extends Dao<MotivoCategoria> {
	
	public Integer getSecuence() throws CustomException;
	public void saveContacto(Contacto contacto) throws CustomException;
	
}
