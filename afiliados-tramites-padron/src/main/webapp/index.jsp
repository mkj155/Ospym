<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<style>
	
</style>
<jsp:include page="./WEB-INF/views/header.jsp" />
<body>
	<section id="main" class="bg-gray">
		<div class="container">
			<div class="buttons">
				<div id="content-buttons">
					<a href="./solicitudes" class="btn btn-primary button">
						<i class="fas fa-id-card block"></i>
						<span>Estado de Solicitudes</span>
					</a>
				</div>
			</div>
		</div>
	</section>
</body>
<jsp:include page="./WEB-INF/views/footer.jsp" />
</html>