package tests.canalcontacto;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.exception.CustomException;
import com.osdepym.service.ContactoService;

import junit.framework.TestCase;

public class TestSecuence extends TestCase {
	
	ContactoService service;

	protected void setUp() {
		service = ConfigurationEnviroment.getInstance().getContext().getBean(ContactoService.class);
	}
	
	public void testMain() throws CustomException {
		String secuence = service.getSecuence();
	}
	
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }

}
