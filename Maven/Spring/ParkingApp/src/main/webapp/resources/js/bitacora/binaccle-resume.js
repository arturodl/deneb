function getView(urlView) {
	$.ajax({
		type : "GET",
		url : urlView,
		success : function(resultado, status, xhr) {
			$('#divResumenBitacora').replaceWith(resultado);
		},
		error : function(xhr, status, error) {
			console.log("ERROR: ", xhr);
			alert('Error when getting view, error is: '+error);					
		},
		complete: function(xhresponse,status){
			//alert('Request Complete: '+status);
		}
	});		
}		