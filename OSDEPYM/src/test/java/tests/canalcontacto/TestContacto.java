package tests.canalcontacto;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.exception.CustomException;
import com.osdepym.form.ContactoForm;
import com.osdepym.service.ContactoService;

import junit.framework.TestCase;

public class TestContacto extends TestCase {
	
	ContactoService service;

	protected void setUp() {
		service = ConfigurationEnviroment.getInstance().getContext().getBean(ContactoService.class);
	}
	
	public void testMain() throws CustomException {
		ContactoForm contactoForm = new ContactoForm();
		
		contactoForm.setIdMotivo("1");
		contactoForm.setIdCategoria("1");
		contactoForm.setIdAfiliado("154863155");
		contactoForm.setNombreAfiliado("Damian Andres Chavez");
		contactoForm.setComentario("Comentario");
		
		service.procesarContacto(contactoForm);
	}
	
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }

}
