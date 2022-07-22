package com.fastPaperWork.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="calificacion")
public class Calificacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcalificacion")
	private int idcalificacion;
	@Column(name="fechaHora")
	private Date fechaHora;
	@Column(name="puntuacion")
	private int puntuacion;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idcliente", referencedColumnName = "idcliente")
	private Cliente idcliente;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idventa", referencedColumnName = "idventa")
	private Venta idventa;

	public int getIdcalificacion() {
		return idcalificacion;
	}

	public void setIdcalificacion(int idcalificacion) {
		this.idcalificacion = idcalificacion;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Cliente getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Cliente idcliente) {
		this.idcliente = idcliente;
	}

	public Venta getIdventa() {
		return idventa;
	}

	public void setIdventa(Venta idventa) {
		this.idventa = idventa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}