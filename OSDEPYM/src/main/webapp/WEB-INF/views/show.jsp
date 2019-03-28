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

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>User Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">Nombre</label>
		<div class="col-sm-10">${persona.nombre}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Apellido</label>
		<div class="col-sm-10">${persona.apellido}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Direccion</label>
		<div class="col-sm-10">${persona.direccion}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Ciudad</label>
		<div class="col-sm-10">${persona.ciudad}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Fecha de Nacimiento</label>
		<div class="col-sm-10">${persona.fechaNacimiento}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Nro Cliente</label>
		<div class="col-sm-10">${persona.nroCliente}</div>
	</div>

</div>

<jsp:include page="./footer.jsp" />

</body>
</html>