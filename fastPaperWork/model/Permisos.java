package com.fastPaperWork.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table( name = "permisos")
public class Permisos implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpermisos")
	private int idpermisos;
	@Column(name="descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy="idpermisos")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Rol_has_permisos> listRol_has_permisos;

	public int getIdpermisos() {
		return idpermisos;
	}

	public void setIdpermisos(int idpermisos) {
		this.idpermisos = idpermisos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Rol_has_permisos> getListRol_has_permisos() {
		return listRol_has_permisos;
	}

	public void setListRol_has_permisos(List<Rol_has_permisos> listRol_has_permisos) {
		this.listRol_has_permisos = listRol_has_permisos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
	
}
