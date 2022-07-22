package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import com.fastPaperWork.model.Respuesta;
import com.fastPaperWork.utilities.JPAUtil;



public class RespuestaDAO {

	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Respuesta
	public void guardar(Respuesta respuesta) {
		entity.getTransaction().begin();
		entity.persist(respuesta);
		entity.getTransaction().commit();
	}
	
	//Editar Respuesta
	public void editar(Respuesta respuesta) {
		entity.getTransaction().begin();
		entity.merge(respuesta);
		entity.getTransaction().commit();
		
	}
	
	//Buscar Respuesta
		public Respuesta buscar(int idrespuesta) {
			Respuesta r = new Respuesta();
			r=entity.find(Respuesta.class, idrespuesta);
			return r;
	}
		
	//Listar Respuesta
	public List<Respuesta> obtenerRespuesta(){
			List<Respuesta> listaRespuesta = new ArrayList<>();
			Query q = entity.createQuery("SELECT r FROM Respuesta r");
			listaRespuesta =q.getResultList();
			return listaRespuesta;
	}	
	
	
	//Eliminar Respuesta
		public void eliminar(int idrespuesta) {
			Respuesta r = new Respuesta();
			r = entity.find(Respuesta.class,idrespuesta);
			entity.getTransaction().begin();
			entity.remove(r);
			entity.getTransaction().commit();
	}
		

}