$(document).ready(function(readyEvent) {
	$('[data-toggle="tooltip"]').tooltip();   
	
	$("#errorFile").hide();
	
	$(document).on('click', function () {
		$("#errorFile").hide();
	});
	
	$("#acceptModalPrestador").on('click', function() {
		$("#autorizacionForm").submit();
	});
	
	$("#cancelPrestador").on('click', function() {
		$("#autorizacionForm").find("input[type=text]:visible").filter(function() { if($(this).val()=="") return $(this); })[0].focus();
	});
	
	$("#acceptPrestador").on('click', function() {
		var wrongFileUpload = false;
		var totalSize = 0;
		Object.keys(uploadFiles).forEach(function(key) {
			if(uploadFiles[key].size > 3145728) {
				wrongFileUpload = true;
			}
		totalSize += uploadFiles[key].size;
		});
		
		if(totalSize > 26214400) {
			wrongFileUpload = true;
		}
		
		if(wrongFileUpload) {
			$("#errorFile").show();
			return false;
		}

	   //in case if all Available Text boxes within the form are mandatory
	    var checkEmptyInput = $("#autorizacionForm").find("input[type=text]:visible").filter(function() { if($(this).val()=="") return $(this); }).length;
	    if(checkEmptyInput>0) {
	    	$('#myModal').modal('show');
	        return false;
	    }
		
	    $("#autorizacionForm").submit();
	});
});

function getPrestaciones(){
	if($('#idEspecialidad').val() != null && $('#idEspecialidad').val() != ''){
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "getPrestaciones",
			data : $('#idEspecialidad').val(),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				if(data != null && data.length > 0){
					$("#idPrestacion").css('display', 'block');
					$("#divIdPrestacion").css('display', 'block');
					$("#idPrestacion").attr('required', true);
					$("#idPrestacion option[value!='']").remove();
					for(var i = 0 ; i < data.length ; i++){
						$("#idPrestacion").html($("#idPrestacion").html() + "<option value='" + data[i].idPrestacion + "'>" + data[i].etiqueta + "</option>");
					}
				}else{
					$("#idPrestacion").css('display', 'none');
					$("#divIdPrestacion").css('display', 'none');
					$("#idPrestacion").attr('required', false);
				}
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
		});
	} else {
		$("#divIdPrestacion").css('display', 'none');
		$("#prestacion").css('display', 'none');
		$("#prestacion").attr('required', false);
	}
}