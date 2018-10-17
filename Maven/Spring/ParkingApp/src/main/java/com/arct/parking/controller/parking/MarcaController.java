package com.arct.parking.controller.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arct.parking.dto.ObtenerMarcaPeticion;
import com.arct.parking.dto.ObtenerMarcaRespuesta;
import com.arct.parking.service.parking.MarcaService;

@Controller
@RequestMapping(value="/marca")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@RequestMapping(value="/getBrandsByCriteria", method=RequestMethod.POST,
					consumes={MediaType.APPLICATION_JSON_VALUE},
					produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ObtenerMarcaRespuesta obtenerMarcas(@RequestBody ObtenerMarcaPeticion peticion){
		//System.out.println("Entrando al metodo obtenerMarcas, IdModelo es: "+peticion.getMarca().getIdMarca());
		ObtenerMarcaRespuesta respuesta = null;
		try{
			respuesta = marcaService.obtenerMarca(peticion);
		}catch(Exception e){
			System.out.println("Hubo un error al invocar MarcaController.obtenerMarcas: "+e.getCause());
		}
		return respuesta;
	}

	public MarcaService getMarcaService() {
		return marcaService;
	}

	public void setMarcaService(MarcaService marcaService) {
		this.marcaService = marcaService;
	}

}
