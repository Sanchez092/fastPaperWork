package com.fastPaperWork.model;

import java.io.Serializable;

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
@Table(name = "rol_has_permisos")
public class Rol_has_permisos implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "idpermisos")
	private Permisos idpermisos;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "idrol")
	private  Rol idrol;

	public Permisos getIdpermisos() {
		return idpermisos;
	}

	public void setIdpermisos(Permisos idpermisos) {
		this.idpermisos = idpermisos;
	}

	public Rol getIdrol() {
		return idrol;
	}

	public void setIdrol(Rol idrol) {
		this.idrol = idrol;
	}

	
	

}
