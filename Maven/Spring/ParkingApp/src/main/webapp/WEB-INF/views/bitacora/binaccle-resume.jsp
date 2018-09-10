<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function getView(urlView) {
		$.ajax({
			type : "GET",
			//contentType : "application/json",
			url : urlView,
			success : function(resultado, status, xhr) {
				$('#divResumenBitacora').replaceWith(resultado);
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

<div id="divResumenBitacora" class="container">
  <a class="btn btn-primary" style="font-size: 14px;" href="#" role="button" onclick="getView('<c:url value='/bitacora/agregar' />');" >Check in</a>
	<div class="table-responsive">
	  <table class="table table-striped table-sm">
	  	<thead>
		<tr>
			<th width="80">Id Registro</th>
			<th width="60">Vehiculo</th>
			<th width="120">Fecha Entrada</th>
			<th width="60">Hora Entrada</th>
			<th width="120">Fecha Salida</th>			
			<th width="60">Hora Salida</th>			
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listaRegistros}" var="registro">
			<tr>
				<td>${registro.idRegistro}</td>
				<td>${registro.vehiculo.noPlaca}</td>
				<td>${registro.fechaEntrada}</td>
				<td>${registro.horaEntrada}</td>
				<td>${registro.fechaSalida}</td>				
				<td>${registro.horaSalida}</td>					
				<c:if test="${mostrarEditar}">
					<td><a href="#" onclick="getView('<c:url value='/bitacora/editar/${registro.idRegistro}' />')" >Check Out</a></td>
				</c:if>
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