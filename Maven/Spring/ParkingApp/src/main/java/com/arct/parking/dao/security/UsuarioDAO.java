package com.arct.parking.dao.security;

import com.arct.parking.dto.EliminarUsuarioPeticion;
import com.arct.parking.dto.EliminarUsuarioRespuesta;
import com.arct.parking.dto.InsertarUsuarioPeticion;
import com.arct.parking.dto.InsertarUsuarioRespuesta;
import com.arct.parking.dto.ModificarUsuarioPeticion;
import com.arct.parking.dto.ModificarUsuarioRespuesta;
import com.arct.parking.dto.ObtenerUsuariosPorCriterioPeticion;
import com.arct.parking.dto.ObtenerUsuariosPorCriterioRespuesta;

public interface UsuarioDAO {
	
	public InsertarUsuarioRespuesta insertarUsuario(InsertarUsuarioPeticion peticion) throws Exception;
	public ModificarUsuarioRespuesta modificarUsuario(ModificarUsuarioPeticion peticion) throws Exception;
	public EliminarUsuarioRespuesta eliminarUsuario(EliminarUsuarioPeticion peticion) throws Exception;
	public ObtenerUsuariosPorCriterioRespuesta obtenerUsuariosPorCriterio(ObtenerUsuariosPorCriterioPeticion peticion) throws Exception;

}
