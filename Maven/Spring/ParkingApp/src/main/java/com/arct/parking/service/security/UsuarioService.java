package com.arct.parking.service.security;

import com.arct.parking.dto.EliminarUsuarioPeticion;
import com.arct.parking.dto.EliminarUsuarioRespuesta;
import com.arct.parking.dto.InsertarUsuarioPeticion;
import com.arct.parking.dto.InsertarUsuarioRespuesta;
import com.arct.parking.dto.ModificarUsuarioPeticion;
import com.arct.parking.dto.ModificarUsuarioRespuesta;
import com.arct.parking.dto.ObtenerUsuariosPorCriterioPeticion;
import com.arct.parking.dto.ObtenerUsuariosPorCriterioRespuesta;

public interface UsuarioService {
	
	public InsertarUsuarioRespuesta insertarUsuario(InsertarUsuarioPeticion peticion);
	public ModificarUsuarioRespuesta modificarUsuario(ModificarUsuarioPeticion peticion);
	public EliminarUsuarioRespuesta eliminarUsuario(EliminarUsuarioPeticion peticion);
	public ObtenerUsuariosPorCriterioRespuesta obtenerUsuariosPorCriterio(ObtenerUsuariosPorCriterioPeticion peticion);
	
}
