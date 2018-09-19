<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function(){		
		$('#sandbox-container-checkout input#txtFechaAlta').datepicker({
			format: "dd-mm-yyyy",
			language: "es",
	        autoclose: true,
	        todayHighlight: true
	    });   
	 });
	
</script>

<style>
	.default-font-size{
		font-size: 14px;
	}	
	.background-disabled{
		background: #dddddd;
	}	
	.background-enabled{
		background-color: white !important;
	}	
	.datepicker{
		font-size: 14px;
	}
</style>

<div id="divGestionVehiculos" class="container">    
  <c:url var="ejecutar" value="/vehiculo/ejecutar" ></c:url>
  <div id="divMensajesVehiculos">
  	<h6 style="color:blue;"> ${success}</h6>
	<h6 style="color:red;"> ${error}</h6>
  </div>  
  <form:form id="formPrincipalVehiculo" action="${ejecutar}" modelAttribute="vehiculo" method="POST">
	<table>
		<tr>
			<td>
				<form:label path="noPlaca">
					<spring:message text="Número de Placa"/>
				</form:label>
			</td>
			<td>
				<form:hidden path="idVehiculo"/>
			   	<form:input id="txtNoPlaca" path="noPlaca" cssClass="form-control default-font-size" disabled="${deshabilitarComponentes}"/>
			</td> 
		</tr>
		<tr>
			<td>
				<form:label path="marca">
					<spring:message text="Marca"/>
				</form:label>
			</td>
			<td> 
				<form:input id="txtMarca" path="marca" cssClass="form-control default-font-size" disabled="${deshabilitarComponentes}"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="modelo">
					<spring:message text="Modelo"/>
				</form:label>
			</td>
			<td> 
				<form:input id="txtModelo" path="modelo" cssClass="form-control default-font-size" disabled="${deshabilitarComponentes}"/>
			</td> 
		</tr>	
		<tr>
			<td>
				<form:label path="fechaAlta">
					<spring:message text="Fecha de Alta"/>
				</form:label>
			</td>
			<td> 
				<c:choose>
					 <c:when test="${!deshabilitarComponentes}">
						<div id="sandbox-container-checkout">
							<div class="input-group">
								<form:input id="txtFechaAlta" path="fechaAlta" cssClass="form-control default-font-size background-enabled" readonly="true"/>
								<span class="input-group-addon">
							    	<i class="fa fa-th-list" style="font-size:22px;margin-top: 6px;margin-left: 4px;color: rgb(221, 221, 221);"></i>
							    </span>
							</div>					
						</div>
					</c:when>
					<c:otherwise>
						<form:input id="txtFechaAltaAux" path="fechaAlta" cssClass="form-control default-font-size" disabled="true"/>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="tipoVehiculo">
					<spring:message text="Tipo de Vehiculo"/>
				</form:label>
			</td>
			<td> 
				<div class="dropdown">
					<form:select id="selectTipoVehiculo" path="tipoVehiculo" cssClass="btn btn-secondary dropdown-toggle default-font-size"
						disabled="${deshabilitarComponentes}">
					   <form:option value="" label="Seleccione una opcion"/>
					   <form:option value="O" label="Oficial" />
					   <form:option value="P" label="Particular" />
					   <form:option value="R" label="Residente" />
					   <form:option value="N" label="No Residente" />
					</form:select>
				</div>
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<p><button type="submit" class="btn btn-primary default-font-size" 
						<c:if test="${deshabilitarComponentes}">
							disabled
						</c:if>
					>
					<c:if test="${newEnabled}">
						Agregar
					</c:if>
					<c:if test="${editEnabled}">
						Modificar
					</c:if>					
				   </button>	
				   <a class="btn btn-primary default-font-size" href="#" role="button" onclick="getView('<c:url value='/vehiculo/listado' />');">Regresar</a>			   
				</p>				
			</td>				
		</tr>		
	</table>	
  </form:form>
  
	
  <hr>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/forviews/vehicle/vehicle-manage.js"/>"></script>