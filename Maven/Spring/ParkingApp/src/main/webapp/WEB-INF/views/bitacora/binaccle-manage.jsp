<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%! String classDisabled = null; %>

<!--  <!DOCTYPE html>
<html lang="en">

<head>
	<title>Parking Application by Arct-Applications</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>

<nav class="navbar navbar-inverse navbar-fixed-top" style="background: #212529">
  <div class="container">
	<div class="navbar-header">
		<p style="color:white; font-size: 15px;">Parking Application</p>
	</div>
  </div>
</nav>

<div class="jumbotron">
  <div class="container">
    <h5>Registro de Entradas y Salidas de Vehiculos</h5>
	<p>
		<h6> ${bienvenida} </h6> 
		<h5 style="color:blue;"> ${success}</h5>
		<h5 style="color:red;"> ${error}</h5>
		
	</p>   
  </div>
</div>
 -->
 
<style>
.default-font-size{
	font-size: 14px;
}

.background-disabled{
	background: #dddddd;
}
</style>

<div id="divBinaccleManage" class="container">
	<% classDisabled = (String)request.getAttribute("class-disabled"); %>
    <div id="divMensajesVehiculos">
	  	<h6 style="color:blue;"> ${success}</h6>
		<h6 style="color:red;"> ${error}</h6>
    </div>  
	<c:if test="${mostrarFormulario}">
	  <c:url var="ejecutar" value="/bitacora/ejecutar" ></c:url>
	  <form:form id="formPrincipalBitacora" action="${ejecutar}" modelAttribute="registro" method="POST">
		<table>		
			<c:if test="${captureCheckIn}">
			   	<tr>
					<td>
						<label>Buscar No. Placa</label>
					</td>
					<td>
					   	<input id="txtBuscarNoPlaca" class="form-control default-font-size" placeholder="Tecla el numero de placa" />				   
					</td> 
				</tr>
			</c:if>
			<tr>
				<td>
					<form:label path="vehiculo.noPlaca">
						<spring:message text="No. Placa Seleccionada"/>
					</form:label>
				</td>
				<td>
				    <form:hidden path="idRegistro"/>
				   	<form:input id="txtNoPlaca" path="vehiculo.noPlaca" cssClass="form-control background-disabled default-font-size" readonly="true" 
				   		placeholder="Sin información" />				   
				</td> 
			</tr>
			<tr>
				<td>
					<label>Marca</label>
				</td>
				<td>
					<form:input id="txtMarcaVehiculo" path="vehiculo.marca" cssClass="form-control background-disabled default-font-size" readonly="true"
						placeholder="Sin información"/>
				</td> 
			</tr>
			<tr>
				<td>
					<label>Modelo</label>
				</td>
				<td>
					<form:input id="txtModeloVehiculo" path="vehiculo.modelo" cssClass="form-control background-disabled default-font-size" readonly="true"
						placeholder="Sin información"/>
				</td> 
			</tr>
			<tr>
				<td>
					<label>Tipo Vehiculo</label>
				</td>
				<td>
					<input id="txtTipoVehiculo" class="form-control background-disabled default-font-size" readonly="true" type="text"
						value="${registro.vehiculo.tipoVehiculo=='O'? 'Oficial': registro.vehiculo.tipoVehiculo=='N'? 'Normal': registro.vehiculo.tipoVehiculo=='P'? 'Particular': 'Sin Información'}" 
							/>
				</td> 
			</tr>
			<c:if test="${captureCheckIn}">
				<tr>
					<td>
						<form:label path="fechaEntrada">
							<spring:message text="Fecha de Entrada"/>
						</form:label>
					</td>
					<td>
						<form:input path="fechaEntrada" cssClass="form-control default-font-size" />					
					</td> 
				</tr>
				<tr> 
					<td>
						<form:label path="horaEntrada">
							<spring:message text="Hora de Entrada"/>
						</form:label>
					</td>
					<td>
						<form:input path="horaEntrada" cssClass="form-control default-font-size " />
					</td>
				</tr>
			</c:if>
			<c:if test="${captureCheckOut}">
				<tr>
					<td>
						<form:label path="fechaEntrada">
							<spring:message text="Fecha de Entrada"/>
						</form:label>
					</td>
					<td>
						<form:input path="fechaEntrada" cssClass="form-control default-font-size background-disabled" readonly="true"/>					
					</td> 
				</tr>
				<tr> 
					<td>
						<form:label path="horaEntrada">
							<spring:message text="Hora de Entrada"/>
						</form:label>
					</td>
					<td>
						<form:input path="horaEntrada" cssClass="form-control default-font-size background-disabled" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="fechaSalida">
							<spring:message text="Fecha de Salida"/>
						</form:label>
					</td>
					<td>
						<form:input  path="fechaSalida" cssClass="form-control default-font-size" />
					</td> 
				</tr>
				<tr>
					<td>
						<form:label path="horaSalida">
							<spring:message text="Hora de Salida"/>
						</form:label>
					</td>
					<td>
						<form:input  path="horaSalida" cssClass="form-control default-font-size" />
					</td> 
				</tr>
			</c:if>
			<tr>
				<td>
				</td>
				<td>
					<p><button type="submit" class="btn btn-primary default-font-size" 
						 	<c:if test="${disableBtnExecute}">
								disabled
							</c:if>
						>
							<c:if test="${captureCheckIn}">
								Registrar Entrada
							</c:if>
							<c:if test="${captureCheckOut}">
								Registrar Salida
							</c:if>		
						</button>
						<a class="btn btn-primary default-font-size" href="#" role="button" onclick="getView('<c:url value='/bitacora/resumen' />');">Regresar</a>
					</p>							
				</td>						
			</tr>		
		</table>	
	  </form:form>
	</c:if>

  <hr>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

<script>
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
</script>
	


<!-- 
</body>
</html>    -->