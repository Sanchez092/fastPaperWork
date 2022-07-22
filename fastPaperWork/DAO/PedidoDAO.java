package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import com.fastPaperWork.model.Pedido;
import com.fastPaperWork.utilities.JPAUtil;

public class PedidoDAO {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Usuario
	public void guardar(Pedido pedido) {
		entity.getTransaction().begin();
		entity.persist(pedido);
		entity.getTransaction().commit();
	}
	//Editar Usuario
		public void editar(Pedido pedido) {
			entity.getTransaction().begin();
			entity.merge(pedido);
			entity.getTransaction().commit();
			
	}
		//Buscar Usuario
		public Pedido buscar(int idpedido) {
			Pedido p = new Pedido();
			p=entity.find(Pedido.class, idpedido);
			return p;
	}
		//Listar Usuario
		public List<Pedido> obtenerPedidos(){
				List<Pedido> listaPedidos = new ArrayList<>();
				Query q = entity.createQuery("SELECT p FROM Pedido p");
				listaPedidos =q.getResultList();
				return listaPedidos;
		}	
		
		
		//Eliminar Usuario
			public void eliminar(int idpedidos) {
				Pedido p = new Pedido();
				p = entity.find(Pedido.class,idpedidos);
				entity.getTransaction().begin();
				entity.remove(p);
				entity.getTransaction().commit();
		}
		
		

}