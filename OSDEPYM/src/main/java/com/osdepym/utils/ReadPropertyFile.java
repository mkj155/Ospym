package com.osdepym.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadPropertyFile {
	
	private static final Logger logger = Logger.getLogger(ReadPropertyFile.class);
	private static Properties prop = new Properties();
	private static InputStream input = null;

	public static Properties readFile(String fileName) {
		
    	try {
    		input = ReadPropertyFile.class.getClassLoader().getResourceAsStream(fileName);
    		if(input==null){
    			logger.error("No se pudo abrir el archivo: " + fileName);
    		    return null;
    		}
    		prop.load(input);
    		logger.info("archivo " + fileName + " cargado correctamente");
    	} catch (IOException ex) {
    		logger.error("error abriendo el archivo: " + fileName, ex);
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
        			input.close();
        		} catch (IOException e) {
        			logger.error("cerrando el archivo: " + fileName, e);
        			e.printStackTrace();
        		}
        	}
        }
		return prop;
	}
	
}
