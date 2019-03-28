package tests;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hibernate.dao.TestPersonaDAO;
import hibernate.model.Persona;
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
		persona = methods.instancePersona();
		methods.insertPersona(personDAO, persona);
		methods.updatePersona(personDAO, persona);
		methods.selectPersona(personDAO);
		methods.getPersona(personDAO, "Mauricio");
		// methods.deletePersona(personDAO);
	}
		
    protected void tearDown() {
		context.close();
    }
    
}
