package tests;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.hibernate.dao.TestProfesoresDAO;
import com.osdepym.hibernate.entity.Profesores;

import junit.framework.TestCase;

public class TestHibernateMappingManyToMany extends TestCase {

	protected TestProfesoresDAO profesoresDAO;
	protected testManyToManyMethod testMethod;
	protected Profesores profesor;
	
	protected void setUp() {
		profesoresDAO = ConfigurationEnviroment.getInstance().getContext().getBean(TestProfesoresDAO.class);
		testMethod = new testManyToManyMethod();
	}
	
	public void testMain() {
		profesor = testMethod.testInitializeProfesor();
		testMethod.testListProfesores(profesoresDAO);
		testMethod.testAddProfesor(profesoresDAO, profesor);
	}
	
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }
    
}
