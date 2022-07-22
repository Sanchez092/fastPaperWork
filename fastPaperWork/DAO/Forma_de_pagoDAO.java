package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import com.fastPaperWork.model.Forma_de_pago;
import com.fastPaperWork.utilities.JPAUtil;



public class Forma_de_pagoDAO {

	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Forma de pago
	public void guardar(Forma_de_pago forma_de_pago) {
		entity.getTransaction().begin();
		entity.persist(forma_de_pago);
		entity.getTransaction().commit();
	}
	
	//Editar Forma de pago
	public void editar(Forma_de_pago forma_de_pago) {
		entity.getTransaction().begin();
		entity.merge(forma_de_pago);
		entity.getTransaction().commit();
		
	}
	
	//Buscar Forma de pago
		public Forma_de_pago buscar(int idforma_de_pago) {
			Forma_de_pago f = new Forma_de_pago();
			f=entity.find(Forma_de_pago.class, idforma_de_pago);
			return f;
	}
		
	//Listar Forma de pago
	public List<Forma_de_pago> obtenerForma_de_pago(){
			List<Forma_de_pago> listaForma_de_pago = new ArrayList<>();
			Query q = entity.createQuery("SELECT f FROM Forma_de_pago f");
			listaForma_de_pago =q.getResultList();
			return listaForma_de_pago;
	}	
	
	
	//Eliminar Forma de pago
		public void eliminar(int idforma_de_pago) {
			Forma_de_pago f = new Forma_de_pago();
			f = entity.find(Forma_de_pago.class,idforma_de_pago);
			entity.getTransaction().begin();
			entity.remove(f);
			entity.getTransaction().commit();
	}
		

}