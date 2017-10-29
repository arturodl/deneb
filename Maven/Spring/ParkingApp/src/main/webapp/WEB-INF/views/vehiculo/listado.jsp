<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<div class="container">
  <h5>Lista de Vehiculos</h5>
	<table class="tg">
		<tr>
			<th width="80">Id Vehiculo</th>
			<th width="80">Tipo Vehiculo</th>
			<th width="120">No. Placa</th>
			<th width="120">Modelo</th>
			<th width="60">Marca</th>
			<th width="60">Fecha de Alta</th>			
		</tr>
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
				<c:if test="${mostrarEditar}">
					<td><a href="<c:url value='/mostrarVehiculo/${vehiculo.idRegistro}' />" >Editar</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="<c:url value='/index' />" role="button">Regresar</a>
  <hr>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

</body>
</html>