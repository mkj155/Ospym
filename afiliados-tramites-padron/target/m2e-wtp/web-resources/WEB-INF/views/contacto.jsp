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
            <h1><spring:message code="title.canaldecontacto" /></h1>
            <spring:url value="/contacto/send" var="enviarUrl" />
            <form:form class="form-cartilla custom-form" method="post" modelAttribute="contactoForm" action="${enviarUrl}">
                <spring:message code="select.label.empty" var="emptyValue" />
                <div class="row">
                    <!-- AFILIADO -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">
                                <spring:message code="label.afiliado" />
                            </label>
                            <form:hidden path="idAfiliado" />
                            <form:input path="nombreAfiliado" readonly="true" class="form-control" placeholder="Email" />
                            <form:errors path="idAfiliado" class="control-label" />
                            <div class="col-sm-5"></div>
                        </div>
                    </div>
                    <!-- MOTIVOS -->
                    <div class="col-md-3">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">
                                <spring:message code="select.label.motivo" />
                            </label>
                            <form:select path="idMotivo" class="form-control" id='motivo' onchange="getCategorias()" required="true">
                                <form:option value="" label=" ${emptyValue} " />
                                <form:options items="${motivos}" itemValue="idMotivo" itemLabel="etiqueta" />
                            </form:select>
                            <form:errors path="idMotivo" class="control-label" />
                            <div class="col-sm-5"></div>
                        </div>
                    </div>
                    <!-- CATEGORIAS -->
                    <div class="col-md-3">
                        <div class="form-group ${status.error ? 'has-error' : ''}" id="divIdCategoria">
                            <label class="col-sm-2 control-label">
                                <spring:message code="select.label.categoria" />
                            </label>
                            <form:select path="idCategoria" class="form-control" id="categoria">
                                <form:option value="" label=" ${emptyValue} " />
                            </form:select>
                            <form:errors path="idCategoria" class="control-label" />
                            <div class="col-sm-5"></div>
                        </div>
                    </div>
                    <!-- COMENTARIO -->
                    <div class="col-md-9">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">
                                <spring:message code="label.comentario" />
                            </label>
                            <form:textarea path="comentario" rows="5" cols="90" class="form-control coment-contacto" maxlength="1024" required="true" />
                            <form:errors path="comentario" class="control-label" />
                        </div>
                    </div>
	                <div class="col-md-12">
	                    <span class="float-md-right">
	                        <button type="submit" class="btn btn-outline-primary btn-block">
	                            <spring:message code="button.send" />
	                        </button>
	                    </span>
	                </div>
                </div>
            </form:form>
        </div>
    </section>
 </body>
<jsp:include page="./footer.jsp" />
</html>