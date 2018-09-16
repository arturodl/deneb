<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="<c:url value="/resources/js/bitacora/binaccle-resume.js" />"> </script>

<div id="divResumenBitacora" class="container">
  <a class="btn btn-primary" style="font-size: 14px;" href="#" role="button" onclick="getView('<c:url value='/bitacora/agregar' />');" >Check in</a>
	<div class="table-responsive">
	  <table class="table table-striped table-sm">
	  	<thead>
		<tr>
			<th width="60">Folio</th>
			<th width="60">Vehiculo</th>
			<th width="60">Fecha Entrada</th>
			<th width="60">Hora Entrada</th>
			<th width="60">Fecha Salida</th>			
			<th width="60">Hora Salida</th>
			<th width="80">Status</th>	
			<th width="80">Acción</th>			
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listaRegistros}" var="registro">
			<tr>
				<td><b>${registro.idRegistro}</b></td>
				<td>${registro.vehiculo.noPlaca}</td>
				<td>${registro.fechaEntrada}</td>
				<td>${registro.horaEntrada}</td>
				<td>${registro.fechaSalida}</td>				
				<td>${registro.horaSalida}</td>
				<td><b>${registro.status == 'I'? 'Checked In': registro.status == 'O'? 'Checked Out': 'Unknown' }</b></td>	
				<td>					
				<c:if test="${registro.status == 'I'}">
					<a href="#" onclick="getView('<c:url value='/bitacora/editar/${registro.idRegistro}' />')" >Check Out</a>
				</c:if>
				</td>
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