package com.arct.parking.service.modelo;

import com.arct.parking.dto.InsertarModeloPeticion;
import com.arct.parking.dto.ModificarModeloPeticion;
import com.arct.parking.dto.ObtenerModeloPeticion;
import com.arct.parking.dto.ObtenerModeloRespuesta;

public interface ModeloService {
	
	public void insertarModelo(InsertarModeloPeticion peticion) throws Exception;
	public void modificarModelo(ModificarModeloPeticion peticion) throws Exception;
	public ObtenerModeloRespuesta obtenerModelo(ObtenerModeloPeticion peticion)throws Exception;
	
}
