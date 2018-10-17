package com.arct.parking.controller.parking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arct.parking.model.Vehiculo;

@Controller
@RequestMapping(value="/vehiculo/gestion")
public class VehiculoGestionController {
	
	@ModelAttribute("vehiculo")
	public Vehiculo createFormBean() {
		System.out.println(">>>>>>>>>>>>Entrando al createFormBean");
		return new Vehiculo();		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {
		System.out.println(">>>>>>>>>>>>Entrando al metodo Form");		
	}
}
