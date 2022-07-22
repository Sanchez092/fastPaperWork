package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import com.fastPaperWork.model.Producto;
import com.fastPaperWork.utilities.JPAUtil;



public class ProductoDAO {

	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Producto
	public void guardar(Producto producto) {
		entity.getTransaction().begin();
		entity.persist(producto);
		entity.getTransaction().commit();
	}
	
	//Editar Producto
	public void editar(Producto producto) {
		entity.getTransaction().begin();
		entity.merge(producto);
		entity.getTransaction().commit();
		
	}
	
	//Buscar Producto
		public Producto buscar(int idproducto) {
			Producto pro = new Producto();
			pro=entity.find(Producto.class, idproducto);
			return pro;
	}
		
	//Listar Producto
	public List<Producto> obtenerProducto(){
			List<Producto> listaProducto = new ArrayList<>();
			Query q = entity.createQuery("SELECT pro FROM Producto pro");
			listaProducto =q.getResultList();
			return listaProducto;
	}	
	
	
	//Eliminar Producto
		public void eliminar(int idproducto) {
			Producto pro = new Producto();
			pro = entity.find(Producto.class,idproducto);
			entity.getTransaction().begin();
			entity.remove(pro);
			entity.getTransaction().commit();
	}
}