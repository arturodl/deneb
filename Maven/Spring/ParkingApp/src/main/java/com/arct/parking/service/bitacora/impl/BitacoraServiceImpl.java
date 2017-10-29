package com.arct.parking.service.bitacora.impl;

import com.arct.parking.dao.bitacora.RegistroDAO;
import com.arct.parking.dto.EliminarRegistroPeticion;
import com.arct.parking.dto.InsertarRegistroPeticion;
import com.arct.parking.dto.ModificarRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroRespuesta;
import com.arct.parking.service.bitacora.BitacoraService;

public class BitacoraServiceImpl implements BitacoraService{
	
	private RegistroDAO registroDAO;	

	@Override
	public void insertarRegistro(InsertarRegistroPeticion peticion)throws Exception {
		// TODO Auto-generated method stub
		try {
			registroDAO.insertarRegistro(peticion);
		} catch(Exception e) {
			throw new Exception("Error al ejecutar BitacoraService.insertarRegistro: "+e.getCause());
		}
	}

	@Override
	public void modificarRegistro(ModificarRegistroPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		try {
			registroDAO.modificarRegistro(peticion);
		} catch(Exception e) {
			throw new Exception("Error al ejecutar BitacoraService.modificarRegistro: "+e.getCause());
		}
	}

	@Override
	public void eliminarRegistro(EliminarRegistroPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		try {
			registroDAO.eliminarRegistro(peticion);
		} catch(Exception e) {
			throw new Exception("Error al ejecutar BitacoraService.eliminarRegistro: "+e.getCause());
		}
	}
	
	@Override
	public ObtenerRegistroRespuesta obtenerRegistro(ObtenerRegistroPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		ObtenerRegistroRespuesta respuesta = null;
		try {
			respuesta = registroDAO.obtenerRegistro(peticion);
		} catch(Exception e) {
			throw new Exception("Error al ejecutar BitacoraService.obtenerRegistro: "+e.getCause());
		}
		return respuesta;
	}
	
	public RegistroDAO getRegistroDAO() {
		return registroDAO;
	}

	public void setRegistroDAO(RegistroDAO registroDAO) {
		this.registroDAO = registroDAO;
	}

	

}
