package com.fastPaperWork.Controlador;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import com.fastPaperWork.DAO.InventarioDAO;
import com.fastPaperWork.DAO.ProductoDAO;
import com.fastPaperWork.model.Inventario;
import com.fastPaperWork.model.Producto;

import javax.faces.context.FacesContext;

@ManagedBean(name = "inventarioBean")
@RequestScoped
@SessionScoped

public class InventarioBean {
Inventario inventario = new Inventario();
	
	Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	private int idproducto;
	private List<Producto> listProducto;
	
	private void llenarProducto() {
		
		ProductoDAO productoDAO = new ProductoDAO();
		this.listProducto = productoDAO.obtenerProducto();
	}
		
	public InventarioBean() {
		
		this.llenarProducto();
	}


	public List<Producto> getListProducto() {
		return listProducto;
	}

	public void setListProveedor(List<Producto> listProducto) {
		this.listProducto = listProducto;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	
	
	public String nuevo() {
		Inventario i = new Inventario();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("inventario", i);
		return "/vistas/Inventario/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Inventario inventario) {
		InventarioDAO inventarioDAO = new InventarioDAO();
		ProductoDAO productoDAO = new ProductoDAO();
		Producto producto = new Producto(); 
		producto = productoDAO.buscar(idproducto);
		inventario.setIdproducto(producto);	
		productoDAO.guardar(producto);
		return "/vistas/Inventario/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Inventario> obtenerInventario(){
		InventarioDAO inventarioDAO = new InventarioDAO();
		return inventarioDAO.obtenerInventario();
		
	}
	
	public String editar(int idinventario) {
		InventarioDAO inventarioDAO = new InventarioDAO();
		Inventario i = new Inventario();
		i=inventarioDAO.buscar(idinventario);
		System.out.println(i);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("inventario", i);
		return "/vistas/Inventario/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Inventario inventario) {
		 InventarioDAO inventarioDAO = new InventarioDAO();
		 inventarioDAO.editar(inventario);
		 return "/vistas/Inventario/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idinventario) {
		InventarioDAO inventarioDAO = new InventarioDAO();
		inventarioDAO.eliminar(idinventario);
		System.out.println("Inventario eliminado..");
		return "/vistas/Inventario/index.xhtml?faces-redirect=true";
		
	}
	 
}