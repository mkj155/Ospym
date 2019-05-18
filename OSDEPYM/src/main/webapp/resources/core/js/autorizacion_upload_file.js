var uploadFiles = new Object(); 
var index = 0;
$(document).ready(function(readyEvent) {
  $(document).on('click', '.close', function(closeEvent) {
	var elem = $(this).parents('span');
	var idElem = $(elem).attr('id');
	$("#input_" + idElem).remove();
    $(elem).remove();
    var fileInput = $('#uploadFile')[0];
    var files = fileInput.files;
    var id = closeEvent.target.id;
    var index = closeEvent.target.id.replace('file_','');
    
    if (!$(".filenameupload")[0]){
    	$("#message-upload-file").next().remove();
    } 
    
    delete uploadFiles[$(this).parent().attr('id')];
    var totalSize = 0;
    Object.keys(uploadFiles).forEach(function(key) {
    	totalSize += uploadFiles[key].size;
    });
    
    if(totalSize === 0)
    	$('#total_size').html('');
    else
    	$('#total_size').html(formatBytes(totalSize,0));
    console.log('files: ',files);
  })

  $('#uploadFile').on('change', function(changeEvent) {
    var filename = this.value;
    var lastIndex = filename.lastIndexOf("\\");
    if (lastIndex >= 0) {
      filename = filename.substring(lastIndex + 1);
    }
        
    var fileInput = $('#uploadFile')[0];
    var filesExist = fileInput.files;
    
    var filesU = changeEvent.target.files;
    
    for (var i = 0; i < filesU.length; i++) {
    	var exist = false;
    	Object.keys(uploadFiles).forEach(function(key) {
    		if(uploadFiles[key].name === filesU[i].name && uploadFiles[key].size === filesU[i].size)
    			exist = true;
    	});
    	
    	if(!exist) {
	    	$("#upload_prev").append('<span class="filenameupload" id="file_'+index+'">' + filesU[i].name + ' ('+ formatBytes(filesU[i].size,0) +')<span class="close">&times;</span><br/></span>');
	    	uploadFiles['file_'+index] = filesU[i];
	      
	    	var inputClone = $( "#uploadFile" ).clone();
		    inputClone.attr('id', 'input_file_'+index);
		    inputClone.appendTo( "#file-container" );
		    index++;
    	}
    }
    
    if ($(".filenameupload")[0]){
    	if($("#message-upload-file").next("hr").length == 0) 
    		$("#message-upload-file").after('<hr />');
    }
    
    var totalSize = 0;
    
    Object.keys(uploadFiles).forEach(function(key) {
    	totalSize += uploadFiles[key].size;
    });
    
    $('#total_size').html(formatBytes(totalSize,0));
  });
  
  $('#buttonUploadFile').on('click', function() {
	  var fileSelector = document.getElementById('uploadFile');
	  fileSelector.click();
       return false;	
  });
});

function formatBytes(a,b){if(0==a)return"0 Bytes";var c=1024,d=b||2,e=["Bytes","KB","MB","GB","TB","PB","EB","ZB","YB"],f=Math.floor(Math.log(a)/Math.log(c));return parseFloat((a/Math.pow(c,f)).toFixed(d))+" "+e[f]}