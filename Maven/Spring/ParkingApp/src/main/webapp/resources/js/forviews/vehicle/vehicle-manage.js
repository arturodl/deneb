function getView(urlView) {
	$.ajax({
		type : "GET",
		url : urlView,
		success : function(resultado, status, xhr) {
			$('#divGestionVehiculos').replaceWith(resultado);
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

function postVehicles(urlAction, serializedData) {
	$.ajax({
		type : "POST",
		url : urlAction,
		data : serializedData,
		success : function(resultado, status, xhr) {
			$('#divGestionVehiculos').replaceWith(resultado);				
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

function areThereEmptyFields(){
	var emptyFields = false;     
	if( $('#txtNoPlaca').val() == '' ){
		alert('Debe de proporcionar un número de placa.');
		emptyFields = true;
	}
	else if( $('#selectMarca').val() == -1 ){
		alert('Debe seleccionar una marca antes de continuar.');
		emptyFields = true;
	}
	else if( $('#selectModelo').val() == -1 ){
		alert('Debe seleccionar un modelo antes de continuar.');
		emptyFields = true;
	}
	else if( $('#txtFechaAlta').val() == '' ){
		alert('Debe proporcionar la fecha de alta antes de continuar.');
		emptyFields = true;
	}
	else if( $('#selectTipoVehiculo').val() == '' ){
		alert('Debe seleccionar un tipo de vehiculo antes de continuar.');
		emptyFields = true;
	}
	return emptyFields;
}

$(document).ready(function() { 		
	 $('#formPrincipalVehiculo').submit(function() {
		  if( !areThereEmptyFields() ){
	  		  postVehicles(
	  			$(this).attr("action"),
	  			$(this).serialize()	
	  		  );
		  }
  		  return false;		   
	});
	 
	$('#selectModelo').change(function() {
		//	var idModelo = $(this).val();
		//	$('#hiddenIdModelo').val(idModelo);
	});
	
	$('#selectMarca').change(function() {
		$.ajax({
	          type: "POST",
	          contentType: "application/json",
	          url: "modelo/getModelsByCriteria",		          
	          dataType: "json",
	          data: JSON.stringify({
	        	  modelo: {
	        			marca: { 
	        				idMarca: $(this).val()
	        			},
	        			"@type": "Modelo"
	        		},
	        	  enableLike: true		           
	          }),
	          success: function( responseBody ) {
	        	 var listaModelos, selectModelos, modelo, longLista;
	        	 
	        	 selectModelos = $('#selectModelo');
	        	 selectModelos[0].options.length = 0;
	        	 
	        	 listaModelos = responseBody.listaModelos;
	        	 longLista = listaModelos.length;
	        	 if(longLista <= 0)
	        		selectModelos[0].options.add(new Option('Sin opciones', -1));
	        	 else	        		 
	        	  	selectModelos[0].options.add(new Option('Seleccione una opción', -1));
	        	 
	        	 for (index = 0; index < longLista; ++index) {
	        	      modelo = listaModelos[index];
	        	      selectModelos[0].options.add(new Option(modelo.modelo, modelo.idModelo));
	        	 }
	          }
	    });
	});
});