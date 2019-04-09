package tests.canalcontacto;

import org.springframework.beans.factory.annotation.Autowired;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.exception.CustomException;
import com.osdepym.service.ContactoService;
import com.osdepym.service.ContactoServiceImpl;

import junit.framework.TestCase;

public class TestSecuence extends TestCase {
	
	@Autowired
	ContactoService service;

	protected void setUp() {
		service = ConfigurationEnviroment.getInstance().getContext().getBean(ContactoServiceImpl.class);
	}
	
	public void testMain() throws CustomException {
		String secuence = service.getSecuence();
	}
	
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }

}
