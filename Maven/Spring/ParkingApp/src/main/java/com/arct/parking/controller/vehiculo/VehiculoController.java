package com.arct.parking.controller.vehiculo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arct.parking.dto.InsertarVehiculoPeticion;
import com.arct.parking.dto.ModificarVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoRespuesta;
import com.arct.parking.model.Vehiculo;
import com.arct.parking.service.vehiculo.VehiculoService;

@Controller
@RequestMapping(value="/vehiculo", method=RequestMethod.POST)
public class VehiculoController {
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
	  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
	  binder.registerCustomEditor(Date.class, orderDateEditor);
	}
	
	@RequestMapping(value="/gestionar", method=RequestMethod.GET)
	public String iniciar(ModelMap model, @ModelAttribute Vehiculo vehiculo) {
		model.addAttribute("bienvenida","Bienvenido a la Pantalla de Registro de Vehiculos");
		return "vehiculo/gestion";
	}
	
	@RequestMapping(value="/ejecutar", method=RequestMethod.POST)
	public String ejecutar(ModelMap model, @ModelAttribute Vehiculo vehiculo) {
		System.out.println("Ejecutando acciones sobre el Vehiculo");
				
		InsertarVehiculoPeticion peticionInsertar = new InsertarVehiculoPeticion();
		ModificarVehiculoPeticion peticionModificar = new ModificarVehiculoPeticion();
		try {	
			if(vehiculo.getIdVehiculo() == 0) {
				
				peticionInsertar.setVehiculo(vehiculo);
				vehiculoService.insertarVehiculo(peticionInsertar);
				
				model.addAttribute("bienvenida","Bienvenido a la Pantalla de Registro de Vehiculos");
				model.addAttribute("success","El Vehiculo fue registrado con exito, haga click en regresar para ir a la pantalla principal");
			
			}else {
				peticionModificar.setVehiculo(vehiculo);
				
				vehiculoService.modificarVehiculo(peticionModificar);
				
				model.addAttribute("bienvenida","Bienvenido a la Pantalla de Actualización de Vehiculos");
				model.addAttribute("success","La Vehiculo fue modificado con exito, haga click en regresar para ir a la pantalla principal.");
			}
			
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar VehiculosService.insertarVehiculo, favor de checar el log: "+e.getCause());
			model.addAttribute("error","Hubo un error al invocar VehiculoService.insertarVehiculo: "+e.getCause());
			e.printStackTrace();
		}
		
		model.addAttribute("mostrarFormulario",true);
								
		return "vehiculo/gestion";
	}	
	
	@RequestMapping(value="/listado", method =RequestMethod.GET)
	public String mostrarVehiculos(ModelMap model) {
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

	public VehiculoService getVehiculoService() {
		return vehiculoService;
	}

	public void setVehiculoService(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}
}
