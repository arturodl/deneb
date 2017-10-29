package com.arct.parking.controller.bitacora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arct.parking.dto.ObtenerRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroRespuesta;
import com.arct.parking.service.bitacora.BitacoraService;

@Controller
public class ResumenController {
	
	@Autowired
	private BitacoraService bitacoraService;
	
	@RequestMapping(value="/todoregistros", method=RequestMethod.GET)
	public String mostrarTodosLosRegistros(ModelMap model) {
		System.out.println("Obteniendo Registros");
		
		ObtenerRegistroPeticion peticion = new ObtenerRegistroPeticion();
		ObtenerRegistroRespuesta respuesta = null;
		try {
			respuesta = bitacoraService.obtenerRegistro(peticion);
			model.addAttribute( "listaRegistros",respuesta.getListaRegistros() );
			model.addAttribute("mostrarEditar", true);
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar BitacoraService.obtenerRegistro: "+e.getCause());
			e.printStackTrace();
		}
		
		return "bitacora/resumen";
	}

	public BitacoraService getBitacoraService() {
		return bitacoraService;
	}

	public void setBitacoraService(BitacoraService bitacoraService) {
		this.bitacoraService = bitacoraService;
	}
}
