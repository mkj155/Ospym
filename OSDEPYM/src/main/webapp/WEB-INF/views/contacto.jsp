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
			<h1><spring:message code="contactoform.title.canaldecontacto" /></h1>
			<spring:url value="/contacto/send" var="enviarUrl" />
			<form:form class="form-cartilla custom-form" method="post"
				modelAttribute="contactoForm" action="${enviarUrl}">
				<spring:message code='select.emptyvalue' var="emptyValue" />
				<div class="row">
					<!-- AFILIADO -->
					<div class="col-md-3">
						<div class="form-group">
							<label class="col-sm-2 control-label"><spring:message code="contactoform.label.afiliado" /></label>
							<form:hidden path="idAfiliado" />
							<form:input path="nombreAfiliado" readonly="true" class="form-control" placeholder="Email" />
							<form:errors path="idAfiliado" class="control-label" />
							<div class="col-sm-5"></div>
						</div>
					</div>
					<!-- MOTIVOS -->
					<div class="col-md-3">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label"><spring:message code="contactoform.select.label.motivo" /></label>
								<form:select path="idMotivo" class="form-control" id='motivo'
									onchange="getCategorias()" required="true">
									<form:option value="" label=" ${emptyValue} " />
									<form:options items="${motivos}" itemValue="idMotivo"
										itemLabel="etiqueta" />
								</form:select>
								<form:errors path="idMotivo" class="control-label" />
							<div class="col-sm-5"></div>
						</div>
					</div>
						<!-- CATEGORIAS -->
					<div class="col-md-3">
						<div class="form-group ${status.error ? 'has-error' : ''}" id="divIdCategoria" style="display: none">
							<label class="col-sm-2 control-label" ><spring:message code="contactoform.select.label.categoria" /></label>
							<form:select path="idCategoria" class="form-control" id="categoria" style="display: none">
								<form:option value="" label=" ${emptyValue} " />
							</form:select>
							<form:errors path="idCategoria" class="control-label" />
							<div class="col-sm-5"></div>
						</div>
					</div>
					<!-- COMENTARIO -->
					<div class="col-md-4">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label"><spring:message code="contactoform.label.comentario" /></label>
							<form:textarea path="comentario" rows="5" cols="90" class="form-control coment-contacto" maxlength="1024" required="true" />
							<form:errors path="comentario" class="control-label" />
							<div class="col-sm-5"></div>
						</div>
					</div>
					</div>
					<div class="form-group">
						<div class="text-center">
							<button type="submit" class="btn btn-outline-primary btn-block btn-sm button-contact"><spring:message code="button.send" /></button>
						</div>
					</div>
			</form:form>
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
</body>


</html>