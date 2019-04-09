package com.osdepym.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.osdepym.dto.PersonaDTO;
import com.osdepym.dto.TestDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.exception.ErrorMessages;
import com.osdepym.hibernate.dao.HijosDAOImpl;
import com.osdepym.hibernate.dao.TestCursoDAOImpl;
import com.osdepym.hibernate.dao.TestPersonaDAOImpl;
import com.osdepym.hibernate.entity.Cursos;
import com.osdepym.hibernate.entity.Hijos;
import com.osdepym.hibernate.entity.Persona;


public interface TestService {
	public List<PersonaDTO> getAllPersonas() throws CustomException;
	public void deletePersona(Integer id) throws CustomException;
	public Set<Hijos> getAllHijos() throws CustomException;
	public Hijos getHijo(Integer id) throws CustomException;
	public void savePersona(Persona person) throws CustomException;
	public void savePersona(PersonaDTO personDTO) throws CustomException;
	public void updatePersona(Persona person) throws CustomException;
	public void updatePersona(PersonaDTO personDTO) throws CustomException;
	public List<TestDTO> getAllCursos() throws CustomException;
	public List<String> getAllCursosName() throws CustomException;
	public PersonaDTO getPersonaById(Integer id) throws CustomException;
	
}
