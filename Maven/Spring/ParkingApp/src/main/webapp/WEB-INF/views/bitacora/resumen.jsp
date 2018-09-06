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
    <h5>Resumen de Bitacoras</h5>
	<p>
		<h6> Bienvenidos al Resumen de Entradas y Salidas </h6> 
		<h5 style="color:red"> ${mensaje}</h5>
	</p>   
  </div>
</div>

<div class="container">
  <h5>Lista de Registros</h5>
	<table class="tg">
		<tr>
			<th width="80">Id Registro</th>
			<th width="120">Fecha Entrada</th>
			<th width="120">Fecha Salida</th>
			<th width="60">Hora Entrada</th>
			<th width="60">Hora Salida</th>
			<th width="60">Vehiculo</th>
		</tr>
		<c:forEach items="${listaRegistros}" var="registro">
			<tr>
				<td>${registro.idRegistro}</td>
				<td>${registro.fechaEntrada}</td>
				<td>${registro.fechaSalida}</td>
				<td>${registro.horaEntrada}</td>
				<td>${registro.horaSalida}</td>					
				<td>${registro.vehiculo.noPlaca}</td>
				<c:if test="${mostrarEditar}">
					<td><a href="<c:url value='/bitacora/mostrarRegistro/${registro.idRegistro}' />" >Editar</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="<c:url value="/index" />" role="button">Regresar</a>
  <hr>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

</body>
</html>