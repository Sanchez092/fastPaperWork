package com.fastPaperWork.Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import com.fastPaperWork.DAO.ProductoDAO;
import com.fastPaperWork.DAO.ProveedorDAO;
import com.fastPaperWork.model.Producto;
import com.fastPaperWork.model.Proveedor;
import com.fastPaperWork.utilities.ExportarExcelProductos;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name = "productoBean")
@RequestScoped
@SessionScoped

public class ProductoBean {	
	
	private int idproveedor;
	private List<Proveedor> listProveedor;
	
	Producto producto = new Producto();
	private List<Producto> obtenerProducto = new ArrayList<Producto>();

	
	private void llenarProveedor() {
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		this.listProveedor = proveedorDAO.obtenerProveedor();
	}
		
	public ProductoBean() {
		
		this.llenarProveedor();
	}


	public List<Proveedor> getListProveedor() {
		return listProveedor;
	}

	public void setListProveedor(List<Proveedor> listProveedor) {
		this.listProveedor = listProveedor;
	}

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}
	
	public String nuevo() {
		Producto pro = new Producto();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", pro);
		return "/vistas/Producto/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Producto producto) {
		ProductoDAO productoDAO = new ProductoDAO();
		
		ProveedorDAO proveedorDAO = new ProveedorDAO();
		Proveedor proveedor = new Proveedor(); 
		proveedor = proveedorDAO.buscar(idproveedor);
		producto.setIdproveedor(proveedor);
		
		productoDAO.guardar(producto);
		return "/vistas/Producto/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Producto> obtenerProducto(){
		ProductoDAO productoDAO = new ProductoDAO();
		return productoDAO.obtenerProducto();
		
	}
	
	public String editar(int idproducto) {
		ProductoDAO productoDAO = new ProductoDAO();
		Producto pro = new Producto();
		pro=productoDAO.buscar(idproducto);
		System.out.println(pro);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", pro);
		return "/vistas/Producto/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Producto producto) {
		 ProductoDAO productoDAO = new ProductoDAO();
		 productoDAO.editar(producto);
		 return "/vistas/Producto/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idproducto) {
		ProductoDAO productoDAO = new ProductoDAO();
		productoDAO.eliminar(idproducto);
		System.out.println("Producto eliminado..");
		return "/vistas/Producto/index.xhtml?faces-redirect=true";
		
	}
	
	public void exportar() throws IOException {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerkey = "Content-Disposition";
		String headerValue = "attachment; filename=listaProducto" + currentDateTime + ".xlsx";
		response.setHeader(headerkey, headerValue);
		System.out.println("producto>" + producto.toString());
		
		ProductoDAO productoDAO = new ProductoDAO();
		
		this.obtenerProducto=productoDAO.obtenerProducto();
		
		ExportarExcelProductos excelExportar = new ExportarExcelProductos(this.obtenerProducto);
		excelExportar.export(response);
		
		
	}
	 
}
