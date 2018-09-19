package com.arct.parking.dao.marca.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arct.parking.dao.marca.MarcaDAO;
import com.arct.parking.dto.EliminarMarcaPeticion;
import com.arct.parking.dto.EliminarMarcaRespuesta;
import com.arct.parking.dto.InsertarMarcaPeticion;
import com.arct.parking.dto.InsertarMarcaRespuesta;
import com.arct.parking.dto.ModificarMarcaPeticion;
import com.arct.parking.dto.ModificarMarcaRespuesta;
import com.arct.parking.dto.ObtenerMarcaPeticion;
import com.arct.parking.dto.ObtenerMarcaRespuesta;
import com.arct.parking.model.Marca;

@Repository(value="marcaDAO")
public class MarcaDAOImpl implements MarcaDAO {
	
	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public InsertarMarcaRespuesta insertarMarca(InsertarMarcaPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModificarMarcaRespuesta modificarMarca(ModificarMarcaPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EliminarMarcaRespuesta eliminarMarca(EliminarMarcaPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObtenerMarcaRespuesta obtenerMarca(ObtenerMarcaPeticion peticion) throws Exception {
		System.out.println("Entrando al metodo Obtener Marca");
		ObtenerMarcaRespuesta respuesta = null;
		String query = null;
		try {
			respuesta = new ObtenerMarcaRespuesta();
			query = construirQuery(peticion.getMarca(), peticion.getEnableLike());
			
			Session session = this.sessionFactory.getCurrentSession();			
			List<Marca> listaMarcas = session.createQuery(query).list();
			
			for(Marca marca : listaMarcas){
				System.out.println("Marca: "+marca.getMarca());
			}
			respuesta.setListaMarcas(listaMarcas);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Error al ejecutar MarcaDAO.obtenerMarca");
		}
		System.out.println("Saliendo del metodo Obtener Marca");
		return respuesta;	
	}
	
	private String construirQuery(Marca marca, boolean enableLike) {
		StringBuilder query = new StringBuilder("from Marca m where 1=1");
		
		if(marca != null){
			if(marca.getIdMarca() > 0)
				query.append(" and m.idMarca = ").append( marca.getIdMarca() );	
			if(enableLike && marca.getMarca() != null)
				query.append(" and m.marca like '%").append(marca.getMarca()).append("%' ");
		}
		System.out.println("Query construido: "+query.toString());
		return query.toString();
	}
}
