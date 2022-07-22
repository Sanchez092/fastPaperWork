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
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="respuesta")
public class Respuesta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idrespuesta")
	private int idrespuesta;
	@Column(name="respuesta")
	private String respuesta;
	
	@OneToMany(mappedBy="idrespuesta")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Pqrs> listPqrs;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idadministrador", referencedColumnName = "idAdministrador")
	private Administrador idadministrador;
	
	

	
	public Administrador getIdadministrador() {
		return idadministrador;
	}
	public void setIdadministrador(Administrador idadministrador) {
		this.idadministrador = idadministrador;
	}
	public List<Pqrs> getListPqrs() {
		return listPqrs;
	}
	public void setListPqrs(List<Pqrs> listPqrs) {
		this.listPqrs = listPqrs;
	}
	public int getIdrespuesta() {
		return idrespuesta;
	}
	public void setIdrespuesta(int idrespuesta) {
		this.idrespuesta = idrespuesta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}