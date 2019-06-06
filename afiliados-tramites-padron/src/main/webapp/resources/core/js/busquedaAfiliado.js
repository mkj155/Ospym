$(document).ready(function () {
	$(".afiliado-check").on("change", function(){
        if ($(".afiliado-check:checked").length == $(".afiliado-check").length) {
        	$("#check-all-afiliados")[0].checked = true;
        } else {
    		$("#check-all-afiliados")[0].checked = false;
        }
    });
	
	$("#check-all-afiliados").on("change", function(){
        if (this.checked) {
        	$(".afiliado-check").each(function(){
                this.checked = true;
            });
        } else {
        	$(".afiliado-check").each(function(){
                this.checked = false;
            });
        }
    });
	
	$("#search").on("click", function(){
        search();
    });
});

function search(){
		var documentOptions = convertFormToJSON($("#solicitudesForm"));
		
		$.ajax({
			type: "POST",
			contentType : 'application/json; charset=utf-8',
			url: "search",
			data: documentOptions,
			dataType : 'application/json',
			async: true,
			timeout : 100000,
			success : function(data) {
				if(data != null && data.length > 0){
					for(var i = 0 ; i < data.length ; i++){
						$("#categoria").html($("#categoria").html() + "<option value='" + data[i].idCategoria + "'>" + data[i].etiqueta + "</option>");
					}
				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
}

function convertFormToJSON(form){
    var array = jQuery(form).serializeArray();
    var json = {};
    
    jQuery.each(array, function() {
        json[this.name] = this.value || '';
    });
    
    return json;
}