package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fastPaperWork.model.Calificacion;
import com.fastPaperWork.utilities.JPAUtil;

public class CalificacionDAO {
	
	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Calificacion
	public void guardar(Calificacion calificacion) {
		entity.getTransaction().begin();
		entity.persist(calificacion);
		entity.getTransaction().commit();
	}
	
	//Editar Calificacion
	public void editar(Calificacion calificacion) {
		entity.getTransaction().begin();
		entity.merge(calificacion);
		entity.getTransaction().commit();
		
	}
	
	//Buscar Calificacion
		public Calificacion buscar(int idcalificacion) {
			Calificacion ca = new Calificacion();
			ca=entity.find(Calificacion.class, idcalificacion);
			return ca;
	}
		
	//Listar Calificacion
	public List<Calificacion> obtenerCalificacion(){
			List<Calificacion> listaCalificacion = new ArrayList<>();
			Query q = entity.createQuery("SELECT ca FROM Calificacion ca");
			listaCalificacion =q.getResultList();
			return listaCalificacion;
	}	
	
	
	//Eliminar Calificacion
		public void eliminar(int idcalificacion) {
			Calificacion ca = new Calificacion();
			ca = entity.find(Calificacion.class,idcalificacion);
			entity.getTransaction().begin();
			entity.remove(ca);
			entity.getTransaction().commit();
	}
		
		
}		