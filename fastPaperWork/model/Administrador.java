package com.fastPaperWork.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="administrador")
public class Administrador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAdministrador")
	private int idAdministrador;
	@Column(name="RUT")
	private String RUT;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idinventario", referencedColumnName = "idinventario")
	private Inventario idinventario;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idusuario", referencedColumnName = "idusuario")
	private Usuario idusuario;

	@OneToMany(mappedBy="idadministrador")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Cotizacion> listCotizacion;
	
	@OneToMany(mappedBy="idadministrador")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Respuesta> listRespuesta;
	
	
	
	
	
	public Usuario getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}
	public List<Respuesta> getListRespuesta() {
		return listRespuesta;
	}
	public void setListRespuesta(List<Respuesta> listRespuesta) {
		this.listRespuesta = listRespuesta;
	}
	public List<Cotizacion> getListCotizacion() {
		return listCotizacion;
	}
	public void setListCotizacion(List<Cotizacion> listCotizacion) {
		this.listCotizacion = listCotizacion;
	}
	public Inventario getIdinventario() {
		return idinventario;
	}
	public void setIdinventario(Inventario idinventario) {
		this.idinventario = idinventario;
	}
	
	
	public int getIdAdministrador() {
		return idAdministrador;
	}
	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	public String getRUT() {
		return RUT;
	}
	public void setRUT(String rUT) {
		RUT = rUT;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


	

	
	
	
	
	
	
	
}
