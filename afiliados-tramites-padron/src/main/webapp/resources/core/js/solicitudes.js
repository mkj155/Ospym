$(document).ready(function () {
	var table = new Vue({
		  el: '#tablePreview',
		  data: {
		    users: []
		  }
		});

		// And on click just assign loaded JSON to component model
		// and view (table) will be re-rendered automatically
		
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
	
	$('#search').on("click", function() {
		search();
	});
	
	$(".date-picker").on("keyup", function(){
		this.type = 'text';
	    var input = this.value;
	    if (/\D\/$/.test(input)) input = input.substr(0, input.length - 3);
	    var values = input.split('/').map(function(v) {
	      return v.replace(/\D/g, '')
	    });
	    if (values[0]) values[0] = checkValue(values[0], 12);
	    if (values[1]) values[1] = checkValue(values[1], 31);
	    var output = values.map(function(v, i) {
	      return v.length == 2 && i < 2 ? v + '/' : v;
	    });
	    this.value = output.join('').substr(0, 14);
	});
});

function checkValue(str, max) {
    if (str.charAt(0) !== '0' || str == '00') {
      var num = parseInt(str);
      if (isNaN(num) || num <= 0 || num > max) num = 1;
      str = num > parseInt(max.toString().charAt(0)) 
             && num.toString().length == 1 ? '0' + num : num.toString();
    };
    return str;
}

function search(){
		var documentOptions = convertFormToJSON($("#solicitudesForm"));
		
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: "solicitudes/buscar",
			data: JSON.stringify(documentOptions),
			dataType : "json",
			async: true,
			timeout : 100000,
			success : function(data) {
				data;
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