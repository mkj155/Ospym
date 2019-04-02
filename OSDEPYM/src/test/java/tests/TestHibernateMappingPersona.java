package tests;
import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.dao.TestPersonaDAO;
import com.osdepym.hibernate.entity.Persona;

import junit.framework.TestCase;

public class TestHibernateMappingPersona extends TestCase {
	
	protected TestPersonaDAO personDAO;
	Persona persona;
	TestPersonaMethod methods;
	
	protected void setUp() {
		personDAO = ConfigurationEnviroment.getInstance().getContext().getBean(TestPersonaDAO.class);
		methods = new TestPersonaMethod();
	}
	
	public void testMain() throws CustomException {
		persona = methods.instancePersona();
		methods.insertPersona(personDAO, persona);
		methods.updatePersona(personDAO, persona);
		methods.selectPersona(personDAO);
		methods.getPersona(personDAO, 2);
		methods.deletePersona(personDAO);
	}
		
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }
    
}
