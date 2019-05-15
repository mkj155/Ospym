var uploadFiles = new Object(); 
var index = 0;
$(document).ready(function(readyEvent) {
  $(document).on('click', '.close', function(closeEvent) {
    $(this).parents('span').remove();
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
    //this is not possible, since the FileList is read-only
    //files[index].remove();
    //files = Array.prototype.splice.call(files,closeEvent.target.id.replace('file_',''),1);
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
    
    var files = changeEvent.target.files;
    
    for (var i = 0; i < files.length; i++) {
      $("#upload_prev").append('<span class="filenameupload" id="file_'+index+'">' + files[i].name + ' ('+ formatBytes(files[i].size,0) +')<span class="close">&times;</span><br/></span>');
      uploadFiles['file_'+index] = files[i];
      index++;
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