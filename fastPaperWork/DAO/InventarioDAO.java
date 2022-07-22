package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import com.fastPaperWork.model.Inventario;
import com.fastPaperWork.utilities.JPAUtil;



public class InventarioDAO {

	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Inventario
	public void guardar(Inventario inventario) {
		entity.getTransaction().begin();
		entity.persist(inventario);
		entity.getTransaction().commit();
	}
	
	//Editar Inventario
	public void editar(Inventario inventario) {
		entity.getTransaction().begin();
		entity.merge(inventario);
		entity.getTransaction().commit();
		
	}
	
	//Buscar Inventario
		public Inventario buscar(int idinventario) {
			Inventario i = new Inventario();
			i=entity.find(Inventario.class, idinventario);
			return i;
	}
		
	//Listar Inventario
	public List<Inventario> obtenerInventario(){
			List<Inventario> listaInventario = new ArrayList<>();
			Query q = entity.createQuery("SELECT i FROM Inventario i");
			listaInventario =q.getResultList();
			return listaInventario;
	}	
	
	
	//Eliminar Inventario
		public void eliminar(int idinventario) {
			Inventario i = new Inventario();
			i = entity.find(Inventario.class,idinventario);
			entity.getTransaction().begin();
			entity.remove(i);
			entity.getTransaction().commit();
	}
		

}