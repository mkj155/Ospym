package tests.canalcontacto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.osdepym.configuration.ConfiguracionSpring;
import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.exception.CustomException;
import com.osdepym.service.ContactoService;
import com.osdepym.service.ContactoServiceImpl;

import junit.framework.TestCase;

@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@ContextConfiguration(classes = {ConfiguracionSpring.class},loader = AnnotationConfigWebContextLoader.class)
public class TestSecuence{
	
	@Autowired
	@Qualifier("ContactService")
	ContactoService service;

	@Test
	public void testMain() throws CustomException {
//		String secuence = service.getSecuence();
	}
	
	@Test
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }

}
