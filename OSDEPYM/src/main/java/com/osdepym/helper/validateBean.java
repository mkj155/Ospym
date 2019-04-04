package com.osdepym.helper;

import org.springframework.validation.BindingResult;

import com.osdepym.dto.PersonaDTO;

public class validateBean {
	
	// esta clase no se usa, esta a modo de ejemplo de como sería retornar errores a la JSP sin las anotaciones :)
	public static boolean validateBeanPersonaDTO(PersonaDTO personaDTO, BindingResult result) {
		boolean retorno = false;
		
		if(personaDTO.getNombre() == null || personaDTO.getNombre().trim().equals("")) {
			retorno = true;
			result.rejectValue("nombre", "notEmpty");
		} else if (personaDTO.getNombre().trim().length() < 5 || personaDTO.getNombre().trim().length() > 20 ) {
			retorno = true;
			result.rejectValue("nombre", "size");
		}
		
		if(personaDTO.getApellido() == null || personaDTO.getApellido().trim().equals("")) {
			retorno = true;
			result.rejectValue("apellido", "notEmpty");
		} else if (personaDTO.getApellido().trim().length() < 5 || personaDTO.getApellido().trim().length() > 20 ) {
			retorno = true;
			result.rejectValue("apellido", "size");
		}

		return retorno;
	}

}
