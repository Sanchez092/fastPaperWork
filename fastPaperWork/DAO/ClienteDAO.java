package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import com.fastPaperWork.model.Cliente;
import com.fastPaperWork.utilities.JPAUtil;



public class ClienteDAO {

	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Cliente
	public void guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
	}
	
	//Editar Cliente
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		
	}
	
	//Buscar Cliente
		public Cliente buscar(int idcliente) {
			Cliente cl = new Cliente();
			cl=entity.find(Cliente.class, idcliente);
			return cl;
	}
		
	//Listar Cliente
	public List<Cliente> obtenerCliente(){
			List<Cliente> listaCliente = new ArrayList<>();
			Query q = entity.createQuery("SELECT cl FROM Cliente cl");
			listaCliente =q.getResultList();
			return listaCliente;
	}	
	
	
	//Eliminar Cliente
		public void eliminar(int idcliente) {
			Cliente cl = new Cliente();
			cl = entity.find(Cliente.class,idcliente);
			entity.getTransaction().begin();
			entity.remove(cl);
			entity.getTransaction().commit();
	}
		

}