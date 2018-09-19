package com.arct.parking.dao.marca;

import com.arct.parking.dto.EliminarMarcaPeticion;
import com.arct.parking.dto.EliminarMarcaRespuesta;
import com.arct.parking.dto.InsertarMarcaPeticion;
import com.arct.parking.dto.InsertarMarcaRespuesta;
import com.arct.parking.dto.ModificarMarcaPeticion;
import com.arct.parking.dto.ModificarMarcaRespuesta;
import com.arct.parking.dto.ObtenerMarcaPeticion;
import com.arct.parking.dto.ObtenerMarcaRespuesta;

public interface MarcaDAO {
	public InsertarMarcaRespuesta insertarMarca(InsertarMarcaPeticion peticion) throws Exception;
	public ModificarMarcaRespuesta modificarMarca(ModificarMarcaPeticion peticion) throws Exception;
	public EliminarMarcaRespuesta eliminarMarca(EliminarMarcaPeticion peticion) throws Exception;
	public ObtenerMarcaRespuesta obtenerMarca(ObtenerMarcaPeticion peticion) throws Exception;
}
