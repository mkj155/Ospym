package tests.canalcontacto;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.osdepym.configuration.ConfiguracionSpring;
import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.dto.MotivoCategoriaDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.service.ContactoService;
import com.osdepym.service.ContactoServiceImpl;

import junit.framework.TestCase;

@RunWith( SpringJUnit4ClassRunner.class )
//@SpringApplicationConfiguration(classes = ConfiguracionSpring.class)
//@ActiveProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)
@ContextConfiguration(classes=ConfiguracionSpring.class, loader=AnnotationConfigContextLoader.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@TestExecutionListeners({DirtiesContextTestExecutionListener.class})
public class TestCanalContacto extends AbstractJUnit4SpringContextTests {
	
//    @Configuration
//    static class ContextConfiguration {
//        // this bean will be injected into the OrderServiceTest class
//        @Bean
//        public ContactoService ContactoService() {
//        	ContactoService contactoService = new ContactoServiceImpl();
//            return contactoService;
//        }
//    }
    
	
	TestCanalContactoMethod methods;
	@Autowired
	ContactoService service;
	
	@Test
	public void setUp() {
		service = ConfigurationEnviroment.getInstance().getContext().getBean(ContactoServiceImpl.class);
		methods = new TestCanalContactoMethod();
	}
	
	@Test
	public void testMain() {
		try {
			List<MotivoCategoriaDTO> motivoCategoriaDTOs = service.getAllMotivos();
			if(motivoCategoriaDTOs != null && motivoCategoriaDTOs.size() > 0) {
				
			}
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
	
    public void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }
	
}
