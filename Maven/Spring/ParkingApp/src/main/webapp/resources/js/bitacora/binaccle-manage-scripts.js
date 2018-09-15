function getView(urlView) {
		$.ajax({
			type : "GET",
			//contentType : "application/json",
			url : urlView,
			success : function(resultado, status, xhr) {
				$('#divBinaccleManage').replaceWith(resultado);
				//$('html, body').animate({ scrollTop: $("#divMensajesVehiculos").offset().top }, 500);
			},
			error : function(xhr, status, error) {
				console.log("ERROR: ", xhr);
				alert('Error, status is: '+status);					
			},
			complete: function(xhresponse,status){
				//alert('Request Complete: '+status);
			}
		});		
	}	
	
	function ajaxPostBinnacleData(urlAction, serializedData) {
		$.ajax({
			type : "POST",
			//contentType : "application/json",
			url : urlAction,
			data : serializedData,
			success : function(resultado, status, xhr) {
				$('#divBinaccleManage').replaceWith(resultado);
				//$('html, body').animate({ scrollTop: $("#divMensajesVehiculos").offset().top }, 500);
			},
			error : function(xhr, status, error) {
				console.log("ERROR: ", xhr);
				alert('Error, status is: '+status);					
			},
			complete: function(xhresponse,status){
				//alert('Request Complete: '+status);
			}
		});		
	}

	$(document).ready(function() { 		
		 $('#formPrincipalBitacora').submit(function() {
			  // alert('Entrando a Vehiculo');
	  		  ajaxPostBinnacleData(
	  			$(this).attr("action"),
	  			$(this).serialize()	
	  		  );
	  		  return false;		   
		 });
		 
		 $('#txtNoPlaca').autocomplete('disable');
	});