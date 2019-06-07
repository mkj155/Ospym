package com.osdepym.util;

import java.util.Date;

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
}