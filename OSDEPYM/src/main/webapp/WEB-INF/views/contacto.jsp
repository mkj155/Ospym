<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<jsp:include page="./header.jsp" />
<script src="/OSDEPYM/resources/core/js/contacto.js"></script>

<head>
<link href="/OSDEPYM/resources/core/css/_buttons.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>canal de contacto</h1>
	<spring:url value="/contact/send" var="enviarUrl" />
	<form:form class="form-horizontal" method="post" modelAttribute="contactoForm" action="${enviarUrl}">

		<!-- AFILIADO -->
		<div class="form-group">
			<label class="col-sm-2 control-label">Afiliado</label>
			<div class="col-sm-5">
				<form:select path="idAfiliado" class="form-control" id="afiliado">
					<form:option selected="true" value="${contactoForm.idAfiliado}" label="${contactoForm.nombreAfiliado}" />
				</form:select>
			</div>
			<div class="col-sm-5"></div>
		</div>
		<!-- MOTIVOS -->
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Motivo</label>
			<div class="col-sm-5">
				<form:select path="idMotivo" class="form-control" id="motivo" onchange="getCategorias()">
					<form:option value="" label="--- Seleccionar ---" />
					<form:options items="${motivos}" itemValue="idMotivo"
						itemLabel="etiqueta" />
				</form:select>
			</div>
			<div class="col-sm-5"></div>
		</div>

		<!-- CATEGORIAS -->
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Categoria</label>
			<div class="col-sm-5">
				<form:select path="idCategoria" class="form-control" id="categoria">
					<form:option value="" label="--- Seleccionar motivo ---" />
				</form:select>
			</div>
			<div class="col-sm-5"></div>
		</div>
		
		<!-- COMENTARIO -->
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Comentario</label>
			<div class="col-sm-5">
				<form:textarea path="comentario" rows="5" cols="90" maxlength="300" />
			</div>
			<div class="col-sm-5"></div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-outline-primary btn-block btn-sm">ENVIAR</button>
			</div>
		</div>
	</form:form>
</body>


</html>