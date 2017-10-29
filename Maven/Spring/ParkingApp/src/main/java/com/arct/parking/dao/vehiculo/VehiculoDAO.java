package com.arct.parking.dao.vehiculo;

import com.arct.parking.dto.EliminarVehiculoPeticion;
import com.arct.parking.dto.InsertarVehiculoPeticion;
import com.arct.parking.dto.ModificarVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoRespuesta;

public interface VehiculoDAO {
	public void insertarVehiculo(InsertarVehiculoPeticion peticion) throws Exception;
	public void modificarVehiculo(ModificarVehiculoPeticion peticion) throws Exception;
	public void eliminarVehiculo(EliminarVehiculoPeticion peticion) throws Exception;
	public ObtenerVehiculoRespuesta obtenerVehiculo(ObtenerVehiculoPeticion peticion) throws Exception;
}
