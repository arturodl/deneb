package com.arct.parking.service.modelo.impl;

import com.arct.parking.dao.modelo.ModeloDAO;
import com.arct.parking.dto.InsertarModeloPeticion;
import com.arct.parking.dto.ModificarModeloPeticion;
import com.arct.parking.dto.ObtenerModeloPeticion;
import com.arct.parking.dto.ObtenerModeloRespuesta;
import com.arct.parking.dto.ObtenerVehiculoRespuesta;
import com.arct.parking.service.modelo.ModeloService;

public class ModeloServiceImpl implements ModeloService {
	
	private ModeloDAO modeloDAO;

	@Override
	public void insertarModelo(InsertarModeloPeticion peticion) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarModelo(ModificarModeloPeticion peticion) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ObtenerModeloRespuesta obtenerModelo(ObtenerModeloPeticion peticion) throws Exception {
		ObtenerModeloRespuesta respuesta = null;
		try {
			respuesta = modeloDAO.obtenerModelo(peticion);
		} catch(Exception e) {
			throw new Exception("Error al ejecutar ModeloService.obtenerModelo: "+e.getCause());
		}
		return respuesta;
	}

	public ModeloDAO getModeloDAO() {
		return modeloDAO;
	}

	public void setModeloDAO(ModeloDAO modeloDAO) {
		this.modeloDAO = modeloDAO;
	}

}
