package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fastPaperWork.model.Rol;
import com.fastPaperWork.model.Usuario;
import com.fastPaperWork.utilities.JPAUtil;



public class UsuarioDAO {

	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
Query q;

private List<Usuario> listUsuarios;

	//Guardar Usuario
	public void guardar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.persist(usuario);
		entity.getTransaction().commit();
	}
	
	//Editar Usuario
	public void editar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
		
	}
	
	//Buscar Usuario
		public Usuario buscar(int id) {
			Usuario u = new Usuario();
			u=entity.find(Usuario.class, id);
			return u;
	}
		
	//Listar Usuario
	public List<Usuario> obtenerUsuarios(){
			List<Usuario> listaUsuarios = new ArrayList<>();
			Query q = entity.createQuery("SELECT u FROM Usuario u");
			listaUsuarios =q.getResultList();
			return listaUsuarios;
	}	
	
	
	//Eliminar Usuario
		public void eliminar(int id) {
			Usuario u = new Usuario();
			u = entity.find(Usuario.class,id);
			entity.getTransaction().begin();
			entity.remove(u);
			entity.getTransaction().commit();
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
