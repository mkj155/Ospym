<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="loading"><div role="status" class="spinner-border spinner-border"><span class="sr-only">Loading...</span></div></div>
<div id="content-table">
		<div class="checkbox-all">
			<label class="control control-checkbox">
		        <spring:message code="label.select.all" />
		            <input type="checkbox" id="check-all-afiliados" />
		        <div class="control-indicator"></div>
		    </label>
		</div>
	<div class="search-table-outter wrapper" id="content-table-child">
		<table id="table-preview" class="table table-striped table-hover table-sm search-table inner">
			<thead>
		    	<tr>
		      		<th style="padding-left: 40px"></th>
					<% for(int i = 1; i <= 23; i++) { %>
						<c:set var="index" ><%=i %></c:set>
						<th><spring:message code="label.table.${index}" /></th>
					<% } %>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
		      		<td>&nbsp;</td>
					<% for(int i = 0; i < 23; i++) { %>
						<td></td>
					<% } %>
				</tr>
		  	</tbody>
		</table>
	</div>
	<div class="row">
		<div class="col-md-12 align-middle text-left mt-2">
        	<span class="pr-1">
				<button type="button" class="btn btn-primary btn-lg btn-search btn-form" id="ingreso-masivo" onclick="window.location.href = 'solicitudes/cargaMasiva'"><spring:message code="button.ingreso.masivo" /></button>
			</span>
            <span class="pl-1">
     			<button type="button" class="btn btn-primary btn-lg btn-search btn-form" id="confirmar"><spring:message code="button.confirmar" /></button>
			</span>
			<span class="pl-1">
     			<button type="button" class="btn btn-primary btn-lg btn-search btn-form" id="exportar"><spring:message code="button.exportar" /></button>
			</span>
     	</div>
    </div>
    <div id="error-confirmar" class="alert alert-danger my-4">
    </div>
</div>