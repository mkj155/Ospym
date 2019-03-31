package tests;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.hibernate.dao.TestCursoDAO;
import com.osdepym.hibernate.dao.TestProfesoresDAO;
import com.osdepym.hibernate.entity.Profesores;

import junit.framework.TestCase;

public class TestHibernateMappingManyToMany extends TestCase {

	protected TestProfesoresDAO profesoresDAO;
	protected TestCursoDAO testCursoDAO;
	protected testManyToManyMethod testMethod;
	protected Profesores profesor;
	
	protected void setUp() {
		profesoresDAO = ConfigurationEnviroment.getInstance().getContext().getBean(TestProfesoresDAO.class);
		testCursoDAO = ConfigurationEnviroment.getInstance().getContext().getBean(TestCursoDAO.class);
		testMethod = new testManyToManyMethod();
	}
	
	public void testMain() {
		profesor = testMethod.testInitializeProfesor();
		testCursoDAO.get(5);
		testMethod.testListProfesores(profesoresDAO);
		testMethod.testAddProfesor(profesoresDAO, profesor);
	}
	
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }
    
}
