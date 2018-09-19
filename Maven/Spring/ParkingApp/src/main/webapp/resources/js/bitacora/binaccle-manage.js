// Obtener vistas a traves de GET
function getView(urlView) {
	$.ajax({
		type : "GET",
		url : urlView,
		success : function(resultado, status, xhr) {
			$('#divBinaccleManage').replaceWith(resultado);			
		},
		error : function(xhr, status, error) {
			console.log("ERROR: ", xhr);
			alert('Error when gettint view, status is: '+status);					
		},
		complete: function(xhresponse,status){
			//alert('Request Complete: '+status);
		}
	});		
}	
	
// Enviar datos a traves de POST
function ajaxPostBinnacleData(urlAction, serializedData) {
	$.ajax({
		type : "POST",
		url : urlAction,
		data : serializedData,
		success : function(resultado, status, xhr) {
			$('#divBinaccleManage').replaceWith(resultado);
		},
		error : function(xhr, status, error) {
			console.log("ERROR: ", xhr);
			alert('Error when sending values, status is: '+error);					
		},
		complete: function(xhresponse,status){
			//alert('Request Complete: '+status);
		}
	});		
}

function areThereEmptyFields(){
	var emptyFields = false;
	//var valor = $('#txtFechaSalida').val();
	//alert('El valor obtenido es: '+valor);
	//Evaluamos solo los campos del CheckIn
	if( $('#txtNoPlaca').val() == '' ){
		alert('No ha asignado ningun número de placa al ticket.');
		emptyFields = true;
	}
	else if( $('#txtFechaEntrada').val() == '' ){
		alert('Debe proporcionar la fecha de entrada antes de continuar.');
		emptyFields = true;
	}
	else if( $('#txtHoraEntrada').val() == '' ){
		alert('Debe proporcionar la hora de entrada antes de continuar.');
		emptyFields = true;
	}
	else if( $('#txtFechaSalida').val() != undefined && $('#txtFechaSalida').val() == '' ){
		alert('Debe proporcionar la fecha de salida antes de continuar.');
		emptyFields = true;
	}
	else if( $('#txtHoraSalida').val() != undefined && $('#txtHoraSalida').val() == '' ){
		alert('Debe proporcionar la hora de salida antes de continuar.');
		emptyFields = true;
	}
	return emptyFields;
}

// Inicialización de componentes
$(document).ready(function() { 		
	 $('#formPrincipalBitacora').submit(function() {
		 if(!areThereEmptyFields()){
			  ajaxPostBinnacleData(
	  			$(this).attr("action"),
	  			$(this).serialize()	
	  		  );
		 }
  		 return false;		   
	 });
	 
	 $('#txtBuscarNoPlaca').autocomplete({
	      source: function( request, response ) {
	        $.ajax({
	          type: "POST",
	          contentType: "application/json",
	          url: "bitacora/getVehiclesByCriteria",		          
	          dataType: "json",
	          data: JSON.stringify({
	        	  vehiculo: {
	        			noPlaca: request.term,
	        			"@type": "Vehiculo"
	        		},
	        	  enableLike: true		           
	          }),
	          success: function( responseBody ) {
	        	  try{
	        		  console.log( responseBody.listaVehiculos );
	        		 response(
	        		       $.map(responseBody.listaVehiculos, function (vehiculo) {                                
                            var item = new Object();

                            //autocomplete default values REQUIRED
                            item.label = vehiculo.noPlaca;
                            //item.value = vehiculo.noPlaca;
                           
                            //extend values
                            item.noPlaca = vehiculo.noPlaca;
                            item.marca = vehiculo.marca;
                            item.modelo = vehiculo.modelo;
                            item.tipoVehiculo = vehiculo.tipoVehiculo;                           

                            return item;
	        		       }));        		
	        	  }catch (e) {
					alert('Error al leer los datos obtenidos');
					console.log(e);
				}
	          }
	        });
	      },
	      minLength: 3,
	      select: function( event, ui ) {
	       /* alert( ui.item ?
	          "Selected: " + ui.item.label :
	          "Nothing selected, input was " + this.value); */ 
	         $('#txtNoPlaca').val(ui.item.noPlaca);
	         $('#txtMarcaVehiculo').val(ui.item.modelo.marca.marca);
	         $('#txtModeloVehiculo').val(ui.item.modelo.modelo);
	         if( String(ui.item.tipoVehiculo).valueOf() == String('O').valueOf() )
	         	$('#txtTipoVehiculo').val('Oficial');
	         else if( String(ui.item.tipoVehiculo).valueOf() == String('N').valueOf() )
	        	 $('#txtTipoVehiculo').val('Normal');
	         else
	        	 $('#txtTipoVehiculo').val(ui.item.marca);
	      },
	      open: function() {
	        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
	      },
	      close: function() {
	        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
	      }
	    });
});