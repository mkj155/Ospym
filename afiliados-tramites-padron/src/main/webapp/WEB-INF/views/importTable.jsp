<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="loading"><div role="status" class="spinner-border spinner-border"><span class="sr-only">Loading...</span></div></div>
<div id="content-table">
	<div class="search-table-outter wrapper" id="content-table-child">
		<table id="table-preview" class="table table-striped table-hover table-sm search-table inner">
			<thead>
		    	<tr>
					<% for(int i = 1; i <= 19; i++) { %>
						<c:set var="index" ><%=i %></c:set>
						<th><spring:message code="label.importtable.${index}" /></th>
					<% } %>
				</tr>
			</thead>
			<tbody id="tableBody">
				<tr>
					<% for(int i = 0; i < 19; i++) { %>
						<td></td>
					<% } %>
				</tr>
				<tr>
					<% for(int i = 0; i < 19; i++) { %>
						<td></td>
					<% } %>
				</tr>
				<tr>
					<% for(int i = 0; i < 19; i++) { %>
						<td></td>
					<% } %>
				</tr>
		  	</tbody>
		</table>
	</div>
	<div class="row">
		<div class="col-md-12 align-middle text-left mt-2">
        	<span class="pr-1">
				<button onclick="window.location.href = '../solicitudes'" type="button" class="btn btn-primary btn-lg btn-search btn-form" id="Cancelar">CANCELAR</button>
			</span>
            <span class="pl-1">
     			<input type="submit" class="btn btn-primary btn-lg btn-search btn-form disabled" value="CONFIRMAR" id="confirmar" disabled/>
			</span>
     	</div>
    </div>
</div>