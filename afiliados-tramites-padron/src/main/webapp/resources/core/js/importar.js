var varUploadFile = false;
$(document).ready(function() {
	$('#tipoCarga').change(function(){
	    if($('#tipoCarga-' + $(this).val()).val() === '1'){
	    	$('#tipoAfiliadoDiv').css("display", "");
	    }else{
	    	$('#tipoAfiliadoDiv').css("display", "none")
	    	$('#tipoAfiliadoDiv').val("")
	    }
	    
	    cargarEnable();
	});
	
	$('#cuitId').change(function(){
		getPauta();
	});
	
	$('#uploadFile').on('change', function(changeEvent) {
		uploadFile();
		cargarEnable();
	});
	
	$('#obraSocial').change(function(){
		cargarEnable();
	});
	
	$('#pautaId').change(function(){
		cargarEnable();
	});
	
	$('#cuitId').keyup(function(){
		getPauta();
	});
	
	$(document).on('click', '#buttonUploadFile', function() {
		  var fileSelector = $('#uploadFile');
		  fileSelector.click();
		  $("button").prop("disabled", false);
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
					$("#pautaId").html("<option value=\"\">Seleccionar</option>");
					for(var i = 0 ; i < data.length ; i++){
						$("#pautaId").html($("#pautaId").html() + "<option value='" + data[i].pautaId + "'>" + data[i].pauta + "</option>");
					}
					$("#pautaId").prop("disabled", false);
					$("#pautaHelp").css({'display':'none'});
					cargarEnable();
				}else{
					$("#pautaId").html("");
					$("#pautaId").val("");
					$("#pautaId").prop("disabled", true);
					$("#pautaHelp").css({'display':'block'});
					cargarEnable();
				}
			},
			error : function(e) {
				console.log("ERROR: ", e);

				cargarEnable();
			},
		});
	} 
}



function uploadFile(){
	if($('#cuitId').val() == null || $('#cuitId').val() == '' || $("#pautaId").val() == null || $("#pautaId").val() == ''  || $("#tipoAfiliado").val() == null || $("#tipoAfiliado").val() == ''){
		$("#errorRequeridos").css("display", "");
		$('#uploadFile').val(null);
		return;
	}else{
		$("#errorRequeridos").css("display", "none");
	}	
	
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
				if(data.error && data.error != ""){
					$("#errorCargarArchivo").html(data.error);
					$("#errorCargarArchivo").css("display", "");
					return;
				}
				if(data != null && data.afiliados != null && data.afiliados.length > 0){
					$("#errorCargarArchivo").html("");
					$("#errorCargarArchivo").css("display", "none");
					var hasError = false;
					//$("#pautaId option[value!='']").remove();
					$("#tableBody").html('');
					for(var i = 0 ; i < data.afiliados.length ; i++){
						var row = '';
						var afiliado = data.afiliados[i];
						row = '<tr>'	
						$("#tableBody").html($("#tableBody").html() +
						row + 
						"<td>" + afiliado.cuil + "</td>"+
						"<td>" + afiliado.apellido + "</td>"+
						"<td>" + afiliado.nombre + "</td>"+
						"<td>" + afiliado.tipoDocumento + "</td>"+
						"<td>" + afiliado.nroDocumento + "</td>"+
						"<td>" + afiliado.direccion + "</td>"+
						"<td>" + afiliado.numero + "</td>"+
						"<td>" + afiliado.piso + "</td>"+
						"<td>" + afiliado.departamento + "</td>"+
						"<td>" + afiliado.localidad + "</td>"+
						"<td>" + afiliado.provincia + "</td>"+
						"<td>" + afiliado.codigoPostal + "</td>"+
						"<td>" + afiliado.telefono + "</td>"+
						"<td>" + afiliado.fechaNacimiento + "</td>"+
						"<td>" + afiliado.sexo + "</td>"+
						"<td>" + afiliado.estadoCivil + "</td>"+
						"<td>" + afiliado.fechaInicioCobertura + "</td>"+
						"<td>" + afiliado.email + "</td>"+
						"<td>" + afiliado.errorMensaje + "</td>"+
						"</tr>"
						);
						if(afiliado.errorMensaje != "OK"){
							hasError = true;
						}
					}
					if(!hasError){
						varUploadFile = true;	
					}else{
						varUploadFile = false;
					}
					
					$("button").prop("disabled", false);
					$("#idArchivo").val(data.afiliados[0].idArchivo);
					cargarEnable();
				}else{
					$("button").prop("disabled", false);
					cargarEnable();
				}
			},
			error : function(e) {
				console.log("ERROR: ", e);

				$("button").prop("disabled", false);
				cargarEnable();
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
				$("#buttonUploadFile").prop("disabled", false);
				$("#ingreso-masivo").prop("disabled", false);
				$("#Confirmar").prop("disabled", false);
				$("#Cancelar").prop("disabled", false);
				
			
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$("#buttonUploadFile").prop("disabled", false);
				$("#ingreso-masivo").prop("disabled", false);
				$("#Confirmar").prop("disabled", false);
				$("#Cancelar").prop("disabled", false);
				
			},
			
		});
		
	} 

function cargarEnable() {
	if($('#cuitId').val() != null && $('#cuitId').val() != '' && 
		$("#pautaId").val() != null && $("#pautaId").val() != '' && 
		$("#obraSocial").val() != null && $("#obraSocial").val() != '' && 
		$("#tipoCarga").val() != null && $("#tipoCarga").val() != '' && 
		varUploadFile) {
		$("#confirmar").prop("disabled", false);
		$("#confirmar").removeClass("disabled");
	} else {
		$("#confirmar").prop("disabled", true);
		$("#confirmar").addClass("disabled");
	}
}