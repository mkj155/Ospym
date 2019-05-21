<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<jsp:include page="./header.jsp" />
<body>
    <section id="main" class="bg-gray">
        <div class="container page page-cartilla">
        	<div class="container col-md-4">
	            <div class="row"><h2><span class="strong"><spring:message code="title.success.tramite" /></span></h2></div>
	            <div class="row"><label class="fs-16"><spring:message code="message.procedurenumber.tramite" /></label></div>
	            <div class="row"><label class="h4 text-gray">${numeroTramite}</label></div>
	            <div class="row"><spring:message code="message.success.tramite.autorizacion" /></div>
	            <div class="row pt-4"><button type="button" class="btn btn-lg btn-primary pull-right" onclick="location.href='/OSDEPYM/'">
	                <spring:message code="button.backtomenu" />
	            </button>
	            </div>
            </div>
        </div>
    </section>
</body>
<jsp:include page="./footer.jsp" />
</html>