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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arct.parking.dto.InsertarVehiculoPeticion;
import com.arct.parking.dto.ModificarVehiculoPeticion;
import com.arct.parking.dto.ObtenerRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroRespuesta;
import com.arct.parking.dto.ObtenerVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoRespuesta;
import com.arct.parking.model.Registro;
import com.arct.parking.model.Vehiculo;
import com.arct.parking.service.vehiculo.VehiculoService;

@Controller
@RequestMapping(value="/vehiculo")
public class VehiculoController {
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
	  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
	  binder.registerCustomEditor(Date.class, orderDateEditor);
	}
	
	@ModelAttribute // This is for always setting values by default
	public void addAttributes(ModelMap model){
		
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.GET)
	public String iniciar(ModelMap model, @ModelAttribute Vehiculo vehiculo) {
		model.addAttribute("deshabilitarComponentes",false);
		model.addAttribute("newEnabled",true);
		return "vehiculo/vehicle-manage";
	}
	
	@RequestMapping(value="/editar/{idVehiculo}", method=RequestMethod.GET)
	public String editarRegistro(@PathVariable("idVehiculo") int idVehiculo, ModelMap model ) {
		System.out.println("Id Vehiculo Recuperado: "+idVehiculo);
		Vehiculo vehiculoABuscar = new Vehiculo();
		vehiculoABuscar.setIdVehiculo(idVehiculo);
		
		model.addAttribute("vehiculo", obtenerVehiculo(vehiculoABuscar));
		model.addAttribute("deshabilitarComponentes",false);
		model.addAttribute("editEnabled",true);
		return "vehiculo/vehicle-manage";
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
				model.addAttribute("deshabilitarComponentes",true);
				model.addAttribute("newEnabled",true);
				model.addAttribute("success","El Vehiculo fue registrado con exito, haga click en regresar para ir a la pantalla principal");			
			}else {
				peticionModificar.setVehiculo(vehiculo);				
				vehiculoService.modificarVehiculo(peticionModificar);
				model.addAttribute("deshabilitarComponentes",true);
				model.addAttribute("editEnabled",true);
				model.addAttribute("success","La Vehiculo fue modificado con exito, haga click en regresar para ir a la pantalla principal.");
			}
			
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar VehiculosService.insertarVehiculo, favor de checar el log: "+e.getCause());
			model.addAttribute("deshabilitarComponentes",true);
			model.addAttribute("error","Hubo un error al invocar VehiculoService.insertarVehiculo: "+e.getCause());
			e.printStackTrace();
		}
		
		return "vehiculo/vehicle-manage";
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
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar VehiculoService.obtenerVehiculo: "+e.getCause());
			e.printStackTrace();
		}
		
		return "vehiculo/vehicle-resume";
	}
	
	public Vehiculo obtenerVehiculo(Vehiculo vehiculo) {
		ObtenerVehiculoPeticion peticionVehiculo = new ObtenerVehiculoPeticion();
		ObtenerVehiculoRespuesta respuestaVehiculo = null;
		
		peticionVehiculo.setVehiculo(vehiculo);
		
		respuestaVehiculo = obtenerVehiculo(peticionVehiculo);
		
		if(!respuestaVehiculo.getListaVehiculos().isEmpty())
			return (Vehiculo)respuestaVehiculo.getListaVehiculos().get(0);
		else
			return null; 			
	}
	
	public ObtenerVehiculoRespuesta obtenerVehiculo(ObtenerVehiculoPeticion peticion) {
		ObtenerVehiculoRespuesta respuesta = null;
		
		try {
			respuesta = vehiculoService.obtenerVehiculo(peticion);
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar VehiculoService.obtenerVehiculo: "+e.getCause());
		}
	
		return respuesta;
	}

	public VehiculoService getVehiculoService() {
		return vehiculoService;
	}

	public void setVehiculoService(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}
}
