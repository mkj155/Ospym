package com.osdepym.hibernate.dao;

import java.util.List;

import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Beneficiario;

public interface BeneficiarioDAO extends Dao<Beneficiario>{
	public List<Beneficiario> getBeneficiariosByIdAfiliado(int idAfiliado) throws CustomException;
}