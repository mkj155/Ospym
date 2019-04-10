
function getCategorias(){	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "getCategorias",
		data : $('#motivo').val(),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			$("#categoria").html("<option value=''>--- Seleccionar ---</option>");
			for(var i = 0 ; i < data.length ; i++){
				$("#categoria").html($("#categoria").html() + "<option value='" + data[i].idCateg + "'>" + data[i].etiqueta + "</option>");
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
	});
}
