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
		         $('#txtMarcaVehiculo').val(ui.item.marca);
		         $('#txtModeloVehiculo').val(ui.item.modelo);
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