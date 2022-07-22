package com.fastPaperWork.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "seguimiento_envio")

public class SeguimientoEnvio implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idseguimiento_envio")
	private int idseguimiento_envio;
	@Column(name="referencia_envio")
	private int referencia_envio;
	@Column(name="fechaInicio")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@Column(name="fechaFin")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	@Column(name="destino")
	private String destino;
	

	@OneToMany(mappedBy="idseguimiento_envio")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Pedido> listPedido;

	public List<Pedido> getListPedido() {
		return listPedido;
	}
	public void setListPedido(List<Pedido> listPedido) {
		this.listPedido = listPedido;
	}
	public int getIdseguimiento_envio() {
		return idseguimiento_envio;
	}
	public void setIdseguimiento_envio(int idseguimiento_envio) {
		this.idseguimiento_envio = idseguimiento_envio;
	}
	public int getReferencia_envio() {
		return referencia_envio;
	}
	public void setReferencia_envio(int referencia_envio) {
		this.referencia_envio = referencia_envio;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SeguimientoEnvio [idseguimiento_envio=" 
	+ idseguimiento_envio + ", referencia_envio=" + referencia_envio + 
	", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", destino=" + destino +"]";
	}
	public SeguimientoEnvio(int idseguimiento_envio, int referencia_envio,
			Date fechaInicio, Date fechaFin, String destino) {
		super();
		this.idseguimiento_envio = idseguimiento_envio;
		this.referencia_envio = referencia_envio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.destino = destino;	
	}
	public SeguimientoEnvio() {
		super();
	}

}
