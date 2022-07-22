package com.fastPaperWork.Controlador;


import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.fastPaperWork.DAO.LoginDAO;
import com.fastPaperWork.model.Login;


@ManagedBean(name = "loginBean")
@RequestScoped
@SessionScoped 

public class LoginBean {

	public String nuevo() {
		Login l = new Login();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("login", l);
		return "/vistas/Login/add.xhtml?faces-redirect=true";
	}
	
	public String guardar(Login login) {
		LoginDAO loginDAO =new LoginDAO();
		loginDAO.guardar(login);
		return "/vistas/Login/index.xhtml?faces-redirect=true";
		
	}
	
	public List<Login> obtenerLogin(){
		LoginDAO loginDAO =new LoginDAO();
		return loginDAO.obtenerLogin();
	}
	
	public String editar(int idlogin) {
		LoginDAO loginDAO =new LoginDAO();
		Login l = new Login();
		l=loginDAO.buscar(idlogin);
		System.out.println(l);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("login", l);
		return "/vistas/Login/editar.xhtml?faces-redirect=true";
		
	}
	
	public String actualizar(Login login) {
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.editar(login);
		return "/vistas/Login/index.xhtml?faces-redirect=true";
	}
	
	public String eliminar(int idlogin) {
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.eliminar(idlogin);
		System.out.println("Registro eliminado..");
		return "/vistas/Login/index.xhtml?faces-redirect=true";
		
	}
	
}
