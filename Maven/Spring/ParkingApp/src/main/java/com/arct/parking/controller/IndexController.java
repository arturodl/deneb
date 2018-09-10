package com.arct.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arct.parking.dto.ObtenerRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroRespuesta;
import com.arct.parking.dto.ObtenerVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoRespuesta;
import com.arct.parking.model.Registro;
import com.arct.parking.model.Vehiculo;
import com.arct.parking.service.bitacora.BitacoraService;
import com.arct.parking.service.vehiculo.VehiculoService;

@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	@Autowired
	private BitacoraService bitacoraService;
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@RequestMapping(method =RequestMethod.GET)
	public String darBienvenida(ModelMap model) {
		model.addAttribute("bienvenida","Bienvenidos al Sistema de Gestion de Entradas y Salidas");
		return "welcome";
	}
	
	@RequestMapping(value="/regsalida", method =RequestMethod.GET)
	public String registrarSalida() {
		return "redirect:/bitacora/resumen";
	}
	
	@RequestMapping(value="/resumen", method =RequestMethod.GET)
	public String mostrarResumen() {
		return "redirect:/bitacora/resumen";
	}
	
	public BitacoraService getBitacoraService() {
		return bitacoraService;
	}

	public void setBitacoraService(BitacoraService bitacoraService) {
		this.bitacoraService = bitacoraService;
	}

	public VehiculoService getVehiculoService() {
		return vehiculoService;
	}

	public void setVehiculoService(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}
}
