package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fastPaperWork.model.Rol;
import com.fastPaperWork.model.Usuario;
import com.fastPaperWork.utilities.JPAUtil;

public class RolDAO {

EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(Rol rol) {
		entity.getTransaction().begin();
		entity.persist(rol);
		entity.getTransaction().commit();
	}
	
	
	public void editar(Rol rol) {
		entity.getTransaction().begin();
		entity.merge(rol);
		entity.getTransaction().commit();
		
	}
	

		public Rol buscar(int idrol) {
			Rol r = new Rol();
			r=entity.find(Rol.class, idrol);
			return r;
	}

		
	public List<Rol> obtenerRol(){
			List<Rol> listaRol = new ArrayList<>();
			Query q = entity.createQuery("SELECT r FROM Rol r");
			listaRol =q.getResultList();
			return listaRol;
	}	
	
	

		public void eliminar(int idrol) {
			Rol r = new Rol();
			r = entity.find(Rol.class,idrol);
			entity.getTransaction().begin();
			entity.remove(r);
			entity.getTransaction().commit();
	}


		public Rol findById(int idrol) {
			Rol rol = new Rol();
			try {
				this.entity.getTransaction().begin();
				rol = this.entity.find(Rol.class, idrol);
				this.entity.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.entity.clear();
			}
	
			return rol;
			
		}
	
}
