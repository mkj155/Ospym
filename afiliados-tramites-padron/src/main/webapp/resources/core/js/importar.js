


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
					
				}else{
					
				}
				
			
			},
			error : function(e) {
				console.log("ERROR: ", e);

				
			},
		});
	} 
}