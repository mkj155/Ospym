<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="loading"><div role="status" class="spinner-border spinner-border"><span class="sr-only">Loading...</span></div></div>
<div id="content-table">
	<div class="search-table-outter wrapper">
		<div class="checkbox-all">
			<label class="control control-checkbox">
		        <spring:message code="label.select.all" />
		            <input type="checkbox" id="check-all-afiliados" />
		        <div class="control-indicator"></div>
		    </label>
		</div>
	
		<table id="table-preview" class="table table-striped table-hover table-sm search-table inner">
			<thead>
		    	<tr>
		      		<th style="padding-left: 40px"></th>
					<th><spring:message code="label.table.1" /></th>
					<th><spring:message code="label.table.2" /></th>
					<th><spring:message code="label.table.3" /></th>
					<th><spring:message code="label.table.4" /></th>
					<th><spring:message code="label.table.5" /></th>
					<th><spring:message code="label.table.6" /></th>
					<th><spring:message code="label.table.7" /></th>
					<th><spring:message code="label.table.8" /></th>
					<th><spring:message code="label.table.9" /></th>
					<th><spring:message code="label.table.10" /></th>
					<th><spring:message code="label.table.11" /></th>
					<th><spring:message code="label.table.12" /></th>
					<th><spring:message code="label.table.13" /></th>
					<th><spring:message code="label.table.14" /></th>
					<th><spring:message code="label.table.15" /></th>
					<th><spring:message code="label.table.16" /></th>
					<th><spring:message code="label.table.17" /></th>
					<th><spring:message code="label.table.18" /></th>
					<th><spring:message code="label.table.19" /></th>
					<th><spring:message code="label.table.20" /></th>
					<th><spring:message code="label.table.21" /></th>
					<th><spring:message code="label.table.22" /></th>
					<th><spring:message code="label.table.23" /></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
		      		<td>&nbsp;</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
		      		<td>&nbsp;</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
		      		<td>&nbsp;</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
		  	</tbody>
		</table>
	</div>
	<div class="row">
		<div class="col-md-12 align-middle text-left mt-2">
        	<span class="pr-1">
				<button type="button" class="btn btn-primary btn-lg btn-search btn-form" id="ingreso-masivo"><spring:message code="button.ingreso.masivo" /></button>
			</span>
            <span class="pl-1">
     			<button type="button" class="btn btn-primary btn-lg btn-search btn-form" id="confirmar"><spring:message code="button.confirmar" /></button>
			</span>
     	</div>
    </div>
</div>