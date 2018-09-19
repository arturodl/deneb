package com.arct.parking.service.marca.impl;

import com.arct.parking.dao.marca.MarcaDAO;
import com.arct.parking.dto.InsertarMarcaPeticion;
import com.arct.parking.dto.InsertarMarcaRespuesta;
import com.arct.parking.dto.ObtenerMarcaPeticion;
import com.arct.parking.dto.ObtenerMarcaRespuesta;
import com.arct.parking.service.marca.MarcaService;

public class MarcaServiceImpl implements MarcaService {
	
	private MarcaDAO marcaDAO;

	@Override
	public InsertarMarcaRespuesta insertarMarca(InsertarMarcaPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObtenerMarcaRespuesta obtenerMarca(ObtenerMarcaPeticion peticion) throws Exception {
		ObtenerMarcaRespuesta respuesta = null;
		try{
			respuesta = marcaDAO.obtenerMarca(peticion);
		}catch(Exception e){
			System.out.println("Hubo un error al invocar MarcaService.obtenerMarca: "+e.getCause());
		}
		return respuesta;
	}

	public MarcaDAO getMarcaDAO() {
		return marcaDAO;
	}

	public void setMarcaDAO(MarcaDAO marcaDAO) {
		this.marcaDAO = marcaDAO;
	}
	
	

}
