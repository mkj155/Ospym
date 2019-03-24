package tests;

import java.util.HashSet;
import java.util.List;

import hibernate.dao.TestProfesoresDAO;
import hibernate.model.Cursos;
import hibernate.model.Profesores;

public class testManyToManyMethod {

	public Profesores testInitializeProfesor() {
		Profesores profesor = new Profesores();
		HashSet<Cursos> cursos = new HashSet<Cursos>();
		
		Cursos curso1 = new Cursos();
		curso1.setCurso("Programacion");
		Cursos curso2 = new Cursos();
		curso2.setCurso("Testing");
		
		cursos.add(curso1);
		cursos.add(curso2);
		
		profesor.setNombre("Damian");
		profesor.setApellido("Chavez");
		profesor.setDireccion("Rivadavia 222");
		profesor.setCiudad("San Isidro");
		profesor.setCursos(cursos);
		
		return profesor;
	}
	
	public void testListProfesores(TestProfesoresDAO profesoresDAO){
		List<Profesores> profesores = profesoresDAO.listProfesores();
		System.out.println("Resultado SELECT: " + (profesores != null ? "OK" : "KO"));
	}
	
	public void testAddProfesor(TestProfesoresDAO profesoresDAO, Profesores profesor) {
		boolean result;
		result = profesoresDAO.addProfesor(profesor);
		System.out.println("Resultado INSERT: " + (result ? "OK" : "KO"));
	}

}
