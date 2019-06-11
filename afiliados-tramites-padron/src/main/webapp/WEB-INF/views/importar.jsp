<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<jsp:include page="./header.jsp" />
	<script src="/OSDEPYM/resources/core/js/importar.js"></script>
    <body>
        <section id="main" class="bg-gray">
            <div class="container page page-cartilla">
                <div>
                	<spring:url value="/solicitudes/importar" var="enviarUrl" />
                	<spring:url value="/buscar/exportar" var="exportar" />
                	<form:form class="form-cartilla custom-form" method="post" id="importForm" modelAttribute="importForm" action="${enviarUrl}" enctype="multipart/form-data">
                	<spring:message code="select.label.empty" var="emptyValue" />
                    <div class="row">
                        
                       
                        <div class="col-md-4">
                            <!-- OBRAS SOCIALES -->
                            <div class="form-group">
                                <label class="control-label">
                                    Obra Social
                                </label>
                                <form:select path="obraSocial" class="form-control" id="obraSocial" >
                                	<form:option value="" label=" ${emptyValue} " />
                                	<form:options items="${obrassociales}" itemValue="obraSocialID" itemLabel="descripcionObraSocial" />
                            	</form:select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <!-- TIPO AFILIADO -->
                            <div class="form-group" id="tipoAfiliadoDiv" style="display:none">
                                <label class="control-label">
                                    Tipo de Afiliado
                                </label>
                                <form:select path="tipoAfiliado" class="form-control" id="tipoAfiliado" >
                                	<form:option value="" label=" ${emptyValue} " />
                                	<form:options items="${tipoafiliados}" itemValue="tipoAfiliadoId" itemLabel="descripcionTipoAfiliado" />
                            	</form:select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <!--  ARCHIVO-->
                            <div class="form-group">
                                <div class="col-md-12">
	                        <div id="file-container" class="form-group ${status.error ? 'has-error' : ''}">
								<input type="file" id="uploadFile" class="btn-file" name="uploadFile" accept=".xls,.xlsx"/>
	                        </div>
	                    </div>
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
                                <form:select path="obraSocial" class="form-control" id="tipoCarga">
                                	<form:option value="" label=" ${emptyValue} " />
                                	<form:options items="${tipocargas}" itemValue="tipoCargaId" itemLabel="descripcionTipoCarga" />
                            	</form:select>
                            	<c:forEach items="${tipocargas}" var="par">
                            		<input type="hidden" id="tipoCarga-${par.tipoCargaId}" value="${par.requiereTipoAfiliado}" />
                            	</c:forEach>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <!-- CUIT -->
                            <div class="form-group">
                                <label class="control-label">
                                    CUIT
                                </label>
                                <form:input id="cuitId" path="cuit" type="text" class="form-control" />
                            </div>
                        </div>
                        <div class="col-md-4">
                            <!--  PAUTA -->
                            <div class="form-group">
                                <label class="control-label">
                                    Pauta
                                </label>
                                <form:select path="pauta" class="form-control" id="pautaId">
                                	<form:option value="" label=" ${emptyValue} " />
                            	</form:select>
                            </div>
                        </div>
                       
                    </div>
                    <input type="submit" value="Upload file" />
            	</form:form>
            	</div>
            	
            	<div id="table">
            		<jsp:include page="importTable.jsp" />	
            	</div>
            </div>
        </section>
    </body>
<jsp:include page="./footer.jsp" />

</html>