package tests.canalcontacto;

import com.osdepym.configuration.ConfigurationEnviroment;
import com.osdepym.exception.CustomException;
import com.osdepym.service.ContactoService;
import com.osdepym.utils.MailingTLS;

import junit.framework.TestCase;

public class TestEnvioMail extends TestCase {
	
	ContactoService service;

	protected void setUp() {
	}
	
	public void testMain() throws CustomException {
		MailingTLS mailing = new MailingTLS();
		String mailTo = "agustinsanchezarmentano@gmail.com";
		String subject = "TEST MAIL OSDEPYM";
		String text = "Hola Agus, avisame si te llegó el mail";
		mailing.sendMailTLS(mailTo, subject, text);
	}
	
    protected void tearDown() {
    	ConfigurationEnviroment.getInstance().getContext().close();
    }

}
