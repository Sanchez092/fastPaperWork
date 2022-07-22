package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fastPaperWork.model.Proveedor;
import com.fastPaperWork.utilities.JPAUtil;



public class ProveedorDAO {

	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Proveedor
	public void guardar(Proveedor proveedor) {
		entity.getTransaction().begin();
		entity.persist(proveedor);
		entity.getTransaction().commit();
	}
	
	//Editar Proveedor
	public void editar(Proveedor proveedor) {
		entity.getTransaction().begin();
		entity.merge(proveedor);
		entity.getTransaction().commit();
		
	}
	
	//Buscar Proveedor
		public Proveedor buscar(int idproveedor) {
			Proveedor pr = new Proveedor();
			pr=entity.find(Proveedor.class, idproveedor);
			return pr;
	}
		
	//Listar Proveedor
	public List<Proveedor> obtenerProveedor(){
			List<Proveedor> listaProveedor = new ArrayList<>();
			Query q = entity.createQuery("SELECT pr FROM Proveedor pr");
			listaProveedor =q.getResultList();
			return listaProveedor;
	}	
	
	
	//Eliminar Proveedor
		public void eliminar(int idproveedor) {
			Proveedor pr = new Proveedor();
			pr = entity.find(Proveedor.class,idproveedor);
			entity.getTransaction().begin();
			entity.remove(pr);
			entity.getTransaction().commit();
	}
		

}
