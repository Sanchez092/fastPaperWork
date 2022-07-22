package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fastPaperWork.model.Login;
import com.fastPaperWork.model.Rol;
import com.fastPaperWork.model.Usuario;
import com.fastPaperWork.utilities.JPAUtil;

public class LoginDAO {

EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	

	public void guardar(Login login) {
		entity.getTransaction().begin();
		entity.persist(login);
		entity.getTransaction().commit();
	}
	
	
	public void editar(Login login) {
		entity.getTransaction().begin();
		entity.merge(login);
		entity.getTransaction().commit();
		
	}
	

		public Login buscar(int idlogin) {
			Login l = new Login();
			l=entity.find(Login.class, idlogin);
			return l;
	}

		
	public List<Login> obtenerLogin(){
			List<Login> listLogin = new ArrayList<>();
			Query q = entity.createQuery("SELECT l FROM Login l");
			listLogin =q.getResultList();
			return listLogin;
	}	
	
	

		public void eliminar(int idlogin) {
			Login l = new Login();
			l = entity.find(Login.class,idlogin);
			entity.getTransaction().begin();
			entity.remove(l);
			entity.getTransaction().commit();
	}
			
			
}		
			
			
			
			

		
		
		
