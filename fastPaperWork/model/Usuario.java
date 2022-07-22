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
@Table(name="usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario")
	private int idusuario;
	@Column(name="primer_nombre")
	private String primer_nombre;
	@Column(name="segundo_nombre")
	private String segundo_nombre;
	@Column(name="primer_apellidos")
	private String primer_apellidos;
	@Column(name="segundo_apellido")
	private String segundo_apellido;
	@Column(name="tipoIdentificacion")
	private String tipoIdentificacion;
	@Column(name="noIdentificacion")
	private int noIdentificacion;
	@Column(name="telefono")
	private int telefono;
	@Column(name="direccion")
	private String direccion;
	@Column(name="rol")
	private String rol;


	@OneToMany(mappedBy="idusuario")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Administrador> listAdministrador;
	
	@OneToMany(mappedBy="idusuario")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Cliente> listCliente;
	
	@OneToMany(mappedBy="idusuario")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Rol> listRol;
	
	
	

	public List<Rol> getListRol() {
		return listRol;
	}

	public void setListRol(List<Rol> listRol) {
		this.listRol = listRol;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getPrimer_apellidos() {
		return primer_apellidos;
	}

	public void setPrimer_apellidos(String primer_apellidos) {
		this.primer_apellidos = primer_apellidos;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public int getNoIdentificacion() {
		return noIdentificacion;
	}

	public void setNoIdentificacion(int noIdentificacion) {
		this.noIdentificacion = noIdentificacion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Administrador> getListAdministrador() {
		return listAdministrador;
	}

	public void setListAdministrador(List<Administrador> listAdministrador) {
		this.listAdministrador = listAdministrador;
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
	


	
	

}



