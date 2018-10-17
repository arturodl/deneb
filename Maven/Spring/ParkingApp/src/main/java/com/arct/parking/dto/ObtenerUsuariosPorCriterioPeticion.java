package com.arct.parking.dto;

import java.io.Serializable;

import com.arct.parking.model.security.Usuario;

public class ObtenerUsuariosPorCriterioPeticion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	private Boolean enableLike = false;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getEnableLike() {
		return enableLike;
	}

	public void setEnableLike(Boolean enableLike) {
		this.enableLike = enableLike;
	}

	
}
