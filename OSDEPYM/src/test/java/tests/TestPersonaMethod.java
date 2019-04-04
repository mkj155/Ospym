package tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.dto.PersonaDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.dao.TestPersonaDAO;
import com.osdepym.hibernate.entity.Hijos;
import com.osdepym.hibernate.entity.Persona;
import com.osdepym.service.TestService;

public class TestPersonaMethod {
	
	protected TestService service = ConfigurationEnviroment.getInstance().getContext().getBean(TestService.class);
	
	public Persona instancePersona() {
		Persona persona = new Persona();
		persona.setNombre("Mauricio");
		persona.setApellido("Macri");
		persona.setDireccion("Perón 758");
		persona.setCiudad("Macrilandia");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1966);
		cal.set(Calendar.MONTH, Calendar.AUGUST);
		cal.set(Calendar.DAY_OF_MONTH, 6);
		Date dateBirthday = cal.getTime();
		
		persona.setFechaNacimiento(dateBirthday);
		persona.setNroCliente(randomNumber());
		persona.setVegetariano(true);
		instanceHijo(persona);
		return persona;
	}

	private void instanceHijo(Persona persona) {
		HashSet<Hijos> hijos = new HashSet<Hijos>();
		Hijos hijo1 = new Hijos();
		hijo1.setNombre("Kristina");
		hijo1.setApellido("kirchner");
		hijo1.setPersona(persona);
		hijos.add(hijo1);
		persona.setHijos(hijos);
	}
	
	private int randomNumber() {
		Random r = new Random();
		int low = 1;
		int high = 6000;
		return r.nextInt(high-low) + low;
	}
	
	public void insertPersona(TestPersonaDAO personDAO, Persona persona) throws CustomException {
		service.savePersona(persona);
	}
	
	public void updatePersona(TestPersonaDAO personDAO, Persona persona) throws CustomException {
		List<PersonaDTO> personasDTO = service.getAllPersonas();
		List<Persona> personas = new ArrayList<Persona>();
		
		for (PersonaDTO personaDTO : personasDTO) {
			Persona p = new Persona();
			BeanUtils.copyProperties(personaDTO,p);
			personas.add(p);
		}
		
		if (personas != null && personas.size() > 0) {
			persona = personas.get(0);
			persona.setApellido("Kirchner");
			service.updatePersona(persona);
		} else { 
			System.out.println("Error buscando la persona a actualizar");
		}
	}
	
	public void selectPersona(TestPersonaDAO personDAO) throws CustomException {
		service.getAllPersonas();
	}
	
	public void deletePersona(TestPersonaDAO personDAO) throws CustomException {
		List<PersonaDTO> personasDTO = service.getAllPersonas();
		List<Persona> personas = new ArrayList<Persona>();
		
		for (PersonaDTO personaDTO : personasDTO) {
			Persona p = new Persona();
			BeanUtils.copyProperties(personaDTO,p);
			personas.add(p);
		}
		
		if(personas != null && personas.size() > 0) {
			service.deletePersona(personas.get(0).getNroCliente());
		}
	}
	
	public void getPersona(TestPersonaDAO personDAO, int id) throws CustomException {
		service.getPersonaById(id);
	}
	
}
