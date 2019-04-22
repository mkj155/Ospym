
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
					$("#categoria").css('display', 'block');
					$("#divIdCategoria").css('display', 'block');
					$("#categoria").attr('required', true);
					$("#categoria option[value!='']").remove();
					for(var i = 0 ; i < data.length ; i++){
						$("#categoria").html($("#categoria").html() + "<option value='" + data[i].idCategoria + "'>" + data[i].etiqueta + "</option>");
					}
				}else{
					$("#categoria").css('display', 'none');
					$("#categoria").attr('required', false);
					$("#divIdCategoria").css('display', 'none');
				}
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
		});
	} else {
		$("#categoria").css('display', 'none');
		$("#categoria").attr('required', false);
	}
}