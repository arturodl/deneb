package com.arct.parking.service.vehiculo.impl;

import com.arct.parking.dao.vehiculo.VehiculoDAO;
import com.arct.parking.dto.EliminarVehiculoPeticion;
import com.arct.parking.dto.InsertarVehiculoPeticion;
import com.arct.parking.dto.ModificarVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoRespuesta;
import com.arct.parking.service.vehiculo.VehiculoService;

public class VehiculoServiceImpl implements VehiculoService{
	
	private VehiculoDAO vehiculoDAO;	

	@Override
	public void insertarVehiculo(InsertarVehiculoPeticion peticion)throws Exception {
		// TODO Auto-generated method stub
		try {
			vehiculoDAO.insertarVehiculo(peticion);
		} catch(Exception e) {
			throw new Exception("Error al ejecutar VehiculoService.insertarVehiculo: "+e.getCause());
		}
	}

	@Override
	public void modificarVehiculo(ModificarVehiculoPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		try {
			vehiculoDAO.modificarVehiculo(peticion);
		} catch(Exception e) {
			throw new Exception("Error al ejecutar VehiculoService.modificarVehiculo: "+e.getCause());
		}
	}

	@Override
	public void eliminarVehiculo(EliminarVehiculoPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		try {
			vehiculoDAO.eliminarVehiculo(peticion);
		} catch(Exception e) {
			throw new Exception("Error al ejecutar VehiculoService.eliminarVehiculo: "+e.getCause());
		}
	}
	
	@Override
	public ObtenerVehiculoRespuesta obtenerVehiculo(ObtenerVehiculoPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		ObtenerVehiculoRespuesta respuesta = null;
		try {
			respuesta = vehiculoDAO.obtenerVehiculo(peticion);
		} catch(Exception e) {
			throw new Exception("Error al ejecutar VehiculoService.obtenerVehiculo: "+e.getCause());
		}
		return respuesta;
	}
	
	public VehiculoDAO getVehiculoDAO() {
		return vehiculoDAO;
	}

	public void setVehiculoDAO(VehiculoDAO vehiculoDAO) {
		this.vehiculoDAO = vehiculoDAO;
	}

	

}
