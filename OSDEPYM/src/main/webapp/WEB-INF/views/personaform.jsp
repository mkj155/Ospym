<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="./header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${personaForm['new']}">
			<h1>Add Persona</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Persona</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/personaSave" var="userActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="personaForm" action="${userActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="nombre">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Nombre</label>
				<div class="col-sm-10">
					<form:input path="nombre" type="text" class="form-control " id="nombre" placeholder="Nombre" />
					<form:errors path="nombre" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="apellido">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Apellido</label>
				<div class="col-sm-10">
					<form:input path="apellido" class="form-control" id="apellido" placeholder="Apellido" />
					<form:errors path="apellido" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="direccion">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Direccion</label>
				<div class="col-sm-10">
					<form:input path="direccion" class="form-control" id="direccion" placeholder="Direccion" />
					<form:errors path="direccion" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="ciudad">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Ciudad</label>
				<div class="col-sm-10">
					<form:input path="ciudad" class="form-control" id="ciudad" placeholder="Ciudad" />
					<form:errors path="ciudad" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="nroCliente">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Nro de Cliente</label>
				<div class="col-sm-10">
					<form:input path="nroCliente" class="form-control" id="ciudad" placeholder="Nro de Cliente" />
					<form:errors path="nroCliente" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="fechaNacimiento">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Fecha de Nacimiento (YYYY-MM-DD)</label>
				<div class="col-sm-10">
					<form:textarea path="fechaNacimiento" rows="5" class="form-control" id="fechaNacimiento" placeholder="Fecha de Nacimiento" />
					<form:errors path="fechaNacimiento" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="vegetariano">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Vegetariano</label>
				<div class="col-sm-10">
					<div class="checkbox">
						<label> <form:checkbox path="vegetariano" id="vegetariano" />
						</label>
						<form:errors path="vegetariano" class="control-label" />
					</div>
				</div>
			</div>
		</spring:bind>

<%-- 		<spring:bind path="framework"> --%>
<%-- 			<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
<!-- 				<label class="col-sm-2 control-label">Web Frameworks</label> -->
<!-- 				<div class="col-sm-10"> -->
<%-- 					<form:checkboxes path="framework" items="${frameworkList}" element="label class='checkbox-inline'" /> --%>
<!-- 					<br /> -->
<%-- 					<form:errors path="framework" class="control-label" /> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<%-- 		</spring:bind> --%>

		<spring:bind path="sexo">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Sex</label>
				<div class="col-sm-10">
					<label class="radio-inline"> <form:radiobutton path="sexo" value="M" /> Male
					</label> <label class="radio-inline"> <form:radiobutton path="sexo" value="F" /> Female
					</label> <br />
					<form:errors path="sexo" class="control-label" />
				</div>
			</div>
		</spring:bind>

<%-- 		<spring:bind path="number"> --%>
<%-- 			<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
<!-- 				<label class="col-sm-2 control-label">Number</label> -->
<!-- 				<div class="col-sm-10"> -->
<%-- 					<form:radiobuttons path="number" items="${numberList}" element="label class='radio-inline'" /> --%>
<!-- 					<br /> -->
<%-- 					<form:errors path="number" class="control-label" /> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<%-- 		</spring:bind> --%>

		<!-- Custom Script, Spring map to model via 'name' attribute
		<div class="form-group">
			<label class="col-sm-2 control-label">Number</label>
			<div class="col-sm-10">

				<c:forEach items="${numberList}" var="obj">
					<div class="radio">
						<label> 
							<input type="radio" name="number" value="${obj}">${obj}
						</label>
					</div>
				</c:forEach>
			</div>
		</div>
 		-->

		<spring:bind path="curso">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Curso Favorito</label>
				<div class="col-sm-5">
					<form:select path="curso" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${cursoList}" />
					</form:select>
					<form:errors path="curso" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<spring:bind path="hijos">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Hijos</label>
				<div class="col-sm-5">
					<form:select path="hijos" items="${childrensList}" multiple="true" size="5" class="form-control" />
					<form:errors path="hijos" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${personaForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="./footer.jsp" />

</body>
</html>