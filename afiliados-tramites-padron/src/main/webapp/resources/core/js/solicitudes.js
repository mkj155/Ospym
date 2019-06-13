var date;
var exportForm;
var afiliadoAnular = {};
var paginado;
(function($) {
	  $.fn.inputFilter = function(inputFilter) {
	    return this.on("input keydown keyup mousedown mouseup select contextmenu drop", function() {
	      if (inputFilter(this.value)) {
	        this.oldValue = this.value;
	        this.oldSelectionStart = this.selectionStart;
	        this.oldSelectionEnd = this.selectionEnd;
	      } else if (this.hasOwnProperty("oldValue")) {
	        this.value = this.oldValue;
	        this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
	      }
	    });
	  };
	}(jQuery));

document.onclick = function(e) {
	if(e.target.type !=='button') {
		$("#error-date").hide();
		$("#error-confirmar").hide();
		$("#success-confirmar").hide();
		$("#error-table").hide();
	}
}

$(document).ready(function () {
	$("#error-table").hide();
	$(".checkbox-all").hide();
	$(".number-input").inputFilter(function(value) {
		return /^\d*$/.test(value); 	
	});
	$("#error-confirmar").hide();
	$("#success-confirmar").hide();
	$("#error-date").hide();
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
	
	$( document ).on("click", "#check-all-afiliados", function(){
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
	
	$( document ).on("click", "#search", function(e) {
		search();
		e.stopPropagation();
	});
	
	$( document ).on("click", "#exportar", function(e) {
		exportar();
		e.stopPropagation();
	});
	
	$(document).on("click", "#confirmar", function(e) {
		confirmar();
		e.stopPropagation();
	});
	
	$(document).on("click", ".anular-link", function(e) {
		afiliadoAnular = {};
		$.each($(this).parent().parent().find('td'), function() {
			var field = $(this).attr('data-field');
        	var value = $(this).attr('data-value');
        	if(field !== undefined) {
        		if(value === undefined)
        			afiliadoAnular[field] = null;
        		else
        			afiliadoAnular[field] = value;
        	}
        });
		e.stopPropagation();
		$('#anular-modal').modal('show');
	});
	
	$(document).on("click", "#accept-anular", function() {
		$('#anular-modal').modal('hide');
		if(afiliadoAnular) {
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				url: "solicitudes/anular",
				data: JSON.stringify(afiliadoAnular), 
				dataType : "json",
				async: true,
				timeout : 100000,
				success : function(data) {
					var messageError;
					var messageSuccess;
					if(data.errorAnular === "999") {
						messageError = "ERROR: No se pudo anular el registro: " + data.registroID + " (" + data.messageErrorAnular + ")";
					} else {
						messageSuccess = "El registro fue anulado con &eacute;xito";
					}
					
					var htmlrow = '<td><label class="control control-checkbox">' +
		            '<input type="checkbox" class="afiliado-check" />' +
			        '<div class="control-indicator"></div>' +
			        '</label></td>';
					
					var keys = Object.keys(data);
					
					for(var i = 0; i < keys.length; i++){
						if(keys[i] !== 'errorConfirmar' && keys[i] !== 'messageErrorConfirmar' &&
								keys[i] !== 'errorAnular' && keys[i] !== 'messageErrorAnular') {
							var value = data[keys[i]];
					    
						    if(keys[i] === 'anular' && (data.estado === 'Pendiente' && data.anular === true))
								htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + "><a href='#' class='anular-link'>Anular</a></td>";
							else if(keys[i] === 'anular' && (data.estado !== 'Pendiente' || data.anular !== true))
								htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + "></td>";
							else if(keys[i] === 'fechaCarga' || keys[i] === 'fechaInicio' || keys[i] === 'fechaNacimiento') {
								var d = new Date(value);
								var dString = ('0' + d.getDate()).slice(-2) + '/' + ('0' + (d.getMonth()+1)).slice(-2) + '/' + d.getFullYear();
								htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + ">" + (value ? dString : "") + "</td>";
							} else {
								htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + ">" + (value ? value : "") + "</td>";
							}
						}
					}
					
					$('#table-preview tr[data-id="'+data.registroID+'"').html(htmlrow);
					 if(messageError) {
				    	$("#error-confirmar").html(messageError);
						$("#error-confirmar").show();
				    } else if(messageSuccess) {
				    	$("#success-confirmar").html(messageSuccess);
						$("#success-confirmar").show();
				    }
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}	
	});
	
	$(document).on("click", "#cancel-anular", function() {
		afiliadoAnular = {};
		$('#anular-modal').modal('hide');
		return false;
	});
	
	$(document).on("change", "#paginado", function() {
		paginado = $(this).val();
		
		$('#nav').remove();
		$('#content-table-child').after('<div id="nav" class="row pl-3"></div>');
		var rowsShown = 10;
		if(paginado)
			rowsShown = paginado;
	    
	    var rowsTotal = $('#table-preview tbody tr').length;
	    var numPages = rowsTotal/rowsShown;
	    $('#nav').append('<div id="nav-buttons"></div>');
	    for(i = 0;i < numPages;i++) {
	        var pageNum = i + 1;
	        $('#nav-buttons').append('<div><div><a class="btn" rel="'+i+'">'+pageNum+'</a></div></div>');
	    }
	    $('#nav').append('<div id="paginado-select"><div class="form-group"><select id="paginado" class="form-control"><option>10</option><option>50</option><option>100</option><option>1000</option></select></div></div>');
	    
	    $("#paginado").val(rowsShown);
	    $('#table-preview tbody tr').hide();
	    $('#table-preview tbody tr').slice(0, rowsShown).show();
	    
	    var currPage = 0;
        var startItem = currPage * rowsShown;
        var endItem = startItem + rowsShown;
        $('#table-preview tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
        css('display','table-row').animate({opacity:1}, 300);
        
	    $('#nav-buttons a').addClass('btn');
	    $('#nav-buttons a:first').addClass('btn btn-primary');
	    $('#nav-buttons a').bind('click', function(){
	        $('#nav-buttons a').removeClass('btn-primary');
	        $(this).addClass('btn-primary');
	        var currPage = $(this).attr('rel');
	        var startItem = currPage * rowsShown;
	        var endItem = startItem + rowsShown;
	        $('#table-preview tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
	        css('display','table-row').animate({opacity:1}, 300);
	    });
	});
	
	$(document).on("keyup", "#solicitudes-form input", function(e) {
		if (e.keyCode == 13) {
			search();
		}
	});
});

function search(){
	$("#error-table").hide();
		if(!validateForm()) {
			$("#error-date").show();
			return false;
		}
		
		$('#content-table').hide();
		$("#loading").show();
		var documentOptions = convertFormToJSON($("#solicitudes-form"));
		exportForm = documentOptions;
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: "solicitudes/buscar",
			data: JSON.stringify(documentOptions),
			dataType : "json",
			async: true,
			timeout : 100000,
			success : function(data) {
				$('#content-table').show();
				if(data && data.length > 0) {
					$(".checkbox-all").show();
					$("#check-all-afiliados")[0].checked = false;
					$("#loading").hide();
					$("#table-preview").show();
					$('#table-preview tbody').html("");
					$.each(data, function(key, card) {
						var htmlrow = '<tr data-id="'+card.registroID+'"><td><label class="control control-checkbox">' +
			            '<input type="checkbox" class="afiliado-check" />' +
				        '<div class="control-indicator"></div>' +
				        '</label></td>';
						
						var keys = Object.keys(card);
						
						for(var i = 0; i < keys.length; i++){
							if(keys[i] !== 'errorConfirmar' && keys[i] !== 'messageErrorConfirmar' &&
								keys[i] !== 'errorAnular' && keys[i] !== 'messageErrorAnular') {
							    var value = card[keys[i]];
							    
							    if(card.estado === 'Pendiente' && keys[i] === 'anular')
									htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + "><a href='#' class='anular-link'>Anular</a></td>";
								else if(card.estado !== 'Pendiente' && keys[i] === 'anular')
									htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + "></td>";
								else if(keys[i] === 'fechaCarga' || keys[i] === 'fechaInicio' || keys[i] === 'fechaNacimiento') {
									var d = new Date(value);
									var dString = ('0' + d.getDate()).slice(-2) + '/' + ('0' + (d.getMonth()+1)).slice(-2) + '/' + d.getFullYear();
									htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + ">" + (value ? dString : "") + "</td>";
								} else {
									htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + ">" + (value ? value : "") + "</td>";
								}
							}
						}
						
						htmlrow += "</tr>";
			            $('#table-preview tbody').append(htmlrow);
			        });
					
					$('#nav').remove();
					$('#content-table-child').after('<div id="nav" class="row pl-3"></div>');
					var rowsShown = 10;
					if(paginado)
						rowsShown = paginado;
				    var rowsTotal = $('#table-preview tbody tr').length;
				    var numPages = rowsTotal/rowsShown;
				    $('#nav').append('<div id="nav-buttons"></div>');
				    for(i = 0;i < numPages;i++) {
				        var pageNum = i + 1;
				        $('#nav-buttons').append('<div><div><a class="btn" rel="'+i+'">'+pageNum+'</a></div></div>');
				    }
				    $('#nav').append('<div id="paginado-select"><div class="form-group"><select id="paginado" class="form-control"><option>10</option><option>50</option><option>100</option><option>1000</option></select></div></div>');

				    $("#paginado").val(rowsShown);
				    $('#table-preview tbody tr').hide();
				    $('#table-preview tbody tr').slice(0, rowsShown).show();
				    
				    var currPage = 0;
			        var startItem = currPage * rowsShown;
			        var endItem = startItem + rowsShown;
			        $('#table-preview tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
			        css('display','table-row').animate({opacity:1}, 300);
			        
				    $('#nav-buttons a').addClass('btn');
				    $('#nav-buttons a:first').addClass('btn btn-primary');
				    $('#nav-buttons a').bind('click', function(){
				        $('#nav-buttons a').removeClass('btn-primary');
				        $(this).addClass('btn-primary');
				        var currPage = $(this).attr('rel');
				        var startItem = currPage * rowsShown;
				        var endItem = startItem + rowsShown;
				        $('#table-preview tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
				        css('display','table-row').animate({opacity:1}, 300);
				    });
				} else {
					$("#table-preview").hide();
					$("#loading").hide();
					$("#error-table").show();
					$(".checkbox-all").hide();
					$("#nav").hide();
				}
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
}

function exportar(){
	if(exportForm) {
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			url: "solicitudes/exportar",
			data: JSON.stringify(exportForm),
			dataType : "json",
			async: true,
			timeout : 100000,
			success : function(data) {

			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	} else {
		$("#error-confirmar").html($("#error-exportar").val());
		$("#error-confirmar").show();
		$("#success-confirmar").hide();
	}
}

function convertFormToJSON(form){
    var array = jQuery(form).serializeArray();
    var json = {};
    
    jQuery.each(array, function() {
        json[this.name] = this.value || '';
    });
    
    return json;
}

function confirmar() {
	var pendings = 0;
	var selected = $('#table-preview > tbody > tr .afiliado-check:checked').length;
	$.each($('#table-preview > tbody > tr .afiliado-check:checked'), function(){
		pendings += $(this).parent().parent().parent().children('td[data-value="Pendiente"]').length;
	}); 
	
	if((pendings > 0 || selected > 0) && pendings !== selected) {
		$("#error-confirmar").html($("#error-confirmar-input").val());
		$("#error-confirmar").show();
		$("#success-confirmar").hide();
		return false;
	} else if(selected === 0) {
		$("#error-confirmar").html($("#error-no-seleccionado").val());
		$("#error-confirmar").show();
		$("#success-confirmar").hide();
		return false;
	}
	
	var obj = [];
	$.each($('#table-preview > tbody > tr .afiliado-check:checked'), function(){
		index = 0;
	    if($(this).parent().parent().parent().children('td[data-value="Pendiente"]')) {
	    	var field;
	    	var value;
	        $td = $(this).parent().parent().parent().find('td');
	        var field = {};
	        $($td).each(function () {
	        	var row = $(this).attr('data-field');
	        	var value = $(this).attr('data-value');
	        	if(row !== undefined) {
	        		if(value === undefined)
	        			field[row] = null;
	        		else {
	        			field[row] = value;
	        		}
	        	}
	        });
	        obj.push(field);
	    }		
	});
	$.ajax({
		type: "POST",
		contentType : 'application/json',
		url: "solicitudes/confirmar", 
		data: JSON.stringify(obj),
		dataType : "json",
		async: true,
		timeout : 100000,
		success : function(data) {
			$("#loading").hide();
			$('#content-table').show();
			
			var messageError;
			var messageSuccess;
			$.each(data, function(key, card) {
				var htmlrow = '<td><label class="control control-checkbox">' +
	            '<input type="checkbox" class="afiliado-check" />' +
		        '<div class="control-indicator"></div>' +
		        '</label></td>';
				
				var keys = Object.keys(card);
				
				for(var i = 0; i < keys.length; i++){
					if(keys[i] !== 'errorConfirmar' && keys[i] !== 'messageErrorConfirmar' &&
							keys[i] !== 'errorAnular' && keys[i] !== 'messageErrorAnular') {
						var value = card[keys[i]];
				    
					    if(keys[i] === 'anular' && (card.estado === 'Pendiente' && card.anular === true))
							htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + "><a href='#' class='anular-link'>Anular</a></td>";
						else if(keys[i] === 'anular' && (card.estado !== 'Pendiente' || card.anular !== true))
							htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + "></td>";
						else if(keys[i] === 'fechaCarga' || keys[i] === 'fechaInicio' || keys[i] === 'fechaNacimiento') {
							var d = new Date(value);
							var dString = ('0' + d.getDate()).slice(-2) + '/' + ('0' + (d.getMonth()+1)).slice(-2) + '/' + d.getFullYear();
							htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + ">" + (value ? dString : "") + "</td>";
						} else {
							htmlrow += "<td data-field='" + keys[i] + "' " + (value ? "data-value='" + value + "' " : "") + ">" + (value ? value : "") + "</td>";
						}
					}
				}
				
				if(card.errorConfirmar === "999") {
					if(!messageError) {
						messageError = "ERROR: No se pudieron confirmar los siguientes registros: <br /><ul>";
					}
					messageError += "<li>" + card.registroID + ": " + card.messageErrorConfirmar + "</li>";
				} else {
					messageSuccess = "Los registros fueron confirmados con &eacute;xito.";
				}
				
				$('#table-preview tr[data-id="'+card.registroID+'"').html(htmlrow);
	        });
			
			if(messageError) {
				messageError += '</ul>';
			}
			
			$('#nav').remove();
			$('#content-table-child').after('<div id="nav" class="row pl-3"></div>');
		    var rowsShown = 10;
		    var rowsTotal = $('#table-preview tbody tr').length;
		    var numPages = rowsTotal/rowsShown;
		    $('#nav').append('<div id="nav-buttons"></div>');
		    for(i = 0;i < numPages;i++) {
		        var pageNum = i + 1;
		        $('#nav-buttons').append('<div><div><a class="btn" rel="'+i+'">'+pageNum+'</a></div></div>');
		    }
		    $('#nav').append('<div id="paginado-select"><div class="form-group"><select id="paginado" class="form-control"><option>10</option><option>50</option><option>100</option><option>1000</option></select></div></div>');

		    
		    $("#paginado").val(rowsShown);
		    $('#table-preview tbody tr').hide();
		    $('#table-preview tbody tr').slice(0, rowsShown).show();
		    
		    var currPage = 0;
	        var startItem = currPage * rowsShown;
	        var endItem = startItem + rowsShown;
	        $('#table-preview tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
	        css('display','table-row').animate({opacity:1}, 300);
	        
		    $('#nav-buttons a').addClass('btn');
		    $('#nav-buttons a:first').addClass('btn btn-primary');
		    $('#nav-buttons a').bind('click', function(){
		        $('#nav-buttons a').removeClass('btn-primary');
		        $(this).addClass('btn-primary');
		        var currPage = $(this).attr('rel');
		        var startItem = currPage * rowsShown;
		        var endItem = startItem + rowsShown;
		        $('#table-preview tbody tr').css('opacity','0.0').hide().slice(startItem, endItem).
		        css('display','table-row').animate({opacity:1}, 300);
		    });
		    
		    if(messageError) {
		    	$("#error-confirmar").html(messageError);
				$("#error-confirmar").show();
				$("#success-confirmar").hide();
		    } else if(messageSuccess) {
		    	$("#success-confirmar").html(messageSuccess);
				$("#success-confirmar").show();
				$("#error-confirmar").hide();
		    }
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});
}

function validateForm() {
	if(document.getElementById('fechaCarga').value !== null && document.getElementById('fechaCarga').value !== "" && !validateDate(document.getElementById('fechaCarga'))) {
		return false;
	}
	return true;
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