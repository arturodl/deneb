<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
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

<div class="container">
    
	<c:if test="${mostrarFormulario}">
	  <c:url var="agregarRegistro" value="/bitacora/ejecutar" ></c:url>
	  <form:form action="${agregarRegistro}" modelAttribute="registro" method="POST">
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
					<c:if test="${registro.idRegistro == 0}">
						<input type="submit" value="<spring:message text="Asignar Entrada"/>" class="btn btn-primary"/>
					</c:if>
					<c:if test="${registro.idRegistro > 0}">
						<input type="submit" value="<spring:message text="Asignar Salida"/>" class="btn btn-primary"/>
					</c:if>		
					<!--  <a class="btn btn-primary" href="todoregistros" role="button">Ver Listado</a>  -->		
				</td>			
				<td>
					<a class="btn btn-primary" href="<c:url value='/index' />" role="button">Regresar</a>
				</td>
			</tr>		
		</table>	
	  </form:form>
	</c:if>

  <c:if test="${mostrarResumenBitacora}">
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
			</tr>
		</c:forEach>
	</table>
  </c:if>
  <hr>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

</body>
</html>