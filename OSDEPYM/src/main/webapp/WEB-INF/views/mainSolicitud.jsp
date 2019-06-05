<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<jsp:include page="./header.jsp" />
<body>
	<section id="main" class="bg-gray">
		<div class="container page page-cartilla">
			
			<spring:url value="/impExp/showGrid" var="enviarUrl" />
			<form:form class="form-cartilla custom-form" method="post" modelAttribute="impExpForm" action="${enviarUrl}">
				<div class="form-group">
					<div class="text-center">
						<button type="submit" class="btn btn-outline-primary btn-block btn-sm button-contact"><spring:message code="button.status" /></button>
					</div>
				</div>
			</form:form>
			
		</div>
	</section>
	<jsp:include page="./footer.jsp" />
</body>
</html>