package com.fastPaperWork.Controlador;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import com.fastPaperWork.DAO.ClienteDAO;
import com.fastPaperWork.DAO.ProveedorDAO;
import com.fastPaperWork.DAO.UsuarioDAO;
import com.fastPaperWork.model.Cliente;
import com.fastPaperWork.model.Usuario;

import javax.faces.context.FacesContext;

@ManagedBean(name = "clienteBean")
@RequestScoped
@SessionScoped

public class ClienteBean {
Cliente cliente = new Cliente();
	
	Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	private int idusuario;
	private List<Usuario> listUsuario;
	
	private void llenarUsuario() {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		this.listUsuario = usuarioDAO.obtenerUsuarios();
	}
		
	public ClienteBean() {
		
		this.llenarUsuario();
	}


	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String nuevo() {
		Cliente cl = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", cl);
		return "/vistas/Cliente/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		cliente.setIdusuario(usuario);
		usuario = usuarioDAO.buscar(idusuario);
		
		
		clienteDAO.guardar(cliente);
		return "/vistas/Cliente/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Cliente> obtenerCliente(){
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.obtenerCliente();
		
	}
	
	public String editar(int idcliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cl = new Cliente();
		cl=clienteDAO.buscar(idcliente);
		System.out.println(cl);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", cl);
		return "/vistas/Cliente/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Cliente cliente) {
		 ClienteDAO clienteDAO = new ClienteDAO();
		 clienteDAO.editar(cliente);
		 return "/vistas/Cliente/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idcliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(idcliente);
		System.out.println("Cliente eliminado..");
		return "/vistas/Cliente/index.xhtml?faces-redirect=true";
		
	}
	 
}
