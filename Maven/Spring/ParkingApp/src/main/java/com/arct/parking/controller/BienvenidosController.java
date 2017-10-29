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
public class BienvenidosController {
	
	@Autowired
	private BitacoraService bitacoraService;
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@RequestMapping(value="/", method =RequestMethod.GET)
	public String darBienvenida(ModelMap model) {
		model.addAttribute("bienvenida","Bienvenidos al Sistema de Gestion de Entradas y Salidas");
		return "bienvenidos";
	}
	
	@RequestMapping(value="/regentrada", method =RequestMethod.GET)
	public String registrarEntrada(ModelMap model, @ModelAttribute Registro registro) {
		model.addAttribute("bienvenida","Bienvenido a la Pantalla de Registro de Entradas");
		model.addAttribute("mostrarFormulario", true);
		model.addAttribute("mostrarResumenBitacora", false);
		return "bitacora/registro";
	}
	
	@RequestMapping(value="/regsalida", method =RequestMethod.GET)
	public String registrarSalida() {
		return "redirect:/todoregistros";
	}
	
	@RequestMapping(value="/resumen", method =RequestMethod.GET)
	public String resumenBitacora(ModelMap model,  @ModelAttribute Registro registro) {
		model.addAttribute("bienvenida","Bienvenido a la Pantalla de Resumen");
		
		ObtenerRegistroPeticion peticion = new ObtenerRegistroPeticion();
		ObtenerRegistroRespuesta respuesta = null;
		try {
			respuesta = bitacoraService.obtenerRegistro(peticion);
			model.addAttribute( "listaRegistros",respuesta.getListaRegistros() );
			model.addAttribute("mostrarEditar",false);
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar BitacoraService.obtenerRegistro: "+e.getCause());
			e.printStackTrace();
		}
		
		return "bitacora/resumen";
	}

	@RequestMapping(value="registrarvehiculo", method=RequestMethod.GET)
	public String registrarVehiculo(ModelMap model, @ModelAttribute Vehiculo vehiculo) {
		model.addAttribute("bienvenida","Bienvenido a la Pantalla de Registro de Vehiculos");
		return "vehiculo/gestion";
	}
	
	@RequestMapping(value="/listadovehiculos", method =RequestMethod.GET)
	public String listadoVehiculos(ModelMap model) {
		ObtenerVehiculoPeticion peticion = new ObtenerVehiculoPeticion();
		ObtenerVehiculoRespuesta respuesta = null;
		Vehiculo vehiculo = null;
		try {
			vehiculo = new Vehiculo();
			peticion.setVehiculo(vehiculo);
			respuesta = vehiculoService.obtenerVehiculo(peticion);
			model.addAttribute("listaVehiculos",respuesta.getListaVehiculos() );
			model.addAttribute("mostrarEditar",false);
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar VehiculoService.obtenerVehiculo: "+e.getCause());
			e.printStackTrace();
		}
		
		return "vehiculo/listado";
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
