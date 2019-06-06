$(document).ready(function() {
	$("#loadingCategoria").hide();
	$("#divIdCategoria").hide();
});

function getCategorias(){
	$("#divIdCategoria").hide();
	$("#loadingCategoria").show();
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
					$("#divIdCategoria").css('display', 'none');
					$("#categoria").attr('required', false);
				}
				
				$("#loadingCategoria").hide();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$("#loadingCategoria").hide();
			},
		});
	} else {
		$("#divIdCategoria").css('display', 'none');
		$("#categoria").css('display', 'none');
		$("#categoria").attr('required', false);		
		$("#loadingCategoria").hide();

	}
}