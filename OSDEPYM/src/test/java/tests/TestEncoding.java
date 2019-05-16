package tests;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

public class TestEncoding extends TestCase {
	
	private static final Logger logger = Logger.getLogger(TestEncoding.class);
	
	protected void setUp() {
		
	}
	
	public void testMain() {
		
		if(logger.isDebugEnabled()){
			logger.debug("testMain is executed!");
		}
		
		logger.error("Probando logger con mensajes de error", new Exception("Testing"));
		
		// Encode
		String originalInput = "https://www.osdepym.com.ar/vas/encode?param1=pepino&param2=lechuga";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		
		// Decode
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		
	    String[] params = decodedString.split("&");  
	    Map<String, String> map = new HashMap<String, String>();  
	    for (String param : params) {
	        String name = param.split("=")[0];
	        String value = param.split("=")[1];
	        map.put(name, value);  
	    } 
		
	}
	
    protected void tearDown() {
		
    }
	
}
