package com.arct.parking.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class Usuario extends Entidad {
	
	@Id
	@Column(name="username")
	@Basic(optional=false)
	private String username;
	
	@Column(name="password")
	@Basic(optional=false)
	private String password;
	
	@Column(name="enabled")
	@Basic(optional=false)
	private byte enabled;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private List<UsuarioRole> usuarioRoles;	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getEnabled() {
		return enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public List<UsuarioRole> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(List<UsuarioRole> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

}
