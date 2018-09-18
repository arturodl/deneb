package com.arct.parking.controller.bitacora;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arct.parking.dto.InsertarRegistroPeticion;
import com.arct.parking.dto.ModificarRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroRespuesta;
import com.arct.parking.dto.ObtenerVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoRespuesta;
import com.arct.parking.model.Registro;
import com.arct.parking.model.Vehiculo;
import com.arct.parking.service.bitacora.BitacoraService;
import com.arct.parking.service.vehiculo.VehiculoService;

@Controller
@RequestMapping(value="/bitacora")
public class BitacoraController {
	
	@Autowired
	private BitacoraService bitacoraService;
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
	  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
	  binder.registerCustomEditor(Date.class, orderDateEditor);  
	}
	
	@ModelAttribute // This is for always setting values by default
    public void addAttributes(ModelMap model) {
		model.addAttribute("mostrarFormulario", true);
    }
	
	@RequestMapping(value="/agregar", method =RequestMethod.GET)
	public String gestionarBitacora(ModelMap model, @ModelAttribute Registro registro) {		
		model.addAttribute("disableBtnExecute", false);
		model.addAttribute("capturePlateNumber", true);
		model.addAttribute("showCheckInDatesEnabled", true);
		model.addAttribute("captureCheckOut", false);
		return "bitacora/binaccle-manage";
	}
	
	@RequestMapping(value="/editar/{idRegistro}", method=RequestMethod.GET)
	public String mostrarRegistro(@PathVariable("idRegistro") int idRegistro, ModelMap model, @ModelAttribute Registro registro ) {
		System.out.println("Id Recuperado: "+idRegistro);
		
		Registro registroABuscar = new Registro();
		registroABuscar.setIdRegistro(idRegistro);
		registroABuscar = obtenerRegistro(registroABuscar);
		model.addAttribute("registro", registroABuscar);
		model.addAttribute("disableBtnExecute", false);
		model.addAttribute("capturePlateNumber", false);
		model.addAttribute("showCheckInDatesEnabled", false);
		model.addAttribute("showCheckOutDatesEnabled", true);
		model.addAttribute("captureCheckOut", true);
				
		System.out.println("Registro vehiculo: "+registroABuscar.getVehiculo().getIdVehiculo());
		return "bitacora/binaccle-manage";
	}
		
	@RequestMapping(value="/ejecutar", method=RequestMethod.POST)
	public String ejecutarAccion(ModelMap model, @ModelAttribute Registro registro) {
		System.out.println("Running Actions for Record, model its size?: "+model.size());		
						
		InsertarRegistroPeticion peticionInsertar = new InsertarRegistroPeticion();
		ModificarRegistroPeticion peticionModificar = new ModificarRegistroPeticion();
		Vehiculo vehiculo = null;
		try {	
			System.out.println("Antes de dar de gestionar el registro el id es: "+registro.getIdRegistro());
			System.out.println("Antes de dar de gestionar el vehiculo es: "+registro.getVehiculo().getIdVehiculo());
			System.out.println("Antes de dar de gestionar el vehiculo es: "+registro.getVehiculo().getNoPlaca());
			
			if(registro.getIdRegistro() == 0) {
				vehiculo = new Vehiculo();
				vehiculo.setNoPlaca( registro.getVehiculo().getNoPlaca() );
				vehiculo = obtenerVehiculo( vehiculo );
				
				if(vehiculo != null) {
					registro.setVehiculo(vehiculo);
					registro.setStatus("I");
					peticionInsertar.setRegistro(registro);
					bitacoraService.insertarRegistro(peticionInsertar);	
					model.addAttribute("disableBtnExecute", true);
					model.addAttribute("capturePlateNumber", false);
					model.addAttribute("showCheckInDatesEnabled", false);
					model.addAttribute("success","La entrada fue registrada con exito, haga click en regresar para volver a la pantalla principal");
				}else {				
					model.addAttribute("disableBtnExecute", false);
					model.addAttribute("capturePlateNumber", true);
					model.addAttribute("showCheckInDatesEnabled", true);
					model.addAttribute("error","No se puede insertar el registro ya que el numero de placa no existe, verifique nuevamente.");
				}
				model.addAttribute("captureCheckOut", false);
				
			}else if(registro.getIdRegistro() > 0){
				registro.setStatus("O");
				peticionModificar.setRegistro(registro);
				
				bitacoraService.modificarRegistro(peticionModificar);
				
				model.addAttribute("disableBtnExecute", true);
				model.addAttribute("capturePlateNumber", false);
				model.addAttribute("showCheckInDatesEnabled", false);
				model.addAttribute("showCheckOutDatesEnabled", false);
				model.addAttribute("captureCheckOut", true);
				model.addAttribute("success","La salida fue registrada con exito, haga click en regresar para volver a la pantalla principal.");
			}else{
				throw new Exception("No se han definido las acciones a realizar con el registro");
			}
			
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar BitacoraService.insertarRegistro, favor de checar el log: "+e.getMessage());
			model.addAttribute("disableBtnExecute", true);
			model.addAttribute("capturePlateNumber", false);
			model.addAttribute("showCheckInDatesEnabled", false);
			model.addAttribute("showCheckOutDatesEnabled", false);
			model.addAttribute("showNoAcces", true);
			model.addAttribute("error","Hubo un error al invocar BitacoraService.insertarRegistro: "+e.getCause());
			e.printStackTrace();
		}
		
		model.addAttribute("mostrarFormulario",true);
		return "bitacora/binaccle-manage";
	}
	
	@RequestMapping(value="/resumen", method=RequestMethod.GET)
	public String mostrarTodosLosRegistros(ModelMap model) {
		System.out.println("Obteniendo Registros");
		
		ObtenerRegistroPeticion peticion = new ObtenerRegistroPeticion();
		ObtenerRegistroRespuesta respuesta = null;
		try {
			respuesta = bitacoraService.obtenerRegistro(peticion);
			model.addAttribute( "listaRegistros",respuesta.getListaRegistros() );			
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar BitacoraService.obtenerRegistro: "+e.getCause());
			e.printStackTrace();
		}
		
		return "bitacora/binaccle-resume";
	}
	
	public Registro obtenerRegistro(Registro registro) {
		ObtenerRegistroPeticion peticionRegistro = new ObtenerRegistroPeticion();
		ObtenerRegistroRespuesta respuestaRegistro = null;
		
		peticionRegistro.setIdRegistro(registro.getIdRegistro());
		
		respuestaRegistro = obtenerRegistro(peticionRegistro);
		
		if(!respuestaRegistro.getListaRegistros().isEmpty())
			return (Registro) respuestaRegistro.getListaRegistros().get(0);
		else
			return null;
	}
	
	public ObtenerRegistroRespuesta obtenerRegistro(ObtenerRegistroPeticion peticion) {
		ObtenerRegistroRespuesta respuesta = null;
		
		try {
			respuesta = bitacoraService.obtenerRegistro(peticion);
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar BitacoraService.obtenerRegistro: "+e.getCause());
		}
		return respuesta;
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
	
	@RequestMapping(value="/getVehiclesByCriteria", method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ObtenerVehiculoRespuesta obtenerVehiculo(@RequestBody ObtenerVehiculoPeticion peticion) {
		System.out.println("Invocando al servicio ObtenerVehiculo");
		ObtenerVehiculoRespuesta respuesta = null;
		
		try {
			respuesta = vehiculoService.obtenerVehiculo(peticion);
		}catch(Exception e) {
			System.out.println("Hubo un error al invocar VehiculoService.obtenerVehiculo: "+e.getCause());
		}
	
		return respuesta;
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
