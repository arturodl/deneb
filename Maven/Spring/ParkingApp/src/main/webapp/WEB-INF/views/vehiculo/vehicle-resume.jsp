<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  
<!DOCTYPE html>
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
    <h5>Listado de Vehiculo</h5>
	<p>
		<h6> Bienvenidos al Listado de Vehiculos </h6> 
		<h5 style="color:red"> ${mensaje}</h5>
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
				$('#divListadoVehiculos').replaceWith(resultado);
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
</script>


<div id="divListadoVehiculos" class="container">
  <!-- <h5>Lista de Vehiculos</h5> -->
  	<a class="btn btn-primary" style="font-size: 14px;" href="#" role="button" onclick="getView('<c:url value='/vehiculo/agregar' />');" >Agregar</a>
	<div class="table-responsive">
	  <table class="table table-striped table-sm">
	  	<thead>
			<tr>
				<th width="80">Id Vehiculo</th>
				<th width="80">Tipo Vehiculo</th>
				<th width="120">No. Placa</th>
				<th width="120">Modelo</th>
				<th width="60">Marca</th>
				<th width="60">Fecha de Alta</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaVehiculos}" var="vehiculo">
				<tr>
					<td>${vehiculo.idVehiculo}</td>
					<td>					
						${vehiculo.tipoVehiculo == 'O'? 'Oficial': vehiculo.tipoVehiculo == 'R'? 'Residente': vehiculo.tipoVehiculo == 'N'? 'No Residente':'Valor sin registrar'}
					</td>
					<td>${vehiculo.noPlaca}</td>
					<td>${vehiculo.modelo}</td>
					<td>${vehiculo.marca}</td>					
					<td>${vehiculo.fechaAlta}</td>
					<td><a href="#" onclick="getView('<c:url value='/vehiculo/editar/${vehiculo.idVehiculo}' />');" >Editar</a></td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>	
  <hr/>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

<!--
</body>
</html> -->