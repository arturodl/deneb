<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
 
<script type="text/javascript">
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
	});
</script>
 
<div id="divBinaccleManage" class="container">
    <div id="divMensajesVehiculos">
	  	<h6 style="color:blue;"> ${success}</h6>
		<h6 style="color:red;"> ${error}</h6>
    </div>  
	<c:if test="${mostrarFormulario}">
	  <c:url var="ejecutar" value="/bitacora/ejecutar" ></c:url>
	  <form:form id="formPrincipalBitacora" action="${ejecutar}" modelAttribute="registro" method="POST">
		<table>
			<c:if test="${registro.idRegistro > 0}">
			    <tr>
					<td>
						<form:label path="idRegistro">
							<spring:message text="Id Registro"/>
						</form:label>
					</td>
					<td>
					    <form:input path="idRegistro" cssClass="form-control" />
					</td> 
				</tr>
			</c:if>
			<tr>
				<td>
					<form:label path="vehiculo.noPlaca">
						<spring:message text="Número de Placa"/>
					</form:label>
				</td>
				<td>
				   	<form:input  path="vehiculo.noPlaca" cssClass="form-control" />
				</td> 
			</tr>
			<tr>
				<td>
					<form:label path="fechaEntrada">
						<spring:message text="Fecha de Entrada"/>
					</form:label>
				</td>
				<td>
					<form:input  path="fechaEntrada" cssClass="form-control" />
				</td> 
			</tr>
			<tr>
				<td>
					<form:label path="horaEntrada">
						<spring:message text="Hora de Entrada"/>
					</form:label>
				</td>
				<td>
					<form:input path="horaEntrada" cssClass="form-control"/>
				</td>
			</tr>
			<c:if test="${registro.idRegistro > 0}">
				<tr>
					<td>
						<form:label path="fechaSalida">
							<spring:message text="Fecha de Salida"/>
						</form:label>
					</td>
					<td>
						<form:input  path="fechaSalida" cssClass="form-control" />
					</td> 
				</tr>
				<tr>
					<td>
						<form:label path="horaSalida">
							<spring:message text="Hora de Salida"/>
						</form:label>
					</td>
					<td>
						<form:input  path="horaSalida" cssClass="form-control" />
					</td> 
				</tr>
			</c:if>
			<tr>
				<td>
				</td>
				<td>
					<p><button type="submit" class="btn btn-primary">
							<c:if test="${registro.idRegistro == 0}">
								Registrar Entrada
							</c:if>
							<c:if test="${registro.idRegistro > 0}">
								Registrar Salida
							</c:if>		
						</button>
						<a class="btn btn-primary" href="#" role="button" onclick="getView('<c:url value='/bitacora/resumen' />');">Regresar</a>
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

<!-- 
</body>
</html>    -->