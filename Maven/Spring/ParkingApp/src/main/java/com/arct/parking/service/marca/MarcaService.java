package com.arct.parking.service.marca;

import com.arct.parking.dto.InsertarMarcaPeticion;
import com.arct.parking.dto.InsertarMarcaRespuesta;
import com.arct.parking.dto.ObtenerMarcaPeticion;
import com.arct.parking.dto.ObtenerMarcaRespuesta;

public interface MarcaService {
	
	public InsertarMarcaRespuesta insertarMarca(InsertarMarcaPeticion peticion) throws Exception;
	public ObtenerMarcaRespuesta obtenerMarca(ObtenerMarcaPeticion peticion) throws Exception;
	
}
