package com.arct.parking.dao.vehiculo.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arct.parking.dao.vehiculo.VehiculoDAO;
import com.arct.parking.dto.EliminarVehiculoPeticion;
import com.arct.parking.dto.InsertarVehiculoPeticion;
import com.arct.parking.dto.ModificarVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoPeticion;
import com.arct.parking.dto.ObtenerVehiculoRespuesta;
import com.arct.parking.model.Vehiculo;

@Repository(value="vehiculoDAO")
public class VehiculoDAOImpl implements VehiculoDAO {

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void insertarVehiculo(InsertarVehiculoPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Entrando a metodo Insertar Vehiculo");
			
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(peticion.getVehiculo());
		}catch(Exception e) {
			System.out.println("Error al ejecutar insertarVehiculo: "+e.getMessage());
			e.printStackTrace();
			throw new Exception("Error al ejecutar VehiculoDAO.insertarVehiculo: "+e.getCause());
		}
		
		
		System.out.println("Saliendo de metodo Insertar Vehiculo");
	}

	@Override
	public void modificarVehiculo(ModificarVehiculoPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo Modificar Vehiculo");
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(peticion.getVehiculo());			
		}catch(Exception e) {
			System.out.println("Error al ejecutar modificarRegistrVehiculo: "+e.getMessage());
			e.printStackTrace();
			throw new Exception("Error al ejecutar VehiculoDAO.modificarVehiculo");
		}
		
		System.out.println("Saliendo del metodo Modificar Vehiculo");
	}

	@Override
	public void eliminarVehiculo(EliminarVehiculoPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo Eliminar Vehiculo");
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Vehiculo vehiculo = (Vehiculo)session.load(Vehiculo.class, new Integer(peticion.getIdVehiculo()));
			if(vehiculo != null) {
				session.delete(vehiculo);
			}
		}catch(Exception e) {
			System.out.println("Error al ejecutar eliminarVehiculo: "+e.getMessage());
			e.printStackTrace();
			throw new Exception("Error al ejecutar VehiculoDAO.eliminarVehiculo");
		}
		
		System.out.println("Saliendo del metodo Eliminar Vehiculo");
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ObtenerVehiculoRespuesta obtenerVehiculo(ObtenerVehiculoPeticion peticion) throws Exception {
		System.out.println("Entrando al metodo Obtener Vehiculo");
		ObtenerVehiculoRespuesta respuesta = null;
		String query = null;
		try {
			respuesta = new ObtenerVehiculoRespuesta();
			query = construirQuery(peticion.getVehiculo(), peticion.getEnableLike());
			
			Session session = this.sessionFactory.getCurrentSession();			
			List<Vehiculo> listaVehiculos = session.createQuery(query).list();
			
			for(Vehiculo vehiculo : listaVehiculos){
				System.out.println("Vehiculo: "+vehiculo.getIdVehiculo());
			}
			respuesta.setListaVehiculos(listaVehiculos);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Error al ejecutar VehiculoDAO.obtenerVehiculo");
		}
		System.out.println("Saliendo del metodo Obtener Vehiculo");
		return respuesta;		
	}
	
	public String construirQuery(Vehiculo vehiculo, boolean enableLike) {
		StringBuilder query = new StringBuilder("from Vehiculo v where 1=1");
		
		if(vehiculo.getIdVehiculo() > 0)
			query.append(" and v.idVehiculo = ").append( vehiculo.getIdVehiculo() );
		if(vehiculo.getNoPlaca() != null)
			if(!enableLike)
				query.append(" and v.noPlaca = '").append(vehiculo.getNoPlaca()).append("' ");
			else
				query.append(" and v.noPlaca like '%").append(vehiculo.getNoPlaca()).append("%' ");
		if(vehiculo.getMarca() != null )
			query.append(" and v.marca = '").append(vehiculo.getMarca()).append("' ");
		if(vehiculo.getModelo() != null)
			query.append(" and v.modelo = '").append(vehiculo.getModelo()).append("' ");
		if(vehiculo.getTipoVehiculo() != null)
			query.append(" and v.tipoVehiculo = '").append(vehiculo.getTipoVehiculo()).append("' ");
		
		System.out.println("Query construido: "+query.toString());
		return query.toString();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
