package com.fastPaperWork.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="forma_de_pago")
public class Forma_de_pago implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idforma_de_pago")
	private int idforma_de_pago;
	@Column(name="forma_de_pago")
	private String forma_de_pago;
	
	@OneToMany(mappedBy="idforma_de_pago")
	@NotFound(action = NotFoundAction.IGNORE)
	List<Pedido> listPedido;

	public int getIdforma_de_pago() {
		return idforma_de_pago;
	}

	public void setIdforma_de_pago(int idforma_de_pago) {
		this.idforma_de_pago = idforma_de_pago;
	}

	public String getForma_de_pago() {
		return forma_de_pago;
	}

	public void setForma_de_pago(String forma_de_pago) {
		this.forma_de_pago = forma_de_pago;
	}

	public List<Pedido> getListPedido() {
		return listPedido;
	}

	public void setListPedido(List<Pedido> listPedido) {
		this.listPedido = listPedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Forma_de_pago() {
		
	}
	
	
	
}