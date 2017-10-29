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
    <h5>Registro de Vehiculos</h5>
	<p>
		<h6> ${bienvenida} </h6> 
		<h5 style="color:blue;"> ${success}</h5>
		<h5 style="color:red;"> ${error}</h5>
		
	</p>   
  </div>
</div>

<div class="container">    
  <c:url var="gestionarVehiculo" value="/gestionarvehiculo" ></c:url>
  <form:form action="${gestionarVehiculo}" modelAttribute="vehiculo" method="POST">
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
				<c:if test="${vehiculo.idVehiculo == 0}">
					<input type="submit" value="<spring:message text="Agregar Vehiculo"/>" class="btn btn-primary"/>
				</c:if>
				<c:if test="${vehiculo.idVehiculo > 0}">
					<input type="submit" value="<spring:message text="Modificar Vehiculo"/>" class="btn btn-primary"/>
				</c:if>		
				<!--  <a class="btn btn-primary" href="todoregistros" role="button">Ver Listado</a>  -->		
			</td>			
			<td>
				<a class="btn btn-primary" href="<c:url value='/index' />" role="button">Regresar</a>
			</td>
		</tr>		
	</table>	
  </form:form>
	
  <hr>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

</body>
</html>