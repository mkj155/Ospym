var date;
$(document).ready(function () {
	$(document).on("keyup", function () {
		$("#error-show").hide();
	});
	$("#error-show").hide();
	$("#fechaCarga").keyup(function (e) {
        if (e.keyCode != 193 && e.keyCode != 111) {
            console.log(e.keyCode);
            if (e.keyCode != 8) {
                if ($(this).val().length == 2) {
                    $(this).val($(this).val() + "/");
                } else if ($(this).val().length == 5) {
                    $(this).val($(this).val() + "/");
                }
            } else {
                var temp = $(this).val();
                if ($(this).val().length == 5) {
                    $(this).val(temp.substring(0, 4));
                } else if ($(this).val().length == 2) {
                    $(this).val(temp.substring(0, 1));
                }
            }
        } else {
            var temp = $(this).val();
            var tam = $(this).val().length;
            $(this).val(temp.substring(0, tam-1));
        }
    });
	
	
	$("#loading").hide();
	$("#fechaCarga").datepicker({
		format: 'dd/mm/yyyy'
	});
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
	
	$(document).on("click", "#confirmar", function() {
		if(!confirmar()) {
			$("#error-show").show();
		}
	});
});

function search(){
		if((document.getElementById('fechaCarga').value !== null && document.getElementById('fechaCarga').value !== "") && !validateDate(document.getElementById('fechaCarga'))) {
			$("#error-show").show();
			return false;
		}
		$("#check-all-afiliados")[0].checked = false;
		$('#content-table').hide();
		$("#loading").show();
		var documentOptions = convertFormToJSON($("#solicitudes-form"));
		
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: "solicitudes/buscar",
			data: JSON.stringify(documentOptions),
			dataType : "json",
			async: true,
			timeout : 100000,
			success : function(data) {
				$("#loading").hide();
				$('#content-table').show();
				$('#table-preview tbody').html("");
				$.each(data, function(key, card) {
					var htmlrow = '<tr><td><label class="control control-checkbox">' +
		            '<input type="checkbox" class="afiliado-check" />' +
			        '<div class="control-indicator"></div>' +
			        '</label></td>';
					
					var keys = Object.keys(card);
					
					for(var i = 0; i < keys.length; i++){
					    var value = card[keys[i]];
					    htmlrow += "<td data-row='" + (value ? value : "") + "'>" + (value ? value : "") + "</td>";
					}
		            
					htmlrow += '<td><a href="#">Anular</a></td></tr>';
					
		            $('#table-preview tbody').append(htmlrow);
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

function validateDate(inputText) {
	var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
	// Match the date format through regular expression
	if(inputText.value.match(dateformat)) {
		var opera1 = inputText.value.split('/');
		lopera1 = opera1.length;
		// Extract the string into month, date and year
		if (lopera1>1) {
			var pdate = inputText.value.split('/');
		} 
		var dd = parseInt(pdate[0]);
		var mm  = parseInt(pdate[1]);
		var yy = parseInt(pdate[2]);
		// Create list of days of a month [assume there is no leap year by default]
		var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];
		if (mm==1 || mm>2) {
			if (dd>ListofDays[mm-1]) {
				return false;
			}
		}
		if (mm==2) {
			var lyear = false;
			if ( (!(yy % 4) && yy % 100) || !(yy % 400)) {
				lyear = true;
			}
			if ((lyear==false) && (dd>=29)) {
				return false;
			}
			if ((lyear==true) && (dd>29)) {
				return false;
			}
		}
	} else {
		return false;
	}
	return true;
}

function confirmar() {
	var pendings = 0;
	var selected = $('#table-preview > tbody > tr .afiliado-check:checked').length;
	$.each($('#table-preview > tbody > tr .afiliado-check:checked'), function(){
		pendings += $(this).parent().parent().parent().children('td[data-row="Pendiente"]').length;
	}); 
	
	return pendings > 0 && selected > 0 && pendings === selected;
}