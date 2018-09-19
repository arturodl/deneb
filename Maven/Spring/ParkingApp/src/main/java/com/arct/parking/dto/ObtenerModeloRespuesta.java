package com.arct.parking.dto;

import java.io.Serializable;
import java.util.List;

import com.arct.parking.model.Modelo;

public class ObtenerModeloRespuesta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Modelo> listaModelos;

	public List<Modelo> getListaModelos() {
		return listaModelos;
	}

	public void setListaModelos(List<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
