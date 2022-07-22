package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fastPaperWork.model.Permisos;
import com.fastPaperWork.model.Rol;
import com.fastPaperWork.utilities.JPAUtil;

public class PermisosDAO {

EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(Permisos permisos) {
		entity.getTransaction().begin();
		entity.persist(permisos);
		entity.getTransaction().commit();
	}
	
	
	public void editar(Permisos permisos) {
		entity.getTransaction().begin();
		entity.merge(permisos);
		entity.getTransaction().commit();
		
	}
	

		public Permisos buscar(int idpermisos) {
			Permisos p = new Permisos();
			p=entity.find(Permisos.class, idpermisos);
			return p;
	}

		
	public List<Permisos> obtenerPermisos(){
			List<Permisos> listaPermisos = new ArrayList<>();
			Query q = entity.createQuery("SELECT p FROM Permisos p");
			listaPermisos =q.getResultList();
			return listaPermisos;
	}	
	
	

		public void eliminar(int idpermisos) {
			Permisos p = new Permisos();
			p = entity.find(Permisos.class,idpermisos);
			entity.getTransaction().begin();
			entity.remove(p);
			entity.getTransaction().commit();
	}


}
