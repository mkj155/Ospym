package com.osdepym.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.osdepym.dto.PersonaDTO;
import com.osdepym.dto.TestDTO;
import com.osdepym.hibernate.dao.HijosDAOImpl;
import com.osdepym.hibernate.dao.TestCursoDAOImpl;
import com.osdepym.hibernate.dao.TestPersonaDAOImpl;
import com.osdepym.hibernate.entity.Cursos;
import com.osdepym.hibernate.entity.Hijos;
import com.osdepym.hibernate.entity.Persona;

@EnableTransactionManagement
@Service
public class TestService{
	
	private TestCursoDAOImpl cursosDAO;
	private TestPersonaDAOImpl personaDAO;
	private HijosDAOImpl hijosDAO;
	
	@Transactional
	public List<PersonaDTO> getAllPersonas() {
		List<Persona> personas = personaDAO.getAll();
		List<PersonaDTO> personasDTO = new ArrayList<PersonaDTO>();
		
		if(personas != null){
			for(Persona persona : personas) {
				personasDTO.add(mergeEntityWithDTO(persona));
			}
		}
		
		return personasDTO;
	}
	
	@Transactional
	public void deletePersona(Integer id) {
		personaDAO.delete(personaDAO.get(id));
	}
	
	@Transactional
	public Set<Hijos> getAllHijos() {
		List<Hijos> hijosL = hijosDAO.getAll();
		Set<Hijos> hijosS = new HashSet<Hijos>();
		for (Hijos hijo : hijosL) {
			hijosS.add(hijo);
		}
		
		return hijosS; //getNombresCompletosHijos(hijosS);

	}
	
	@Transactional
	public void savePersona(Persona person) {
		personaDAO.save(person);
	}
	
	@Transactional
	public void savePersona(PersonaDTO personDTO) {
		personaDAO.save(mergeDTOWithEntity(personDTO));
	}
	
	@Transactional
	public void updatePersona(Persona person) {
		personaDAO.update(person);
	}
	
	@Transactional
	public void updatePersona(PersonaDTO personDTO) {
		personaDAO.update(mergeDTOWithEntity(personDTO));
	}
	
	@Transactional
	public List<TestDTO> getAllCursos() {
		List<Cursos> cursos = cursosDAO.getAll();
		List<TestDTO> cursosDTO = new ArrayList<TestDTO>();
		
		if(cursos != null){
			for(Cursos curso : cursos) {
				cursosDTO.add(mergeEntityWithDTO(curso));
			}
		}
		
		return cursosDTO;
	}
	
	@Transactional
	public List<String> getAllCursosName() {
		List<TestDTO> cursosDTO = getAllCursos();
		List<String> cursosNames = new ArrayList<String>();
		
		if(cursosDTO != null){
			for(TestDTO curso : cursosDTO) {
				cursosNames.add(curso.getNombre());
			}
		}
		
		return cursosNames;
	}
	
	
	@Transactional
	public PersonaDTO getPersonaById(Integer id) {
		Persona persona = personaDAO.get(id);
		
		if(persona != null){
			return mergeEntityWithDTO(persona);
		}
		
		return null;
	}
	
	@Transactional
	public List<TestDTO> getCursosByLetter(String letter) {
		List<Cursos> cursos = cursosDAO.getAll();
		List<TestDTO> cursosDTO = new ArrayList<TestDTO>();
		
		if(cursos != null){
			for(Cursos curso : cursos) {
				if(curso.getCurso().startsWith(letter) || letter == null) {
					TestDTO dto = new TestDTO();
					dto.setId(curso.getIdCurso());
					dto.setNombre(curso.getCurso());
					cursosDTO.add(dto);
				}
			}
		}
		
		return cursosDTO;
		
	}

	public TestPersonaDAOImpl getPersonaDAO() {
		return personaDAO;
	}

	public void setPersonaDAO(TestPersonaDAOImpl personaDAO) {
		this.personaDAO = personaDAO;
	}

	public TestCursoDAOImpl getCursosDAO() {
		return cursosDAO;
	}

	public HijosDAOImpl getHijosDAO() {
		return hijosDAO;
	}

	public void setHijosDAO(HijosDAOImpl hijosDAO) {
		this.hijosDAO = hijosDAO;
	}

	public void setCursosDAO(TestCursoDAOImpl cursosDAO) {
		this.cursosDAO = cursosDAO;
	}
	
	public List<String> getNombresCompletosHijos(Set<Hijos> hijos ){
		List<String> names = new ArrayList<String>();
		
		for(Hijos hijo : hijos) {
			names.add(hijo.getNombre() + ' ' + hijo.getApellido());
		}
		
		return names;
	}
	
	private PersonaDTO mergeEntityWithDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		BeanUtils.copyProperties(persona, personaDTO);		
		return personaDTO;
	}
	
	public Set<Hijos> getHijos(Set<Hijos> hijosNames){
		Set<Hijos> hijos = new HashSet<Hijos>();
		for(Hijos hijo : hijosNames) {
			hijos.add(hijosDAO.getHijoByNombreAndApellido(hijo.getNombre(), hijo.getApellido()));
		}
		return hijos;
	}
	
	private Persona mergeDTOWithEntity(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		BeanUtils.copyProperties(personaDTO, persona);		
		return persona;
	}
	
	
	
	private TestDTO mergeEntityWithDTO(Cursos curso) {
		TestDTO testDTO = new TestDTO();
		
		testDTO.setId(curso.getIdCurso());
		testDTO.setNombre(curso.getCurso());
		
		return testDTO;
	}
}
