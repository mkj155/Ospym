$(document).ready(function () {
	$( document ).on("click", ".afiliado-check", function(){
        if ($(".afiliado-check:checked").length == $(".afiliado-check").length) {
        	$("#check-all-afiliados")[0].checked = true;
        } else {
    		$("#check-all-afiliados")[0].checked = false;
        }
    });
	
	$( document ).on("change", "#check-all-afiliados", function(){
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
	
	$( document ).on("click", "#search", function() {
		search();
	});
	
	$( document ).on("keyup", ".date-picker", function(){
		this.type = 'text';
	    var input = this.value;
	    if (/\D\/$/.test(input)) input = input.substr(0, 10);
	    var values = input.split('/').map(function(v) {
	      return v.replace(/\D/g, '')
	    });
	    if (values[0]) values[0] = checkValue(values[0], 12);
	    if (values[1]) values[1] = checkValue(values[1], 31);
	    var output = values.map(function(v, i) {
	      return v.length == 2 && i < 2 ? v + '/' : v;
	    });
	    this.value = output.join('').substr(0, 10);
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
		$("#check-all-afiliados")[0].checked = false;
		$('#tablePreview').hide();
		$("#loading").html('<div role="status" class="spinner-border spinner-border"><span class="sr-only">Loading...</span></div>');
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
				$("#loading").html("");
				$('#tablePreview').show();
				$('#tablePreview tbody').html("");
				$.each(data, function(key, card) {

					var htmlrow = '<tr><td><label class="control control-checkbox">' +
		            '<input type="checkbox" class="afiliado-check" />' +
			        '<div class="control_indicator"></div>' +
			        '</label></td>' +						
					"<td>" + card.nombre + "</td>" +					
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
					"<td></td>" +
		            '<td><a href="#">Anular</a></td></tr>';
		            $('#tablePreview tbody').append(htmlrow);
		        });
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