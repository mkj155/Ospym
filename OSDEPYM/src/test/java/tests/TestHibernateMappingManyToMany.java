package tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.osdepym.hibernate.dao.TestProfesoresDAO;
import com.osdepym.hibernate.entity.Profesores;

import junit.framework.TestCase;

public class TestHibernateMappingManyToMany extends TestCase {

	
	protected ClassPathXmlApplicationContext context;
	protected TestProfesoresDAO profesoresDAO;
	protected testManyToManyMethod testMethod;
	protected Profesores profesor;
	
	protected void setUp() {
		context = new ClassPathXmlApplicationContext("spring.xml");
		profesoresDAO = context.getBean(TestProfesoresDAO.class);
		testMethod = new testManyToManyMethod();
	}
	
	public void testMain() {
		profesor = testMethod.testInitializeProfesor();
		testMethod.testListProfesores(profesoresDAO);
		testMethod.testAddProfesor(profesoresDAO, profesor);
	}
	
    protected void tearDown() {
		context.close();
    }
    
}
