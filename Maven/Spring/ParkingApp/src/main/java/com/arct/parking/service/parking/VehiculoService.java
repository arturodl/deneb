package com.arct.parking.service.parking;

import com.arct.parking.dto.EliminarVehiculoPeticion;
import com.arct.parking.dto.InsertarVehiculoPeticion;
import com.arct.parking.dto.ModificarVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoRespuesta;

public interface VehiculoService {
	
	public void insertarVehiculo(InsertarVehiculoPeticion peticion) throws Exception;
	public void modificarVehiculo(ModificarVehiculoPeticion peticion) throws Exception;
	public void eliminarVehiculo(EliminarVehiculoPeticion peticion) throws Exception;
	public ObtenerVehiculoRespuesta obtenerVehiculo(ObtenerVehiculoPeticion peticion)throws Exception;

}
