package com.arct.parking.dao.parking.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arct.parking.dao.parking.ModeloDAO;
import com.arct.parking.dto.EliminarModeloPeticion;
import com.arct.parking.dto.EliminarModeloRespuesta;
import com.arct.parking.dto.InsertarModeloPeticion;
import com.arct.parking.dto.InsertarModeloRespuesta;
import com.arct.parking.dto.ModificarModeloPeticion;
import com.arct.parking.dto.ModificarModeloRespuesta;
import com.arct.parking.dto.ObtenerModeloPeticion;
import com.arct.parking.dto.ObtenerModeloRespuesta;
import com.arct.parking.model.parking.Modelo;

@Repository(value="modeloDAO")
public class ModeloDAOImpl implements ModeloDAO {
	
	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public InsertarModeloRespuesta insertarModelo(InsertarModeloPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModificarModeloRespuesta modificarModelo(ModificarModeloPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EliminarModeloRespuesta eliminarModelo(EliminarModeloPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObtenerModeloRespuesta obtenerModelo(ObtenerModeloPeticion peticion) throws Exception {
		System.out.println("Entrando al metodo Obtener Modelo");
		ObtenerModeloRespuesta respuesta = null;
		String query = null;
		try {
			respuesta = new ObtenerModeloRespuesta();
			query = construirQuery(peticion.getModelo(), peticion.getEnableLike());
			
			Session session = this.sessionFactory.getCurrentSession();			
			List<Modelo> listaModelos = session.createQuery(query).list();
			
			for(Modelo modelo : listaModelos){
				System.out.println("Modelo: "+modelo.getIdModelo()+", Marca: "+modelo.getMarca().getMarca());
			}
			respuesta.setListaModelos(listaModelos);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Error al ejecutar ModeloDAO.obtenerModelo");
		}
		System.out.println("Saliendo del metodo Obtener Modelo");
		return respuesta;	
	}
	
	private String construirQuery(Modelo modelo, boolean enableLike) {
		StringBuilder query = new StringBuilder("from Modelo m where 1=1");		
		
		if(modelo != null){
			if(modelo.getIdModelo() != null)
				query.append(" and m.idModelo = ").append( modelo.getIdModelo() );
			if(modelo.getMarca() != null && modelo.getMarca().getIdMarca() != null )
				query.append(" and m.marca.idMarca = ").append( modelo.getMarca().getIdMarca() );						
		}
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
