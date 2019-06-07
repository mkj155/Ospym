<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<script src="https://unpkg.com/jquery@3.2.1/dist/jquery.min.js"></script>
<script src="https://unpkg.com/vue@2.4.2/dist/vue.min.js"></script>
<style>
	th {
		width: 100px;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
   }
   
   .checkbox-all {
   		margin-left: 4.8px;
   }
   
   #tablePreview td, #tablePreview th {
   	border: 1px solid gray;
   }
   
.search-table{table-layout: fixed; }
.search-table, td, th{border-collapse:collapse; }
th{padding:20px 7px; }
td{padding:5px 10px; }

.search-table-outter { overflow-x: scroll; }
th, td { min-width: 200px; }
</style>
<div class="checkbox-all">
	<label class="control control-checkbox">
        Seleccionar todo
            <input type="checkbox" id="check-all-afiliados" />
        <div class="control_indicator"></div>
    </label>
</div>
<div id="loading"></div>
<div class="search-table-outter wrapper">
<table id="tablePreview" class="table table-striped table-hover table-sm search-table inner">
	<thead>
    	<tr>
      		<th style="padding-left: 40px"></th>
			<th>Registro N&deg;</th>
			<th>Obra Social</th>
			<th>Tipo carga (Titular - Adherente)</th>
			<th>Tipo de Afiliado (Rel dep, monotributista, voluntario)</th>
			<th>CUIT</th>
			<th>CUIL</th>
			<th>Apellido</th>
			<th>Nombre</th>
			<th>Tipo Documento</th>
			<th>Nro Documento</th>
			<th>Fecha Nacimiento</th>
			<th>Sexo</th>
			<th>Estado Civil</th>
			<th>CUIL Titular</th>
			<th>Fecha Inicio</th>
			<th>Centro Medico</th>
			<th>Plan</th>
			<th>Estado</th>
			<th>N&deg; Solicitud</th>
			<th>Archivo (nombre del archivo)</th>
			<th>Fecha carga</th>
			<th>C&oacute;digo Error</th>
			<th>Descripci&oacute;n de error</th>
			<th></th>
		</tr>
  	</thead>
	<tbody> 
	</tbody>
</table>
</div>