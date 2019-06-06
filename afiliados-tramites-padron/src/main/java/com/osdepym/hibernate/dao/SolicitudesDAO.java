package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.dto.AfiliadoDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Afiliado;

public interface SolicitudesDAO extends Dao<Afiliado>{
	public List<Afiliado> buscarAfiliados(AfiliadoDTO afiliadoDTO) throws CustomException;
}
