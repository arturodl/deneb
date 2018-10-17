package com.arct.parking.dto;

import java.util.List;

import com.arct.parking.model.parking.Registro;
import com.arct.parking.model.parking.Vehiculo;

public class ObtenerVehiculoRespuesta {
	private List<Vehiculo> listaVehiculos;

	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}


}
