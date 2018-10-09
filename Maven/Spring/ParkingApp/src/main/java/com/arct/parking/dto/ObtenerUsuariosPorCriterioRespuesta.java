package com.arct.parking.dto;

import java.io.Serializable;
import java.util.List;

import com.arct.parking.model.Usuario;

public class ObtenerUsuariosPorCriterioRespuesta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> listaUsuarios;

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	

}
