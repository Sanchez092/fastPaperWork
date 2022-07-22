package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fastPaperWork.model.Venta;
import com.fastPaperWork.utilities.JPAUtil;

public class VentaDAO {

EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	

	public void guardar(Venta venta) {
		entity.getTransaction().begin();
		entity.persist(venta);
		entity.getTransaction().commit();
	}
	
	
	public void editar(Venta venta) {
		entity.getTransaction().begin();
		entity.merge(venta);
		entity.getTransaction().commit();
		
	}
	

		public Venta buscar(int idventa) {
			Venta v = new Venta();
			v=entity.find(Venta.class, idventa);
			return v;
	}

		
	public List<Venta> obtenerVenta(){
			List<Venta> listaVenta = new ArrayList<>();
			Query q = entity.createQuery("SELECT v FROM Venta v");
			listaVenta =q.getResultList();
			return listaVenta;
	}	
	
	

		public void eliminar(int idventa) {
			Venta v = new Venta();
			v = entity.find(Venta.class,idventa);
			entity.getTransaction().begin();
			entity.remove(v);
			entity.getTransaction().commit();
	}
	
}
