package com.arct.parking.dto;

import java.io.Serializable;
import java.util.List;

import com.arct.parking.model.Marca;

public class ObtenerMarcaRespuesta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Marca> listaMarcas;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Marca> getListaMarcas() {
		return listaMarcas;
	}
	
	public void setListaMarcas(List<Marca> listaMarcas) {
		this.listaMarcas = listaMarcas;
	}
		
}
