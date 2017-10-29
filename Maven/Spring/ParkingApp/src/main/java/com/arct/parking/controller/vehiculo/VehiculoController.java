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
import com.arct.parking.model.Vehiculo;
import com.arct.parking.service.vehiculo.VehiculoService;

@Controller
public class VehiculoController {
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
	  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
	  binder.registerCustomEditor(Date.class, orderDateEditor);
	}
	
	@RequestMapping(value="/gestionarvehiculo", method=RequestMethod.POST)
	public String gestionarVehiculo(ModelMap model, @ModelAttribute Vehiculo vehiculo) {
		System.out.println("Gestionar Vehiculo");
				
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

	public VehiculoService getVehiculoService() {
		return vehiculoService;
	}

	public void setVehiculoService(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}
}
