package com.arct.parking.dto;

import java.io.Serializable;

import com.arct.parking.model.parking.Marca;
import com.arct.parking.model.parking.Modelo;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class ObtenerModeloPeticion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Modelo modelo;
	
	private Boolean enableLike = false;

	public Modelo getModelo() {
		return modelo;
	}

	@JsonSetter("modelo")
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, 
			  	  property = "@type")
	@JsonSubTypes({
		@JsonSubTypes.Type(value=Modelo.class, name = "Modelo")
		//@JsonSubTypes.Type(value=Marca.class, name = "Marca")
	})
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Boolean getEnableLike() {
		return enableLike;
	}

	public void setEnableLike(Boolean enableLike) {
		this.enableLike = enableLike;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
