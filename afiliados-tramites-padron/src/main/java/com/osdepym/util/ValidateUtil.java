package com.osdepym.util;

import java.util.Date;
import java.util.List;

import com.osdepym.dto.AfiliadoTableDTO;

public abstract class ValidateUtil {
	public static Boolean isEmpty(String param) {
		return param == null || (param != null && "".equals(param.trim()));
	}
	
	public static Boolean isNotEmpty(String param) {
		return param != null && !"".equals(param.trim());
	}
	
	public static Boolean isEmpty(Integer param) {
		return param == null;
	}
	
	public static Boolean isNotEmpty(Integer param) {
		return param != null;
	}
	
	public static Boolean isEmpty(Long param) {
		return param == null;
	}
	
	public static Boolean isNotEmpty(Long param) {
		return param != null;
	}
	
	public static Boolean isEmpty(Date param) {
		return param == null;
	}
	
	public static Boolean isNotEmpty(Date param) {
		return param != null;
	}
	
	public static boolean validarPendientes(List<AfiliadoTableDTO> afiliados) {
		for(AfiliadoTableDTO a : afiliados) {
			if(1 == a.getEstadoRegistroID())
				return false;
		}
		return true;
	}
	
}