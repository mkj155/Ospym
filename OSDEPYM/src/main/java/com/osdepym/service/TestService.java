package com.osdepym.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

@EnableTransactionManagement
@Service
public class TestService {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private TestCursoDAOImpl cursosDAO;
	private TestPersonaDAOImpl personaDAO;
	private HijosDAOImpl hijosDAO;

	/**
	 * @return all personas
	 */
	@Transactional
	public List<PersonaDTO> getAllPersonas() throws CustomException {
		Session session = null;
		Transaction tx = null;
		List<PersonaDTO> personasDTO = new ArrayList<PersonaDTO>();
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Persona> personas = personaDAO.getAll();
			if (personas != null) {
				for (Persona persona : personas) {
					personasDTO.add(mergeEntityWithDTO(persona));
				}
			}
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return personasDTO;
	}

	@Transactional
	public void deletePersona(Integer id) throws CustomException {
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			personaDAO.delete(personaDAO.get(id));
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			tx.rollback();
			session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
	}

	@Transactional
	public List<String> getAllHijos() throws CustomException {
		Session session = null;
		Transaction tx = null;
		Set<Hijos> hijosS = new HashSet<Hijos>();
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<Hijos> hijosL = hijosDAO.getAll();

			for (Hijos hijo : hijosL) {
				hijosS.add(hijo);
			}
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return getNombresCompletosHijos(hijosS);

	}

	@Transactional
	public void savePersona(Persona person) throws CustomException {
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			personaDAO.save(person);
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
	}

	@Transactional
	public void savePersona(PersonaDTO personDTO) throws CustomException {
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			personaDAO.save(mergeDTOWithEntity(personDTO));
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}

	}

	@Transactional
	public void updatePersona(Persona person) throws CustomException {
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			personaDAO.update(person);
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}

	}

	@Transactional
	public void updatePersona(PersonaDTO personDTO) throws CustomException {
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			personaDAO.update(mergeDTOWithEntity(personDTO));
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}

	}

	@Transactional
	private List<TestDTO> getAllCursos() throws CustomException {
		List<TestDTO> cursosDTO = new ArrayList<TestDTO>();

		List<Cursos> cursos = cursosDAO.getAll();
		if (cursos != null) {
			for (Cursos curso : cursos) {
				cursosDTO.add(mergeEntityWithDTO(curso));
			}
		}

		return cursosDTO;
	}

	@Transactional
	public List<String> getAllCursosName() throws CustomException {
		Session session = null;
		Transaction tx = null;
		List<String> cursosNames = new ArrayList<String>();
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			List<TestDTO> cursosDTO = getAllCursos();

			if (cursosDTO != null) {
				for (TestDTO curso : cursosDTO) {
					cursosNames.add(curso.getNombre());
				}
			}
			tx.commit();
			session.close();
		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return cursosNames;
	}

	@Transactional
	public PersonaDTO getPersonaById(Integer id) throws CustomException {
		Session session = null;
		Transaction tx = null;
		List<TestDTO> cursosDTO = new ArrayList<TestDTO>();
		try {
			session = this.sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Persona persona = personaDAO.get(id);
			tx.commit();
			session.close();
			if (persona != null) {
				return mergeEntityWithDTO(persona);
			}

		} catch (CustomException e) {
			tx.rollback();
			session.close();
			throw e;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw new CustomException(e.getMessage(), ErrorMessages.UNKNOWN_ERROR);
		}
		return null;
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

	public List<String> getNombresCompletosHijos(Set<Hijos> hijos) {
		List<String> names = new ArrayList<String>();

		for (Hijos hijo : hijos) {
			names.add(hijo.getNombre() + ' ' + hijo.getApellido());
		}

		return names;
	}

	private PersonaDTO mergeEntityWithDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		personaDTO.setId(persona.getId());
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setApellido(persona.getApellido());
		personaDTO.setCiudad(persona.getCiudad());
		personaDTO.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").format(persona.getFechaNacimiento()));
		personaDTO.setNroCliente(persona.getNroCliente());
		personaDTO.setDireccion(persona.getDireccion());
		personaDTO.setVegetariano(persona.isVegetariano());
		personaDTO.setSexo(persona.getSexo());
		personaDTO.setCurso(persona.getCurso());
		personaDTO.setHijos(getNombresCompletosHijos(persona.getHijos()));
		return personaDTO;
	}

	private List<Hijos> getHijos(List<String> hijosNames) throws CustomException {

		List<Hijos> hijos = new ArrayList<Hijos>();

		for (String nombreApellido : hijosNames) {
			String[] nombreAndApellido = nombreApellido.split(" ");
			hijos.add(hijosDAO.getHijoByNombreAndApellido(nombreAndApellido[0], nombreAndApellido[1]));
		}

		return hijos;
	}

	private void setPersonToChildrens(List<Hijos> hijos, Persona persona) {
		for (Hijos hijo : hijos) {
			hijo.setPersona(persona);
		}
	}

	private Persona mergeDTOWithEntity(PersonaDTO personaDTO) throws CustomException {
		Persona persona = new Persona();

		persona.setId(personaDTO.getId());
		persona.setNombre(personaDTO.getNombre());
		persona.setApellido(personaDTO.getApellido());
		persona.setCiudad(personaDTO.getCiudad());
		try {
			persona.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(personaDTO.getFechaNacimiento()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		persona.setNroCliente(personaDTO.getNroCliente());
		persona.setDireccion(personaDTO.getDireccion());
		persona.setVegetariano(personaDTO.getVegetariano());
		persona.setSexo(personaDTO.getSexo());
		persona.setCurso(personaDTO.getCurso());
		List<Hijos> hijos = getHijos(personaDTO.getHijos());
		setPersonToChildrens(hijos, persona);

		Set<Hijos> hijosS = new HashSet<Hijos>();
		for (Hijos hijo : hijos) {
			hijosS.add(hijo);
		}

		persona.setHijos(hijosS);

		return persona;
	}

	private TestDTO mergeEntityWithDTO(Cursos curso) {
		TestDTO testDTO = new TestDTO();

		testDTO.setId(curso.getIdCurso());
		testDTO.setNombre(curso.getCurso());

		return testDTO;
	}
}
