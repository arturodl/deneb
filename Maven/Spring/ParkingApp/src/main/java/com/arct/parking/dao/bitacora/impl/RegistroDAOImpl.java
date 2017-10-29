package com.arct.parking.dao.bitacora.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.arct.parking.dao.bitacora.RegistroDAO;
import com.arct.parking.dto.EliminarRegistroPeticion;
import com.arct.parking.dto.InsertarRegistroPeticion;
import com.arct.parking.dto.ModificarRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroPeticion;
import com.arct.parking.dto.ObtenerRegistroRespuesta;
import com.arct.parking.model.Registro;

@Repository
public class RegistroDAOImpl implements RegistroDAO {

	private SessionFactory sessionFactory;
	
	@Override
	public void insertarRegistro(InsertarRegistroPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Entrado a metodo Insertar Registro");
			
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(peticion.getRegistro());
		}catch(Exception e) {
			System.out.println("Error al ejecutar insertarRegistro: "+e.getMessage());
			e.printStackTrace();
			throw new Exception("Error al ejecutar RegistroDAO.insertarRegistro: "+e.getCause());
		}
		
		
		System.out.println("Saliendo de metodo Insertar Registro");
	}

	@Override
	public void modificarRegistro(ModificarRegistroPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo Modificar Registro");
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(peticion.getRegistro());			
		}catch(Exception e) {
			System.out.println("Error al ejecutar modificarRegistro: "+e.getMessage());
			e.printStackTrace();
			throw new Exception("Error al ejecutar RegistroDAO.modificarRegistro");
		}
		
		System.out.println("Saliendo del metodo Modificar Registro");
	}

	@Override
	public void eliminarRegistro(EliminarRegistroPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Entrando al metodo Eliminar Registro");
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Registro registro = (Registro)session.load(Registro.class, new Integer(peticion.getIdRegistro()));
			if(registro != null) {
				session.delete(registro);
			}
		}catch(Exception e) {
			System.out.println("Error al ejecutar eliminarRegistro: "+e.getMessage());
			e.printStackTrace();
			throw new Exception("Error al ejecutar RegistroDAO.eliminarRegistro");
		}
		
		System.out.println("Saliendo del metodo Eliminar Registro");
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ObtenerRegistroRespuesta obtenerRegistro(ObtenerRegistroPeticion peticion) throws Exception {
		System.out.println("Entrando al metodo Obtener Registro");
		ObtenerRegistroRespuesta respuesta = null;
		String query = null;
		try {
			respuesta = new ObtenerRegistroRespuesta();
			Session session = this.sessionFactory.getCurrentSession();	
			
			query = construirQuery(peticion.getIdRegistro());
			List<Registro> listaRegistros = session.createQuery(query).list();
			
			for(Registro registro : listaRegistros){
				System.out.println("Registro: "+registro.getIdRegistro());
			}
			respuesta.setListaRegistros(listaRegistros);
		}catch(Exception e) {
			System.out.println("Error al ejecutar RegistroDAO.obtenerRegistro: "+e.getMessage());
			e.printStackTrace();
			throw new Exception("Error al ejecutar RegistroDAO.obtenerRegistro");
		}
		System.out.println("Saliendo del metodo Obtener Registro");
		return respuesta;		
	}
	
	public String construirQuery(int idRegistro) {
		StringBuilder query = new StringBuilder(" from Registro r where 1=1  ");
		
		if(idRegistro > 0)
			query.append(" and r.idRegistro = ").append(idRegistro);
				
		return query.toString();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
