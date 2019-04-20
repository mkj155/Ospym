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
	<h1><spring:message code="contactoform.title.success" /></h1><br />
	<p class="big">
	<span class="text-green"><strong><spring:message code="contactoform.procedurenumber" /> ${numeroTramite}</strong></span><br/>
	<spring:message code="contactoform.body.success" />
	</p>
    <button type="button" class="btn btn-lg btn-primary pull-right" onclick="location.href='/OSDEPYM/'"><spring:message code="button.backtomenu" /></button>
	</div>
 </section>
 
 <section id="beneficios">
        <h2 class="title-section">
            <span class="bg-primary text">BENEFICIOS</span>
            <span class="line-div"></span>
        </h2>
        <div class="container text-center">
            <ul class="list-unstyled list-inline row">
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-01.svg" class="d-none d-md-block" alt="Precios accesibles">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-01.svg" alt="Precios accesibles">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Precios accesibles</span>
                            </div>                               
                        </div>
                    </div>
                </li>
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-02.svg" class="d-none d-md-block" alt="Cartilla online">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-02.svg" alt="Cartilla online">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Cartilla online</span>
                            </div>                               
                        </div>
                    </div>
                </li>
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-03.svg" class="d-none d-md-block" alt="Más de 120 clínicas y centros de atención">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-03.svg" alt="Más de 120 clínicas y centros de atención">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Más de 120 clínicas y centros de atención</span>
                            </div>                               
                        </div>
                    </div>
                </li>
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-04.svg" class="d-none d-md-block" alt="Presencia en todo el país">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-04.svg" alt="Presencia en todo el país">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Presencia en todo el país</span>
                            </div>                               
                        </div>
                    </div>
                </li>
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-05.svg" class="d-none d-md-block" alt="Asistencia al viajero">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-05.svg" alt="Asistencia al viajero">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Asistencia al viajero</span>
                            </div>                               
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        
    </section>
	
	<jsp:include page="./footer.jsp" />

</html>