package tests.canalcontacto;

import java.util.Date;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.exception.CustomException;
import com.osdepym.hibernate.entity.Contacto;
import com.osdepym.service.ContactoService;

import junit.framework.TestCase;

public class TestContacto extends TestCase {
	
	ContactoService service;

	protected void setUp() {
		service = ConfigurationEnviroment.getInstance().getContext().getBean(ContactoService.class);
	}
	
	public void testMain() throws CustomException {
		Contacto contacto = new Contacto();
		
		contacto.setComentario("Comentario");
		contacto.setCorreo("correo@correo.com");
		contacto.setFechaCreacion(new Date());
		contacto.setIdAfiliado("15168153153");
		contacto.setIdCateg(1);
		contacto.setIdMotivo(2);
		contacto.setIdtramite("AAAAMMDDsecuen");
		contacto.setNombreCompleto("Damian Andres Chavez");
		
		service.saveContacto(contacto);
	}
	
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }

}
