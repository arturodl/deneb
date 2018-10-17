package com.arct.parking.controller.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arct.parking.dto.ObtenerModeloPeticion;
import com.arct.parking.dto.ObtenerModeloRespuesta;
import com.arct.parking.service.parking.ModeloService;

@Controller
@RequestMapping(value="/modelo")
public class ModeloController {
	
	@Autowired
	private ModeloService modeloService;
	
	@RequestMapping(value="/getModelsByCriteria", method = RequestMethod.POST,
					consumes={MediaType.APPLICATION_JSON_VALUE},
					produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ObtenerModeloRespuesta obtenerModelos(@RequestBody ObtenerModeloPeticion peticion){
		System.out.println("Entrando al metodo obtenerMarcas, IdModelo es: "+peticion.getModelo().getIdModelo());
		System.out.println("Invocando al servicio ObtenerModelo, peticion.enableLike es: "+peticion.getEnableLike());
		
		ObtenerModeloRespuesta respuesta = null;
		
		try {
			respuesta = modeloService.obtenerModelo(peticion);
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar ModeloController.obtenerModelos: "+e.getCause());
		}
	
		return respuesta;
	}
	
	@RequestMapping(value="/testSecurity", method = RequestMethod.GET)
	@ResponseBody
	public String testModelo() {
		return "Welcome to modelo";
	}

	public ModeloService getModeloService() {
		return modeloService;
	}

	public void setModeloService(ModeloService modeloService) {
		this.modeloService = modeloService;
	}

}
