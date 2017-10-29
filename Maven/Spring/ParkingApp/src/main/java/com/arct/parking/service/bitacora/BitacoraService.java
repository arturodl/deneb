package com.arct.parking.service.bitacora;

import com.arct.parking.dto.EliminarRegistroPeticion;
import com.arct.parking.dto.InsertarRegistroPeticion;
import com.arct.parking.dto.ModificarRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroRespuesta;

public interface BitacoraService {
	
	public void insertarRegistro(InsertarRegistroPeticion peticion) throws Exception;
	public void modificarRegistro(ModificarRegistroPeticion peticion) throws Exception;
	public void eliminarRegistro(EliminarRegistroPeticion peticion) throws Exception;
	public ObtenerRegistroRespuesta obtenerRegistro(ObtenerRegistroPeticion peticion)throws Exception;

}
