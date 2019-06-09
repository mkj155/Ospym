package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Pauta;

public interface PautaDAO extends Dao<Pauta>{

	List<Pauta> getByCUIT(String cuitNumber) throws CustomException;

}
