package com.arct.parking.dto;

import java.util.List;

import com.arct.parking.model.Registro;

public class ObtenerRegistroRespuesta {
	private List<Registro> listaRegistros;

	public List<Registro> getListaRegistros() {
		return listaRegistros;
	}

	public void setListaRegistros(List<Registro> listaRegistros) {
		this.listaRegistros = listaRegistros;
	}

	
}
