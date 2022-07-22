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
	@Table(name="inventario")
	public class Inventario implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="idinventario")
		private int idinventario;
		@Column(name="categoria")
		private String categoria;
		@Column(name="entradas")
		private int entradas;
		@Column(name="salidas")
		private int salidas;
		@Column(name="descripcion")
		private String descripcion;
		
		
		@ManyToOne(cascade = CascadeType.MERGE)
		@JoinColumn(name =  "idproducto", referencedColumnName = "idproducto")
		private Producto idproducto;
		
		@OneToMany(mappedBy="idinventario")
		@NotFound(action = NotFoundAction.IGNORE)
		List<Administrador> listAdministrador;
		
		
		


		public List<Administrador> getListAdministrador() {
			return listAdministrador;
		}


		public void setListAdministrador(List<Administrador> listAdministrador) {
			this.listAdministrador = listAdministrador;
		}


		public int getIdinventario() {
			return idinventario;
		}


		public void setIdinventario(int idinventario) {
			this.idinventario = idinventario;
		}


		public String getCategoria() {
			return categoria;
		}


		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}


		public int getEntradas() {
			return entradas;
		}


		public void setEntradas(int entradas) {
			this.entradas = entradas;
		}


		public int getSalidas() {
			return salidas;
		}


		public void setSalidas(int salidas) {
			this.salidas = salidas;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


		public Producto getIdproducto() {
			return idproducto;
		}


		public void setIdproducto(Producto idproducto) {
			this.idproducto = idproducto;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		
		
		
		
		
		
		
	}
