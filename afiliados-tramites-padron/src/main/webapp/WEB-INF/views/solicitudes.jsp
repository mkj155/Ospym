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
                	<form:form class="form-cartilla custom-form" method="post" id="solicitudesForm" modelAttribute="solicitudesForm" action="${enviarUrl}">
                	<spring:message code="select.label.empty" var="emptyValue" />
                    <div class="row">
                        <div class="col-md-2">
                            <!-- CUIL -->
                            <div class="form-group">
                                <label class="control-label">
                                    CUIL
                                </label>
                                <form:input path="cuil" type="number" class="form-control" maxlength="40" />
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!-- REGISTRO -->
                            <div class="form-group">
                                <label class="control-label">
                                    Registro N&deg;
                                </label>
                                <form:input path="numeroRegistro" type="number" class="form-control" maxlength="40" />
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!-- ESTADO -->
                            <div class="form-group">
                                <label class="control-label">
                                    Obra Social
                                </label>
                                <form:select path="obraSocial" class="form-control" id="obraSocial">
                                	<form:option value="" label=" ${emptyValue} " />
                                	<form:options items="${obrassociales}" itemValue="id" itemLabel="nombre" />
                            	</form:select>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!--  APELLIDO -->
                            <div class="form-group">
                                <label class="control-label">
                                    Apellido
                                </label>
                                <form:input path="apellido" type="text" class="form-control" maxlength="40" />
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!--  NOMBRE -->
                            <div class="form-group">
                                <label class="control-label">
                                    Nombre
                                </label>
                                <form:input path="nombre" type="text" class="form-control" maxlength="40" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                    	<div class="col-md-2">
                            <!-- ESTADO -->
                            <div class="form-group">
                                <label class="control-label">
                                   Estado
                                </label>
                                <form:select path="estado" class="form-control" id="estado">
                                	<form:option value="" label=" ${emptyValue} " />
                                	<form:options items="${estados}" itemValue="id" itemLabel="nombre" />
                            	</form:select>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!-- FECHA CARGA -->
                            <div class="form-group">
                                <label class="control-label">
                                    Fecha carga
                                </label>
                                <div class='right-inner-addon date datepicker' data-date-format="dd-MM-yyyy">
								      <i class="far fa-calendar-alt"></i>
								<form:input path="fechaCarga" type="text" maxlength="40" id="fechaCarga" class="form-control date-picker" data-date-format="yyyy-mm-dd" />
								</div>
                           	</div>
                    	</div>
                        <div class="col-md-2">
                          	<!--  SOLICITUD N -->
                            <div class="form-group">
                                <label class="control-label">
                                    Solicitud N&deg;
                                </label>
                                <form:input path="numeroSolicitud" type="number" class="form-control" maxlength="40" />
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!--  SOLICITUD N -->
                            <div class="form-group">
                                <label class="control-label">
                                    Nro Documento
                                </label>
                                <form:input path="dni" type="number" class="form-control" maxlength="40" />
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!--  SOLICITUD N -->
                            <div class="form-group">
                                <label class="control-label">
                                    CUIT
                                </label>
                                <form:input path="cuit" type="number" class="form-control" maxlength="40" />
                            </div>
                        </div>
                        <div class="col-md-2">
                            <!--  SOLICITUD N -->
                            <div class="form-group">
                                <label class="control-label">
                                    CUIT
                                </label>
                                <input type="checkbox" class="form-control" />
                            </div>
                        </div>
                       	<div class="col-md-2">
                           <button type="button" class="btn btn-primary btn-lg mt-4 btn-form" id="search">Buscar</button>
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