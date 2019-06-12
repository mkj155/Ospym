


$(document).ready(function() {
	$('#tipoCarga').change(function(){
	    if($('#tipoCarga-' + $(this).val()).val() === '1'){
	    	$('#tipoAfiliadoDiv').css("display", "");
	    }else{
	    	$('#tipoAfiliadoDiv').css("display", "none")
	    	$('#tipoAfiliadoDiv').val("")
	    }
	});
	
	$('#cuitId').blur(function(){
		getPauta();
	});
	
	$('#uploadFile').change(function(){
		uploadFile();
	});
	
	$('#buttonUploadFile').on('click', function() {
		  var fileSelector = document.getElementById('uploadFile');
		  fileSelector.click();
	     return false;	
	});
});

function getPauta(){
	if($('#cuitId').val() != null && $('#cuitId').val() != ''){
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "obtenerPautas",
			data : $('#cuitId').val(),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				if(data != null && data.length > 0){
					$("#pautaId option[value!='']").remove();
					for(var i = 0 ; i < data.length ; i++){
						$("#pautaId").html($("#pautaId").html() + "<option value='" + data[i].pautaId + "'>" + data[i].pauta + "</option>");
					}
				}else{
					$("#pautaId").html('<form:option value="" label="Seleccionar" />');
				}
				
			
			},
			error : function(e) {
				console.log("ERROR: ", e);

				
			},
		});
	} 
}



function uploadFile(){
	if($('#uploadFile').val() != null && $('#uploadFile').val() != ''){
		var form = $('#importForm')[0];
	    var formData = new FormData(form);
	    formData.append("file", $('#uploadFile')[0].files[0]);
		$.ajax({
			url : "procesarArchivo",
			enctype: 'multipart/form-data',
			data : formData,
		    cache: false,
		    contentType: false,
		    processData: false,
		    method: 'POST',
		    type: 'POST',
			success : function(data) {
				if(data != null && data.length > 0){
					var hasError = false;
					//$("#pautaId option[value!='']").remove();
					$("#tableBody").html('');
					for(var i = 0 ; i < data.length ; i++){
						var row = '';
						if(data[i].errorValidacion)
							row = '<tr style="background-color:FF9494;color:white;">'
						else
							row = '<tr>'	
						$("#tableBody").html($("#tableBody").html() +
						row + 
						"<td>" + data[i].cuil + "</td>"+
						"<td>" + data[i].apellido + "</td>"+
						"<td>" + data[i].nombre + "</td>"+
						"<td>" + data[i].tipoDocumento + "</td>"+
						"<td>" + data[i].nroDocumento + "</td>"+
						"<td>" + data[i].direccion + "</td>"+
						"<td>" + data[i].numero + "</td>"+
						"<td>" + data[i].piso + "</td>"+
						"<td>" + data[i].departamento + "</td>"+
						"<td>" + data[i].localidad + "</td>"+
						"<td>" + data[i].provincia + "</td>"+
						"<td>" + data[i].codigoPostal + "</td>"+
						"<td>" + data[i].telefono + "</td>"+
						"<td>" + data[i].fechaNacimiento + "</td>"+
						"<td>" + data[i].sexo + "</td>"+
						"<td>" + data[i].estadoCivil + "</td>"+
						"<td>" + data[i].fechaInicioCobertura + "</td>"+
						"<td>" + data[i].email + "</td>"+
						"<td>" + data[i].errorValidacion + "</td>"+
						"</tr>"
						);
						if(data[i].errorValidacion){
							hasError = true;
						}
					}
					if(!hasError){
						$("#confirmar").prop("disabled", false);
						$("#confirmar").removeClass( "disabled" );
					}else{
						$("#confirmar").prop("disabled", true);
						$("#confirmar").addClass( "disabled" );
					}
				}else{
					
				}
				
			
			},
			error : function(e) {
				console.log("ERROR: ", e);

				
			},
		});
	} 
}


function descargarPlantilla(){
		$.ajax({
			url : "descargarPlantilla",
		    cache: false,
		    contentType: false,
		    processData: false,
		    method: 'POST',
		    type: 'POST',
			success : function(data) {
				
				
			
			},
			error : function(e) {
				console.log("ERROR: ", e);

				
			},
		});
	} 
