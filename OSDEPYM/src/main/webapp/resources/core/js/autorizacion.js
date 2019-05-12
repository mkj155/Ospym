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