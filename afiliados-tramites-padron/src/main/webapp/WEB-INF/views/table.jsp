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
</style>
<button>Load some fake data from mockaroo.com</button>
<div>
	<label class="control control-checkbox">
        Seleccionar todo
            <input type="checkbox" id="check-all-afiliados" />
        <div class="control_indicator"></div>
    </label>
</div>
<table id="tablePreview" class="table table-striped table-hover table-sm">
	<thead>
    	<tr>
      		<th></th>
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
    	<tr v-for="row in users">
    		<td>
				<label class="control control-checkbox">
		            <input type="checkbox" class="afiliado-check" />
			        <div class="control_indicator"></div>
			    </label>
			</td>
      		<td v-for="column in row">{{ column }}</td>
      		<td><a href="#">Anular</a></td>
    	</tr>
    <tr>
			
			
    	</tr>
	</tbody>
</table>