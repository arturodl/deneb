package com.arct.parking.dto;

import java.io.Serializable;

import com.arct.parking.model.parking.Vehiculo;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class ObtenerVehiculoPeticion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Vehiculo vehiculo;
	
	private Boolean enableLike = false;

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	@JsonSetter("vehiculo")
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, 
			  	  property = "@type")
	@JsonSubTypes({
		@JsonSubTypes.Type(value=Vehiculo.class, name = "Vehiculo")
	})
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Boolean getEnableLike() {
		return enableLike;
	}

	public void setEnableLike(Boolean enableLike) {
		this.enableLike = enableLike;
	}
	
	
}
