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
				<th width="60">Id</th>
				<th width="60">Placa</th>
				<th width="60">Marca</th>
				<th width="60">Modelo</th>
				<th width="60">Tipo</th>
				<th width="60">Fecha de Alta</th>			
				<th width="80">Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaVehiculos}" var="vehiculo">
				<tr>
					<td>${vehiculo.idVehiculo}</td>					
					<td>${vehiculo.noPlaca}</td>
					<td>${vehiculo.modelo.marca.marca}</td>	
					<td>${vehiculo.modelo.modelo}</td>						
					<td>					
						${vehiculo.tipoVehiculo == 'O'? 'Oficial': vehiculo.tipoVehiculo == 'P'? 'Particular': vehiculo.tipoVehiculo == 'R'? 'Residente': vehiculo.tipoVehiculo == 'N'? 'No Residente':'Valor sin registrar'}
					</td>			
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