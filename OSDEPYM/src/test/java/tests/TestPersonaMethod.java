package tests;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import hibernate.dao.TestPersonaDAO;
import hibernate.model.Hijos;
import hibernate.model.Persona;

public class TestPersonaMethod {
	
	public Persona instancePersona() {
		Persona persona = new Persona();
		persona.setNombre("Mauricio");
		persona.setApellido("Macri");
		persona.setDireccion("Perón 758");
		persona.setCiudad("Gatolandia");
		persona.setFechaNacimiento(new Date("06/06/1966"));
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
		hijos.add(hijo1);
		hijo1.setPersona(persona);
		persona.setHijos(hijos);
	}
	
	private int randomNumber() {
		Random r = new Random();
		int low = 1;
		int high = 6000;
		return r.nextInt(high-low) + low;
	}
	
	public void insertPersona(TestPersonaDAO personDAO, Persona persona) {
		boolean result;
		result = personDAO.savePersona(persona);
		System.out.println("Resultado INSERT solo persona: " + (result ? "OK" : "KO"));
//		Persona getPersona = personDAO.getPersonaByNroCliente(persona.getNroCliente());
//		instanceHijo(getPersona);
//		updatePersona(personDAO,getPersona);
	}

	public void updatePersona(TestPersonaDAO personDAO, Persona persona) {
		boolean result = false;
		List<Persona> personas = personDAO.listarPersonas();
		if (personas != null && personas.size() > 0) {
			persona = personas.get(0);
			persona.setApellido("Kirchner");
			result = personDAO.updatePersona(persona);
		} else { 
			System.out.println("Error buscando la persona a actualizar");
		}
		System.out.println("Resultado UPDATE: " + (result ? "OK" : "KO"));
	}
	
	public void selectPersona(TestPersonaDAO personDAO) {
		List<Persona> personas = personDAO.listarPersonas();
		System.out.println("Resultado SELECT: " + (personas != null ? "OK" : "KO"));
	}
	
	public void deletePersona(TestPersonaDAO personDAO) {
		boolean result;
		List<Persona> personas = personDAO.listarPersonas();
		for (Persona per : personas) {
			result = personDAO.deletePersona(per);
			System.out.println("Resultado DELETE: " + (result ? "OK" : "KO"));
		}
	}
	
	public void getPersona(TestPersonaDAO personDAO, String nombre) {
		Persona persona = personDAO.getPersona(nombre);
		System.out.println("Resultado SELECT: " + (persona != null ? "OK" : "KO"));
	}
	
}
