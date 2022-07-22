package com.fastPaperWork.Controlador;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import com.fastPaperWork.DAO.Forma_de_pagoDAO;
import com.fastPaperWork.model.Forma_de_pago;
import javax.faces.context.FacesContext;

@ManagedBean(name = "formadepagoBean")
@RequestScoped
@SessionScoped

public class Forma_de_pagoBean {
	
	
	
	public String nuevo() {
		Forma_de_pago f = new Forma_de_pago();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("forma_de_pago", f);
		return "/vistas/Formadepago/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Forma_de_pago formadepago) {
		Forma_de_pagoDAO formadepagoDAO = new Forma_de_pagoDAO();
		formadepagoDAO.guardar(formadepago);
		return "/vistas/Formadepago/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Forma_de_pago> obtenerForma_de_pago(){
		Forma_de_pagoDAO forma_de_pagoDAO = new Forma_de_pagoDAO();
		return forma_de_pagoDAO.obtenerForma_de_pago();
		
	}
	
	public String editar(int idforma_de_pago) {
		Forma_de_pagoDAO formadepagoDAO = new Forma_de_pagoDAO();
		Forma_de_pago f = new Forma_de_pago();
		f=formadepagoDAO.buscar(idforma_de_pago);
		System.out.println(f);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("forma_de_pago", f);
		return "/vistas/Formadepago/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Forma_de_pago formadepago) {
		 Forma_de_pagoDAO formadepagoDAO = new Forma_de_pagoDAO();
		 formadepagoDAO.editar(formadepago);
		 return "/vistas/Formadepago/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idforma_de_pago) {
		Forma_de_pagoDAO formadepagoDAO = new Forma_de_pagoDAO();
		formadepagoDAO.eliminar(idforma_de_pago);
		System.out.println("Formadepago eliminada..");
		return "/vistas/Formadepago/index.xhtml?faces-redirect=true";
		
	}
	 
}