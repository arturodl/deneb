package com.arct.parking.application.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.arct.parking.dto.ObtenerUsuariosPorCriterioPeticion;
import com.arct.parking.model.Usuario;
import com.arct.parking.model.UsuarioRole;
import com.arct.parking.service.security.UsuarioService;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = obtenerUsuarioPorNombre(username);
		
		List<GrantedAuthority> authorities = buildUserAuthority(usuario.getUsuarioRoles());
		
		return buildUserForAuthentication(usuario, authorities);		
	}
	
	private User buildUserForAuthentication(Usuario usuario, List<GrantedAuthority> authorities) {
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled() == 1 , 
	                    true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<UsuarioRole> listaUsuarioRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UsuarioRole usuarioRole : listaUsuarioRoles) {
			setAuths.add(new SimpleGrantedAuthority(usuarioRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
	
	private Usuario obtenerUsuarioPorNombre(String username) throws UsernameNotFoundException {
		System.out.println("El nombre de usuario a buscar es: "+username);
		ObtenerUsuariosPorCriterioPeticion peticion = new ObtenerUsuariosPorCriterioPeticion();
			
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario.setEnabled((byte)1);
		
		peticion.setUsuario(usuario);
				
		try {
			List<Usuario> listaUsuarios = usuarioService.obtenerUsuariosPorCriterio(peticion).getListaUsuarios();	
			
			if(listaUsuarios.size() <= 0) {
				throw new UsernameNotFoundException(username);
			}
			
			usuario = listaUsuarios.get(0);			
			System.out.println("Total de usuarios obtenidos: "+listaUsuarios.size());
			return usuario;			
		}catch(Exception e){
			e.printStackTrace();	
			throw new UsernameNotFoundException(username);
		}		
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
