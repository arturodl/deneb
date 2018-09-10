<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--   <!DOCTYPE html>
<html lang="en">

<head>
	<title>Parking Application by Arct-Applications</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
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
    <h5>Registro de Vehiculos</h5>
	<p>
		<h6> ${bienvenida} </h6> 
		<h5 style="color:blue;"> ${success}</h5>
		<h5 style="color:red;"> ${error}</h5>
		
	</p>   
  </div>
</div>

-->

<script type="text/javascript">

	function getView(urlView) {
		$.ajax({
			type : "GET",
			//contentType : "application/json",
			url : urlView,
			success : function(resultado, status, xhr) {
				$('#divGestionVehiculos').replaceWith(resultado);
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

	function postVehicles(urlAction, serializedData) {
		$.ajax({
			type : "POST",
			//contentType : "application/json",
			url : urlAction,
			data : serializedData,
			success : function(resultado, status, xhr) {
				$('#divGestionVehiculos').replaceWith(resultado);
				$('html, body').animate({ scrollTop: $("#divMensajesVehiculos").offset().top }, 500);
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
		 $('#formPrincipalVehiculo').submit(function() {
			  // alert('Entrando a Vehiculo');
	  		  postVehicles(
	  			$(this).attr("action"),
	  			$(this).serialize()	
	  		  );
	  		  return false;		   
		});
	});
</script> 

<script type="text/javascript"> /*
		$(document).ready(function() {
			$("#formPrincipalVehiculo").submit(function() {  
				alert('Entrando');
				$.post($(this).attr("action"), $(this).serialize(), function(html) {
					$("#divGestionVehiculos").replaceWith(html);
					$('html, body').animate({ scrollTop: $("#message").offset().top }, 500);
				});
				return false;  
			});			
		}); */
</script>

<div id="divGestionVehiculos" class="container">    
  <c:url var="gestionarVehiculo" value="/vehiculo/ejecutar" ></c:url>
  <div id="divMensajesVehiculos">
  	<h6 style="color:blue;"> ${success}</h6>
	<h6 style="color:red;"> ${error}</h6>
  </div>  
  <form:form id="formPrincipalVehiculo" action="${gestionarVehiculo}" modelAttribute="vehiculo" method="POST">
	<table>
		<c:if test="${vehiculo.idVehiculo > 0}">
		    <tr>
				<td>
					<form:label path="idVehiculo">
						<spring:message text="Id Vehiculo"/>
					</form:label>
				</td>
				<td>
				    <form:input path="idVehiculo" cssClass="form-control" />
				</td> 
			</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="tipoVehiculo">
					<spring:message text="Tipo de Vehiculo"/>
				</form:label>
			</td>
			<td>
				<form:select path="tipoVehiculo" cssClass="btn btn-secondary dropdown-toggle" cssStyle="font-size: 14px;">
				   <form:option value="" label="Seleccione una opcion" cssClass="dropdown-item"/>
				   <form:option value="O" label="Oficial" />
				   <form:option value="R" label="Residente" />
				   <form:option value="N" label="No Residente" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="noPlaca">
					<spring:message text="Número de Placa"/>
				</form:label>
			</td>
			<td>
			   	<form:input  path="noPlaca" cssClass="form-control" />
			</td> 
		</tr>
		<tr>
			<td>
				<form:label path="modelo">
					<spring:message text="Modelo"/>
				</form:label>
			</td>
			<td>
				<form:input  path="modelo" cssClass="form-control" />
			</td> 
		</tr>
		<tr>
			<td>
				<form:label path="marca">
					<spring:message text="Marca"/>
				</form:label>
			</td>
			<td>
				<form:input path="marca" cssClass="form-control"/>
			</td>
		</tr>
		
		<tr>
			<td>
				<form:label path="fechaAlta">
					<spring:message text="Fecha de Alta"/>
				</form:label>
			</td>
			<td>
				<form:input path="fechaAlta" cssClass="form-control"/>
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<p><button type="submit" class="btn btn-primary">
					<c:if test="${vehiculo.idVehiculo == 0}">
						Agregar
					</c:if>
					<c:if test="${vehiculo.idVehiculo > 0}">
						Modificar
					</c:if>					
				   </button>	
				   <a class="btn btn-primary" href="#" role="button" onclick="getView('<c:url value='/vehiculo/listado' />');">Regresar</a>			   
				</p>				
			</td>				
		</tr>		
	</table>	
  </form:form>
  
	
  <hr>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

<!-- 
</body>
</html>

 -->