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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idrol")
	private int idrol;
	@Column(name="ROL")
	private String ROL;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name =  "idusuario", referencedColumnName = "idusuario")
	private Usuario idusuario;
	
	@OneToMany(mappedBy="idrol")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Rol_has_permisos> listRol_has_permisos;

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getROL() {
		return ROL;
	}

	public void setROL(String rOL) {
		ROL = rOL;
	}

	public Usuario getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
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
