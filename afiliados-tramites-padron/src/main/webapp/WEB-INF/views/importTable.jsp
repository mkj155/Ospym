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
					<th><spring:message code="label.importtable.1" /></th>
					<th><spring:message code="label.importtable.2" /></th>
					<th><spring:message code="label.importtable.3" /></th>
					<th><spring:message code="label.importtable.4" /></th>
					<th><spring:message code="label.importtable.5" /></th>
					<th><spring:message code="label.importtable.6" /></th>
					<th><spring:message code="label.importtable.7" /></th>
					<th><spring:message code="label.importtable.8" /></th>
					<th><spring:message code="label.importtable.9" /></th>
					<th><spring:message code="label.importtable.10" /></th>
					<th><spring:message code="label.importtable.11" /></th>
					<th><spring:message code="label.importtable.12" /></th>
					<th><spring:message code="label.importtable.13" /></th>
					<th><spring:message code="label.importtable.14" /></th>
					<th><spring:message code="label.importtable.15" /></th>
					<th><spring:message code="label.importtable.16" /></th>
					<th><spring:message code="label.importtable.17" /></th>
					<th><spring:message code="label.importtable.18" /></th>
					<th><spring:message code="label.importtable.19" /></th>
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