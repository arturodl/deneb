package com.arct.parking.dao.usuario.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arct.parking.dao.usuario.UsuarioDAO;
import com.arct.parking.dto.EliminarUsuarioPeticion;
import com.arct.parking.dto.EliminarUsuarioRespuesta;
import com.arct.parking.dto.InsertarUsuarioPeticion;
import com.arct.parking.dto.InsertarUsuarioRespuesta;
import com.arct.parking.dto.ModificarUsuarioPeticion;
import com.arct.parking.dto.ModificarUsuarioRespuesta;
import com.arct.parking.dto.ObtenerUsuariosPorCriterioPeticion;
import com.arct.parking.dto.ObtenerUsuariosPorCriterioRespuesta;
import com.arct.parking.model.Usuario;

@Repository(value="usuarioDAO")
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public InsertarUsuarioRespuesta insertarUsuario(InsertarUsuarioPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModificarUsuarioRespuesta modificarUsuario(ModificarUsuarioPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EliminarUsuarioRespuesta eliminarUsuario(EliminarUsuarioPeticion peticion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObtenerUsuariosPorCriterioRespuesta obtenerUsuariosPorCriterio(ObtenerUsuariosPorCriterioPeticion peticion) throws Exception {
		System.out.println("Entrando al metodo Obtener Usuarios: "+ peticion.getUsuario());
		ObtenerUsuariosPorCriterioRespuesta respuesta = null;
		String query = null;
		try {
			respuesta = new ObtenerUsuariosPorCriterioRespuesta();
			query = construirQuery(peticion.getUsuario(), peticion.getEnableLike());
			
			Session session = this.sessionFactory.getCurrentSession();			
			List<Usuario> listaUsuarios = session.createQuery(query).list();
			
			for(Usuario usuario : listaUsuarios){
				System.out.println("Usuario: "+usuario.getUsername());
			}
			respuesta.setListaUsuarios(listaUsuarios);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Error al ejecutar UsuarioDAO.obtenerUsuario");
		}
		System.out.println("Saliendo del metodo Obtener Usuarios");
		return respuesta;	
	}
	
	private String construirQuery(Usuario usuario, boolean enableLike) {
		StringBuilder query = new StringBuilder("from Usuario user where 1=1");
		
		if(usuario != null){
			if(enableLike && usuario.getUsername() != null)
				query.append(" and user.username like '%").append(usuario.getUsername()).append("%' ");
			else if(!enableLike && usuario.getUsername() != null)
				query.append(" and user.username = '").append(usuario.getUsername()).append("' ");
			
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
