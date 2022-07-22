package com.fastPaperWork.Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.fastPaperWork.DAO.ProductoDAO;
import com.fastPaperWork.DAO.VentaDAO;
import com.fastPaperWork.model.Producto;
import com.fastPaperWork.model.Usuario;
import com.fastPaperWork.model.Venta;
import com.fastPaperWork.utilities.ExportarExcelVentas;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

@ManagedBean(name = "ventaBean")
@RequestScoped
@SessionScoped

public class VentaBean {
	
	Venta venta = new Venta();
	private List<Venta> obtenerVenta = new ArrayList<Venta>();
	
	private int idproducto;
	
	public List<Producto> listaProductos; 
	
	public void llenarProducto() {
		ProductoDAO productoDAO = new ProductoDAO();
		this.listaProductos=productoDAO.obtenerProducto();
		
	}

	public VentaBean() {
		this.llenarProducto();
	}
	
	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String nuevo() {
		Venta v = new Venta();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("venta", v);
		return "/vistas/Venta/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Venta venta) {
		Date fechaActual = new Date();
		venta.setFecha(new java.sql.Date(fechaActual.getTime()));
		
		VentaDAO ventaDAO =new VentaDAO();
		
		ProductoDAO productoDAO = new ProductoDAO();
		Producto producto = new Producto();
		venta.setIdproducto(producto);
		
		ventaDAO.guardar(venta);
		return "/vistas/Venta/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Venta> obtenerVenta(){
		VentaDAO ventaDAO =new VentaDAO();
		return ventaDAO.obtenerVenta();
	}
	
	public String editar(int idventa) {
		VentaDAO ventaDAO =new VentaDAO();
		Venta v = new Venta();
		v=ventaDAO.buscar(idventa);
		System.out.println(v);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("venta", v);
		return "/vistas/Venta/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Venta venta) {
		VentaDAO ventaDAO = new VentaDAO();
		ventaDAO.editar(venta);
		return "/vistas/Venta/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idventa) {
		VentaDAO ventaDAO = new VentaDAO();
		ventaDAO.eliminar(idventa);
		System.out.println("Venta eliminada..");
		return "/vistas/Venta/index.xhtml?faces-redirect=true";
		
	}
	
	public void exportar() throws IOException {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerkey = "Content-Disposition";
		String headerValue = "attachment; filename=listaVenta" + currentDateTime + ".xlsx";
		response.setHeader(headerkey, headerValue);
		System.out.println("venta>" + venta.toString());
		
		VentaDAO ventaDAO = new VentaDAO();
		
		this.obtenerVenta=ventaDAO.obtenerVenta();
		
		ExportarExcelVentas excelExportar = new ExportarExcelVentas(this.obtenerVenta);
		excelExportar.export(response);
		
		
	}
	
}
