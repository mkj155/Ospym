
function getCategorias(){
	if($('#motivo').val() != null && $('#motivo').val() != ''){
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "getCategorias",
			data : $('#motivo').val(),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				if(data != null && data.length > 0){
					$("#categoria").prop('disabled', false);
					$("#categoria").html("<option value=''> Seleccionar </option>");
					for(var i = 0 ; i < data.length ; i++){
						$("#categoria").html($("#categoria").html() + "<option value='" + data[i].idCateg + "'>" + data[i].etiqueta + "</option>");
					}
				}else{
					$("#categoria").prop('disabled', true);
				}
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
		});
	}
}