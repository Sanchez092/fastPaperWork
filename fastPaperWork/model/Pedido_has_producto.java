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
@Table(name = "pedido_has_producto")

public class Pedido_has_producto implements Serializable{


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@ManyToOne(cascade = CascadeType.ALL, optional = false)
		@JoinColumn(name = "idpedido")
		private Pedido idpedido;
		
		@ManyToOne(cascade = CascadeType.ALL, optional = false)
		@JoinColumn(name = "idproducto")
		private  Producto idproducto;

		public Pedido getIdpedido() {
			return idpedido;
		}

		public void setIdpedido(Pedido idpedido) {
			this.idpedido = idpedido;
		}

		public Producto getIdproducto() {
			return idproducto;
		}

		public void setIdproducto(Producto idproducto) {
			this.idproducto = idproducto;
		}
		
		

		
}
	
