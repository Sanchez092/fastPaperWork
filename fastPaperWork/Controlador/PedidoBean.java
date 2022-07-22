package com.fastPaperWork.Controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.fastPaperWork.DAO.ClienteDAO;
import com.fastPaperWork.DAO.Forma_de_pagoDAO;
import com.fastPaperWork.DAO.PedidoDAO;
import com.fastPaperWork.DAO.SeguimientoEnvioDAO;
import com.fastPaperWork.model.Cliente;
import com.fastPaperWork.model.Forma_de_pago;
import com.fastPaperWork.model.Pedido;
import com.fastPaperWork.model.SeguimientoEnvio;

import javax.faces.context.FacesContext;

@ManagedBean(name = "pedidoBean")
@RequestScoped
@SessionScoped

public class PedidoBean {
	
	Pedido pedido = new Pedido();
	private List<Pedido> obtenerPedidos = new ArrayList<Pedido>();
	
	private int idcliente;
	
	public List<Cliente> listaCliente;
	
	private int idseguimiento_envio;
	
	public List<SeguimientoEnvio> listaSeguimientoEnvio;
	
	private int idforma_de_pago;
	
	public List<Forma_de_pago> listaForma_de_pago;
	
	public void llenarCliente() {
		ClienteDAO clienteDAO = new ClienteDAO();
		this.listaCliente=clienteDAO.obtenerCliente();
	}
	
	public void llenarSeguimientoEnvio() {
		SeguimientoEnvioDAO seguimientoEnvioDAO = new SeguimientoEnvioDAO();
		this.listaSeguimientoEnvio=seguimientoEnvioDAO.obtenerSeguimientoEnvio();
	}
	
	public void llenarFormadePago() {
		Forma_de_pagoDAO forma_de_pagoDAO = new Forma_de_pagoDAO();
		this.listaForma_de_pago=forma_de_pagoDAO.obtenerForma_de_pago();
	}
	
	public PedidoBean() {
		this.llenarCliente();
		this.llenarSeguimientoEnvio();
		this.llenarFormadePago();
	}
	
	

	public int getIdforma_de_pago() {
		return idforma_de_pago;
	}

	public void setIdforma_de_pago(int idforma_de_pago) {
		this.idforma_de_pago = idforma_de_pago;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdseguimiento_envio() {
		return idseguimiento_envio;
	}

	public void setIdseguimiento_envio(int idseguimiento_envio) {
		this.idseguimiento_envio = idseguimiento_envio;
	}

	public String nuevo() {
		Pedido p = new Pedido();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("pedido", p);
		return "/vistas/Pedido/add.xhtml?faces-redirect=true";
	}
	public String guardar(Pedido pedido) {
		Date fechaActual = new Date();
		pedido.setFecha(new java.sql.Date(fechaActual.getTime()));
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		pedido.setIdcliente(cliente);
		cliente = clienteDAO.buscar(idcliente);
		
		SeguimientoEnvioDAO seguimientoEnvioDAO = new SeguimientoEnvioDAO();
		SeguimientoEnvio seguimientoEnvio = new SeguimientoEnvio();
		pedido.setIdseguimiento_envio(seguimientoEnvio);
		seguimientoEnvio = seguimientoEnvioDAO.buscar(idseguimiento_envio);
		
		Forma_de_pagoDAO forma_de_pagoDAO = new Forma_de_pagoDAO();
		Forma_de_pago forma_de_pago = new Forma_de_pago();
		pedido.setIdforma_de_pago(forma_de_pago);
		forma_de_pago = forma_de_pagoDAO.buscar(idforma_de_pago);
		
		pedidoDAO.guardar(pedido);
		return "/vistas/Pedido/index.xhtml?faces-redirect=true";
	}
	public List<Pedido> obtenerPedidos(){
		PedidoDAO pedidoDAO = new PedidoDAO();
		return pedidoDAO.obtenerPedidos();
		
	}
	public String editar(int idpedido) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido p = new Pedido();
		p=pedidoDAO.buscar(idpedido);
		System.out.println(p);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("pedido", p);
		return "/vistas/Pedido/editar.xhtml?faces-redirect=true";	
	}
	public String actualizar(Pedido pedido) {
		 PedidoDAO pedidoDAO = new PedidoDAO();
		 pedidoDAO.editar(pedido);
		 return "/vistas/Pedido/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idpedido) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.eliminar(idpedido);
		System.out.println("Pedido eliminado...");
		return "/vistas/Pedido/index.xhtml?faces-redirect=true";
		
	}

}