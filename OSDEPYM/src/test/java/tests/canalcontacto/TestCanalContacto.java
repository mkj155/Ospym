package tests.canalcontacto;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.osdepym.configuration.ConfiguracionSpring;
import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.dto.MotivoCategoriaDTO;
import com.osdepym.dto.MotivoDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.service.ContactoService;
import com.osdepym.service.ContactoServiceImpl;

import junit.framework.TestCase;

@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@ContextConfiguration(classes = {ConfiguracionSpring.class},loader = AnnotationConfigWebContextLoader.class)
public class TestCanalContacto {
	
	@Autowired
	@Qualifier("ContactService")
	ContactoService service;
	
//	TestCanalContactoMethod methods = new TestCanalContactoMethod();

		
	@Test
	public void testMain() {
		try {
			List<MotivoDTO> motivoCategoriaDTOs = service.getAllMotivos();
			if(motivoCategoriaDTOs != null && motivoCategoriaDTOs.size() > 0) {
				
			}
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
	
	@Test
    public void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }
	
}
