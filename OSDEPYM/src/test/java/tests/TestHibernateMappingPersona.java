package tests;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.osdepym.hibernate.dao.interfaces.TestPersonaDAO;
import com.osdepym.hibernate.model.Persona;

import junit.framework.TestCase;

public class TestHibernateMappingPersona extends TestCase {
	
	protected ClassPathXmlApplicationContext context;
	protected TestPersonaDAO personDAO;
	Persona persona;
	TestPersonaMethod methods;
	
	protected void setUp() {
		context = new ClassPathXmlApplicationContext("spring.xml");
		personDAO = context.getBean(TestPersonaDAO.class);
		methods = new TestPersonaMethod();
	}
	
	public void testMain() {
		persona = methods.testingInstancePersona();
		methods.testingInsertPersona(personDAO, persona);
		methods.testingUpdatePersona(personDAO, persona);
		methods.testingSelectPersona(personDAO);
		methods.testingGetPersona(personDAO, "Mauricio");
		methods.testingDeletePersona(personDAO);
	}
		
    protected void tearDown() {
		context.close();
    }
    
}
