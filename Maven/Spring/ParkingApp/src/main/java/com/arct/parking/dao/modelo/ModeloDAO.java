package com.arct.parking.dao.modelo;

import com.arct.parking.dto.EliminarModeloPeticion;
import com.arct.parking.dto.EliminarModeloRespuesta;
import com.arct.parking.dto.InsertarModeloPeticion;
import com.arct.parking.dto.InsertarModeloRespuesta;
import com.arct.parking.dto.ModificarModeloPeticion;
import com.arct.parking.dto.ModificarModeloRespuesta;
import com.arct.parking.dto.ObtenerModeloPeticion;
import com.arct.parking.dto.ObtenerModeloRespuesta;

public interface ModeloDAO {
	public InsertarModeloRespuesta insertarModelo(InsertarModeloPeticion peticion) throws Exception;
	public ModificarModeloRespuesta modificarModelo(ModificarModeloPeticion peticion) throws Exception;
	public EliminarModeloRespuesta eliminarModelo(EliminarModeloPeticion peticion) throws Exception;
	public ObtenerModeloRespuesta obtenerModelo(ObtenerModeloPeticion peticion) throws Exception;
}
