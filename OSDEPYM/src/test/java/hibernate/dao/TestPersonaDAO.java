package hibernate.dao;

import java.util.List;

import hibernate.model.Persona;

public interface TestPersonaDAO {

	List<Persona> listarPersonas();
	Persona getPersona(String nombre);
	boolean savePersona(Persona persona);
	boolean deletePersona(Persona persona);
	boolean updatePersona(Persona persona);
}
