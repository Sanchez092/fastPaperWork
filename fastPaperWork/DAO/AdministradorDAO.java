package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fastPaperWork.model.Administrador;
import com.fastPaperWork.utilities.JPAUtil;

public class AdministradorDAO {

	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();

	public void guardar(Administrador administrador) {
		entity.getTransaction().begin();
		entity.persist(administrador);
		entity.getTransaction().commit();
	}
	
	
	public void editar(Administrador administrador) {
		entity.getTransaction().begin();
		entity.merge(administrador);
		entity.getTransaction().commit();
		
	}
	

		public Administrador buscar(int idAdministrador) {
			Administrador a = new Administrador();
			a=entity.find(Administrador.class, idAdministrador);
			return a;
	}

		
	public List<Administrador> obtenerAdmin(){
			List<Administrador> listAdmin = new ArrayList<>();
			Query q = entity.createQuery("SELECT a FROM Administrador a");
			listAdmin =q.getResultList();
			return listAdmin;
	}	
	
	

		public void eliminar(int idAdministrador) {
			Administrador a = new Administrador();
			a = entity.find(Administrador.class,idAdministrador);
			entity.getTransaction().begin();
			entity.remove(a);
			entity.getTransaction().commit();
	}
	
}
