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
                <div>
                	<spring:url value="/buscar/buscar" var="enviarUrl" />
                	<spring:url value="/buscar/exportar" var="exportar" />
                	<form:form class="form-cartilla custom-form" method="post" id="importForm" modelAttribute="importForm" action="${enviarUrl}">
                	<spring:message code="select.label.empty" var="emptyValue" />
                    <div class="row">
                        
                       
                        <div class="col-md-4">
                            <!-- OBRAS SOCIALES -->
                            <div class="form-group">
                                <label class="control-label">
                                    Obra Social
                                </label>
                                <form:select path="obraSocial" class="form-control" id="obraSocial">
                                	<form:option value="" label=" ${emptyValue} " />
                                	<form:options items="${obrassociales}" itemValue="obraSocialID" itemLabel="descripcionObraSocial" />
                            	</form:select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <!-- TIPO AFILIADO -->
                            <div class="form-group">
                                <label class="control-label">
                                    Tipo de Afiliado
                                </label>
                                <form:select path="tipoCarga" class="form-control" id="tipoCarga">
                                	<form:option value="" label=" ${emptyValue} " />
                                	<form:options items="${tipocargas}" itemValue="tipoCargaId" itemLabel="descripcionTipoCarga" />
                            	</form:select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <!--  ARCHIVO-->
                            <div class="form-group">
                                <label class="control-label">
                                    Archivo
                                </label>
                                <form:input path="cuit" type="number" class="form-control" maxlength="40" />
                            </div>
                        </div>
                       
                    </div>
                    <div class="row">
                        
                       
                        <div class="col-md-4">
                            <!-- TIPO CARGA -->
                            <div class="form-group">
                                <label class="control-label">
                                    Tipo de Archivo
                                </label>
                                <form:select path="obraSocial" class="form-control" id="obraSocial">
                                	<form:option value="" label=" ${emptyValue} " />
                                	<form:options items="${obrassociales}" itemValue="obraSocialID" itemLabel="descripcionObraSocial" />
                            	</form:select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <!-- CUIT -->
                            <div class="form-group">
                                <label class="control-label">
                                    CUIT
                                </label>
                                <form:select path="tipoCarga" class="form-control" id="tipoCarga">
                                	<form:option value="" label=" ${emptyValue} " />
                                	<form:options items="${tipocargas}" itemValue="tipoCargaId" itemLabel="descripcionTipoCarga" />
                            	</form:select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <!--  PAUTA -->
                            <div class="form-group">
                                <label class="control-label">
                                    Pauta
                                </label>
                                <form:input path="cuit" type="number" class="form-control" maxlength="40" />
                            </div>
                        </div>
                       
                    </div>
            	</form:form>
            	</div>
            	
            	<div id="table">
            		<jsp:include page="table.jsp" />	
            	</div>
            </div>
        </section>
    </body>
<jsp:include page="./footer.jsp" />

</html>