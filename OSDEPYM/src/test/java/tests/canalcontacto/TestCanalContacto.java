package tests.canalcontacto;

import java.util.List;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.dto.MotivoCategoriaDTO;
import com.osdepym.exception.CustomException;
import com.osdepym.service.ServiceCanalContacto;

import junit.framework.TestCase;

public class TestCanalContacto extends TestCase {
	
	TestCanalContactoMethod methods;
	ServiceCanalContacto service;

	protected void setUp() {
		service = ConfigurationEnviroment.getInstance().getContext().getBean(ServiceCanalContacto.class);
		methods = new TestCanalContactoMethod();
	}
	
	public void testMain() {
		try {
			List<MotivoCategoriaDTO> motivoCategoriaDTOs = service.getAllMotivos();
			if(motivoCategoriaDTOs != null && motivoCategoriaDTOs.size() > 0) {
				
			}
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
	
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }
	
}
