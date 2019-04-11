package com.osdepym.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;

import com.osdepym.dto.MotivoCategoriaDTO;
import com.osdepym.dto.MotivoDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.dao.MotivoCategoriaDAO;
import com.osdepym.hibernate.dao.MotivoDAO;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.hibernate.entity.Motivo;
import com.osdepym.hibernate.entity.MotivoCategoria;

public interface ContactoService {
	public List<MotivoDTO> getAllMotivos() throws CustomException;
	public String getSecuence() throws CustomException;
	public void saveContacto(Contacto contacto) throws CustomException;
}
