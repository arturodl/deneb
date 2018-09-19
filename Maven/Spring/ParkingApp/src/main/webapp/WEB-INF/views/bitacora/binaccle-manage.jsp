<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% Boolean showDatesAndTimesInEnabled = (Boolean)request.getAttribute("showCheckInDatesEnabled");   %>

<script type="text/javascript">
	$(document).ready(function(){		
		$('#sandbox-container input#txtFechaEntrada, #sandbox-container-checkout input#txtFechaSalida').datepicker({
			format: "dd-mm-yyyy",
			language: "es",
	        autoclose: true,
	        todayHighlight: true
	    });   
		
		$('#txtHoraEntrada, #txtHoraSalida').wickedpicker();
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
	.wickedpicker__controls__control-up:before {
        content: '+ '; font-size: 12px !important;
    }
    .wickedpicker__controls__control-down:after {
        content: '- '; font-size: 12px !important;
    }
    .wickedpicker__controls {
    	padding: 2px 0;
    }
</style>

<div id="divBinaccleManage" class="container">
	<% String cssDatesIn = "form-control default-font-size datepicker ";
	   String cssTimesIn = "form-control default-font-size timepicker ";	   
	   if(showDatesAndTimesInEnabled != null  && showDatesAndTimesInEnabled){
		   cssDatesIn = cssDatesIn.concat("background-enabled");
		   cssTimesIn = cssTimesIn.concat("background-enabled");
	   }
	%>
    <div id="divMensajesVehiculos">
	  	<h6 style="color:blue;"> ${success}</h6>
		<h6 style="color:red;"> ${error}</h6>
    </div>  
	<c:if test="${mostrarFormulario}">
	  <c:url var="ejecutar" value="/bitacora/ejecutar" ></c:url>
	  <form:form id="formPrincipalBitacora" action="${ejecutar}" modelAttribute="registro" method="POST">
		<table>		
			<c:if test="${capturePlateNumber}">
			   	<tr>
					<td>
						<label>Buscar No. Placa</label>
					</td>
					<td>
					   	<input id="txtBuscarNoPlaca" class="form-control default-font-size" placeholder="Teclea el numero de placa" />				   
					</td> 
				</tr>
			</c:if>
			<tr>
				<td>
					<form:label path="vehiculo.noPlaca">
						<spring:message text="No. Placa Seleccionada"/>
					</form:label>
				</td>
				<td>
				    <form:hidden path="idRegistro"/>
				    <form:hidden path="vehiculo.idVehiculo"/>
				   	<form:input id="txtNoPlaca" path="vehiculo.noPlaca" cssClass="form-control default-font-size" readonly="true" 
				   		placeholder="Sin información" />				   
				</td> 
			</tr>
			<tr>
				<td>
					<label>Marca</label>
				</td>
				<td>
					<form:input id="txtMarcaVehiculo" path="vehiculo.modelo.marca.marca" cssClass="form-control default-font-size" readonly="true"
						placeholder="Sin información"/>
				</td> 
			</tr>
			<tr>
				<td>
					<label>Modelo</label>
				</td>
				<td>
					<form:input id="txtModeloVehiculo" path="vehiculo.modelo.modelo" cssClass="form-control default-font-size" readonly="true"
						placeholder="Sin información"/>
				</td> 
			</tr>
			<tr>
				<td>
					<label>Tipo Vehiculo</label>
				</td>
				<td>
					<form:hidden path="vehiculo.tipoVehiculo"/>
					<input id="txtTipoVehiculo" class="form-control default-font-size" readonly="true" type="text"
						value="${registro.vehiculo.tipoVehiculo=='O'? 'Oficial': registro.vehiculo.tipoVehiculo=='N'? 'Normal': registro.vehiculo.tipoVehiculo=='P'? 'Particular': 'Sin Información'}" 
							/>
				</td> 
			</tr>
		    <tr>
				<td>
					<form:label path="fechaEntrada">
						<spring:message text="Fecha de Entrada"/>
					</form:label>
				</td>
				<td>
					<c:choose>
					    <c:when test="${showCheckInDatesEnabled}">
							<div id="sandbox-container">
							  <div class="input-group">
							    <form:input id="txtFechaEntrada" path="fechaEntrada" cssClass="<%=cssDatesIn%>" readonly="true"/>
						        <span class="input-group-addon">
							    	<i class="fa fa-th-list" style="font-size:22px;margin-top: 6px;margin-left: 4px;color: rgb(221, 221, 221);"></i>
							    </span>						    
							  </div>
							</div>	
						</c:when>		
						<c:otherwise>
						    <form:input id="txtFechaEntradaAux" path="fechaEntrada" cssClass="<%=cssDatesIn%>" readonly="true"/>
						</c:otherwise>
					</c:choose>		
				</td> 
			</tr>
			<tr> 
				<td>
					<form:label path="horaEntrada">
						<spring:message text="Hora de Entrada"/>
					</form:label>
				</td>
				<td>   
					<c:choose>
					    <c:when test="${showCheckInDatesEnabled}">
							<form:input id="txtHoraEntrada" path="horaEntrada" name="timepicker" cssClass="<%=cssTimesIn%>" readonly="true"/>	
						</c:when>
						<c:otherwise>
							<form:input id="txtHoraEntradaAux" path="horaEntrada" cssClass="<%=cssTimesIn%>" readonly="true"/>
						</c:otherwise>
					</c:choose>					 				
				</td>
			</tr>
			<c:if test="${captureCheckOut}">
				<tr>
					<td>
						<form:label path="fechaSalida">
							<spring:message text="Fecha de Salida"/>
						</form:label>
					</td>
					<td>
						<c:choose>
					    	<c:when test="${showCheckOutDatesEnabled}">
								<div id="sandbox-container-checkout">
									  <div class="input-group">
										<form:input id="txtFechaSalida" path="fechaSalida" cssClass="form-control default-font-size datepicker background-enabled" readonly="true"/>
										<span class="input-group-addon">
									    	<i class="fa fa-th-list" style="font-size:22px;margin-top: 6px;margin-left: 4px;color: rgb(221, 221, 221);"></i>
									    </span>	
									  </div>
								</div>
							</c:when>
							<c:otherwise>
								<form:input id="txtFechaSalidaAux" path="fechaSalida" cssClass="form-control default-font-size" readonly="true"/>
							</c:otherwise>
						</c:choose>
					</td> 
				</tr>
				<tr>
					<td>
						<form:label path="horaSalida">
							<spring:message text="Hora de Salida"/>
						</form:label>
					</td>
					<td>
						<c:choose>
					    	<c:when test="${showCheckOutDatesEnabled}">
								<form:input id="txtHoraSalida" path="horaSalida" cssClass="form-control default-font-size timepicker background-enabled" readonly="true"/>
							</c:when>
							<c:otherwise>
								<form:input id="txtHoraSalidaAux" path="horaSalida" cssClass="form-control default-font-size" readonly="true"/>
							</c:otherwise>
						</c:choose>
					</td> 
				</tr>
			</c:if>
			<tr>
				<td>
				</td>
				<td>
					<p><button id="btnSubmit" type="submit" class="btn btn-primary default-font-size" 
						 	<c:if test="${disableBtnExecute}">
								disabled
							</c:if>
						>
							<c:if test="${captureCheckIn}">
								Registrar Entrada
							</c:if>
							<c:if test="${captureCheckOut}">
								Registrar Salida
							</c:if>		
							<c:if test="${showNoAccess}">
								Sin Acceso
							</c:if>
						</button>
						<a class="btn btn-primary default-font-size" href="#" role="button" onclick="getView('<c:url value='/bitacora/resumen' />');">Regresar</a>
					</p>							
				</td>						
			</tr>		
		</table>	
	  </form:form>
	</c:if>

  <hr/>
  <footer>
	<p>Arct-Applications</p>
  </footer>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/bitacora/binaccle-manage.js" />"></script>


	
