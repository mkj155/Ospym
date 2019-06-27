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
            <h1><spring:message code="title.success.tramite" /></h1>
            <br />
            <p class="big">
                <span class="text-green"><strong><spring:message code="message.procedurenumber.tramite" /> ${numeroTramite}</strong></span>
                <br/>
                <spring:message code="message.success.tramite" />
            </p>
            <button type="button" class="btn btn-lg btn-primary pull-right" onclick="location.href='/OSDEPYM/'">
                <spring:message code="button.backtomenu" />
            </button>
        </div>
    </section>
</body>
<jsp:include page="./footer.jsp" />
</html>