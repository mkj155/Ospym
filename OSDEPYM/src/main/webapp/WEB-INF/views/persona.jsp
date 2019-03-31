<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="./header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>Personas</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Direccion</th>
					<th>Ciudad</th>
					<th>FechaNacimiento</th>
					<th>Numero Cliente</th>
				</tr>
			</thead>

			<c:forEach var="persona" items="${personas}">
				<tr>
					<td>
						${persona.nombre}
					</td>
					<td>${persona.apellido}</td>
					<td>${persona.direccion}</td>
					<td>${persona.ciudad}</td>
					<td>${persona.fechaNacimiento}</td>
					<td>${persona.nroCliente}</td>
					<td>
					  <spring:url value="/persona/${persona.nroCliente}" var="userUrl" />
					  <spring:url value="/persona/${persona.nroCliente}/delete" var="deleteUrl" /> 
					  <spring:url value="/persona/${persona.nroCliente}/update" var="updateUrl" />
						
						<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button></td>
					</td>

				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="./footer.jsp" />

</body>
</html>