package com.arct.parking.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Vehiculo")
public class Vehiculo {
	
	@Id
	@Column(name="idVehiculo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	private int idVehiculo;
	
	@Column(name="modelo")
	@Basic(optional=false)
	private String modelo;
	
	@Column(name="marca")
	@Basic(optional=false)
	private String marca;
	
	@Column(name="noPlaca")
	@Basic(optional=false)
	private String noPlaca;
	
	@Column(name="tipoVehiculo")
	@Basic(optional=false)
	private String tipoVehiculo;
	
	@Column(name="fechaAlta")
	@Temporal(TemporalType.DATE)
	@Basic(optional=false)
	private Date fechaAlta;
	
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNoPlaca() {
		return noPlaca;
	}
	public void setNoPlaca(String noPlaca) {
		this.noPlaca = noPlaca;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
}
