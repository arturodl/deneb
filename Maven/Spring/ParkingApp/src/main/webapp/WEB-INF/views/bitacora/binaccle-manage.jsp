<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%! String classDisabled = null; %>

<style>
	.default-font-size{
		font-size: 14px;
	}
	
	.background-disabled{
		background: #dddddd;
	}
</style>

<div id="divBinaccleManage" class="container">
	<% classDisabled = (String)request.getAttribute("class-disabled"); %>
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
				   	<form:input id="txtNoPlaca" path="vehiculo.noPlaca" cssClass="form-control background-disabled default-font-size" readonly="true" 
				   		placeholder="Sin información" />				   
				</td> 
			</tr>
			<tr>
				<td>
					<label>Marca</label>
				</td>
				<td>
					<form:input id="txtMarcaVehiculo" path="vehiculo.marca" cssClass="form-control background-disabled default-font-size" readonly="true"
						placeholder="Sin información"/>
				</td> 
			</tr>
			<tr>
				<td>
					<label>Modelo</label>
				</td>
				<td>
					<form:input id="txtModeloVehiculo" path="vehiculo.modelo" cssClass="form-control background-disabled default-font-size" readonly="true"
						placeholder="Sin información"/>
				</td> 
			</tr>
			<tr>
				<td>
					<label>Tipo Vehiculo</label>
				</td>
				<td>
					<input id="txtTipoVehiculo" class="form-control background-disabled default-font-size" readonly="true" type="text"
						value="${registro.vehiculo.tipoVehiculo=='O'? 'Oficial': registro.vehiculo.tipoVehiculo=='N'? 'Normal': registro.vehiculo.tipoVehiculo=='P'? 'Particular': 'Sin Información'}" 
							/>
				</td> 
			</tr>
			<c:if test="${showCheckInDatesEnabled}">
				<tr>
					<td>
						<form:label path="fechaEntrada">
							<spring:message text="Fecha de Entrada"/>
						</form:label>
					</td>
					<td>
						<form:input path="fechaEntrada" cssClass="form-control default-font-size" />					
					</td> 
				</tr>
				<tr> 
					<td>
						<form:label path="horaEntrada">
							<spring:message text="Hora de Entrada"/>
						</form:label>
					</td>
					<td>
						<form:input path="horaEntrada" cssClass="form-control default-font-size " />
					</td>
				</tr>
			</c:if>
			<c:if test="${showCheckInDatesDisabled}">
				<tr>
					<td>
						<form:label path="fechaEntrada">
							<spring:message text="Fecha de Entrada"/>
						</form:label>
					</td>
					<td>
						<form:input path="fechaEntrada" cssClass="form-control default-font-size background-disabled" readonly="true"/>					
					</td> 
				</tr>
				<tr> 
					<td>
						<form:label path="horaEntrada">
							<spring:message text="Hora de Entrada"/>
						</form:label>
					</td>
					<td>
						<form:input path="horaEntrada" cssClass="form-control default-font-size background-disabled" readonly="true" />
					</td>
				</tr>
			</c:if>
			<c:if test="${captureCheckOut}">
				<tr>
					<td>
						<form:label path="fechaSalida">
							<spring:message text="Fecha de Salida"/>
						</form:label>
					</td>
					<td>
						<form:input  path="fechaSalida" cssClass="form-control default-font-size" />
					</td> 
				</tr>
				<tr>
					<td>
						<form:label path="horaSalida">
							<spring:message text="Hora de Salida"/>
						</form:label>
					</td>
					<td>
						<form:input  path="horaSalida" cssClass="form-control default-font-size" />
					</td> 
				</tr>
			</c:if>
			<tr>
				<td>
				</td>
				<td>
					<p><button type="submit" class="btn btn-primary default-font-size" 
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
	
