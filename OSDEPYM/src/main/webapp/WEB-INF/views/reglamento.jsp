<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				<div class="mb-4">
					<jsp:include page="reglamento${type}.jsp" />
				</div>
				<button type="button" class="btn btn-lg btn-primary pull-right" onclick="location.href='/OSDEPYM/'"><spring:message code="button.backtomenu" /></button>
			</div>			
		</section>
	</body>
	<jsp:include page="./footer.jsp" />
</html>