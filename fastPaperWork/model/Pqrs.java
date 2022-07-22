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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;



@Entity
@Table(name = "pqrs")
public class Pqrs implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpqrs")
	private int idpqrs;
	@Column(name="tipo")
	private String tipo;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name = "fechaHora")
	private Date fechaHora;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idcliente", referencedColumnName = "idcliente")
	private Cliente idcliente;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idrespuesta", referencedColumnName = "idrespuesta")
	private Respuesta idrespuesta;

	public int getIdpqrs() {
		return idpqrs;
	}

	public void setIdpqrs(int idpqrs) {
		this.idpqrs = idpqrs;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Cliente getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Cliente idcliente) {
		this.idcliente = idcliente;
	}

	public Respuesta getIdrespuesta() {
		return idrespuesta;
	}

	public void setIdrespuesta(Respuesta idrespuesta) {
		this.idrespuesta = idrespuesta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
