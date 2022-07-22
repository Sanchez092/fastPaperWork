package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.fastPaperWork.model.Pqrs;
import com.fastPaperWork.utilities.JPAUtil;

public class PqrsDAO {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(Pqrs pqrs) {
		entity.getTransaction().begin();
		entity.persist(pqrs);
		entity.getTransaction().commit();
	}
	
	
	public void editar(Pqrs pqrs) {
		entity.getTransaction().begin();
		entity.merge(pqrs);
		entity.getTransaction().commit();
		
	}
	

		public Pqrs buscar(int idpqrs) {
			Pqrs p = new Pqrs();
			p=entity.find(Pqrs.class, idpqrs);
			return p;
	}

		
	public List<Pqrs> obtenerPqrs(){
			List<Pqrs> listaPqrs = new ArrayList<>();
			Query q = entity.createQuery("SELECT p FROM Pqrs p");
			listaPqrs =q.getResultList();
			return listaPqrs;
	}	
	
	

		public void eliminar(int idpqrs) {
			Pqrs p = new Pqrs();
			p = entity.find(Pqrs.class,idpqrs);
			entity.getTransaction().begin();
			entity.remove(p);
			entity.getTransaction().commit();
	}
	
}
