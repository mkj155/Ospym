package hibernate.dao;

import java.util.List;

import hibernate.model.Profesores;

public interface TestProfesoresDAO {
	
	List<Profesores> listProfesores();
	boolean addProfesor(Profesores profesor);
	
}
