<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<jsp:include page="./header.jsp" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h2>Tramite ingresado con exito!</h2><br />
	<b>Su numero de tramite es ${numeroTramite}</b><br />
	A partir de ahora su solucitud será procesada y a la brevedad nos comunicaremos con usted para informarle el resultado de la misma. 
	Por favor recuerde mantener sus datos de contacto actualizados.
	Muchas gracias!
	<spring:url value="/OSDEPYM/" var="menuUrl" />
    <button type="button" class="btn-lg btn-primary pull-right" onclick="location.href=${menuUrl}">Volver al menu</button>


</html>