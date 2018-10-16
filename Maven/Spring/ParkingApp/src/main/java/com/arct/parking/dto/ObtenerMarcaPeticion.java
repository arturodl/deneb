package com.arct.parking.dto;

import java.io.Serializable;

import com.arct.parking.model.Marca;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class ObtenerMarcaPeticion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Marca marca;
	
	private Boolean enableLike = false;

	public Marca getMarca() {
		return marca;
	}

	@JsonSetter("marca")
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
			  	  property = "@type"
				 )
	@JsonSubTypes({
		@JsonSubTypes.Type(value=Marca.class, name = "Marca")		
	})
	public void setMarca(Marca marca) {
		this.marca = marca;
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
