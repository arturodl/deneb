package com.arct.parking.service.usuario.impl;

import com.arct.parking.dao.usuario.UsuarioDAO;
import com.arct.parking.dto.EliminarUsuarioPeticion;
import com.arct.parking.dto.EliminarUsuarioRespuesta;
import com.arct.parking.dto.InsertarUsuarioPeticion;
import com.arct.parking.dto.InsertarUsuarioRespuesta;
import com.arct.parking.dto.ModificarUsuarioPeticion;
import com.arct.parking.dto.ModificarUsuarioRespuesta;
import com.arct.parking.dto.ObtenerUsuariosPorCriterioPeticion;
import com.arct.parking.dto.ObtenerUsuariosPorCriterioRespuesta;
import com.arct.parking.service.usuario.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDAO usuarioDAO;

	@Override
	public InsertarUsuarioRespuesta insertarUsuario(InsertarUsuarioPeticion peticion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModificarUsuarioRespuesta modificarUsuario(ModificarUsuarioPeticion peticion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EliminarUsuarioRespuesta eliminarUsuario(EliminarUsuarioPeticion peticion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObtenerUsuariosPorCriterioRespuesta obtenerUsuariosPorCriterio(ObtenerUsuariosPorCriterioPeticion peticion) {
		// TODO Auto-generated method stub
		ObtenerUsuariosPorCriterioRespuesta respuesta = null;
		try{
			respuesta = usuarioDAO.obtenerUsuariosPorCriterio(peticion);
		}catch(Exception e){
			System.out.println("Hubo un error al invocar UsuarioService.obtenerUsuariosPorCriterio: "+e.getCause());
		}
		return respuesta;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
