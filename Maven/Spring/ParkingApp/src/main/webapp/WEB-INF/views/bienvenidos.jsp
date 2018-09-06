<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Parking Application by Arct-Applications</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/bootstrap.min.js" />" > </script>
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
	<p>	
	   <h6> ${bienvenida} </h6>
    </p>   
  </div>
</div>

<div class="container">
  <div class="row">
	<div class="col-md-4">
		<p>Bitacora</p>
		<ul>
			<li> <a class="btn btn-default" href="regentrada" role="button">Registrar Entrada</a> </li>
			<li> <a class="btn btn-default" href="regsalida" role="button">Registrar Salida</a> </li>
			<li> <a class="btn btn-default" href="resumen" role="button">Ver Resumen</a> </li>	
		</ul>
	</div>
	<div class="col-md-4">
		<p>Vehiculos</p>
		<ul>
			<li> <a class="btn btn-default" href="registrarvehiculo" role="button">Agregar Vehiculo</a> </li>
			<li> <a class="btn btn-default" href="#" role="button">Modificar Vehiculo</a> </li>
			<li> <a class="btn btn-default" href="listadovehiculo" role="button">Ver Lista de Vehiculos</a> </li>
		</ul>
	</div>
	<div class="col-md-4">
		<p>Usuario</p>
		<ul>
			<li><a class="btn btn-default" href="#" role="button">Agregar Usuario</a></li>
			<li><a class="btn btn-default" href="#" role="button">Modificar Usuario</a> </li>
			<li><a class="btn btn-default" href="#" role="button">Eliminar Usuario</a> </li>
		</ul>
	</div>
  </div>

  <hr>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

</body>
</html>