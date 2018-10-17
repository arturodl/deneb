package com.arct.parking.model.parking;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.arct.parking.model.Entidad;

@Entity
@Table(name="Vehiculo")
public class Vehiculo extends Entidad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idVehiculo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	private int idVehiculo;
		
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
	
	@JoinColumn(name="idModelo", referencedColumnName="idModelo")
	@ManyToOne(fetch=FetchType.EAGER)
	private Modelo modelo;
	
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
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
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
