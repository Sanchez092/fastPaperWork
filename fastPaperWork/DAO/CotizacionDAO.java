package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import com.fastPaperWork.model.Cotizacion;
import com.fastPaperWork.utilities.JPAUtil;

public class CotizacionDAO {
	
EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Cotizacion
	public void guardar(Cotizacion cotizacion) {
		entity.getTransaction().begin();
		entity.persist(cotizacion);
		entity.getTransaction().commit();
	}
	
	//Editar Cotizacion
	public void editar(Cotizacion cotizacion) {
		entity.getTransaction().begin();
		entity.merge(cotizacion);
		entity.getTransaction().commit();
	}
	
	//Buscar Cotizacion
	public Cotizacion buscar(int idcotizacion) {
		Cotizacion c = new Cotizacion();
		c=entity.find(Cotizacion.class, idcotizacion);
		return c;
	}
	
	//Listar Cotizacion
	public List<Cotizacion> obtenerCotizacion(){
		List<Cotizacion> listaCotizacion = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cotizacion c");
		listaCotizacion =q.getResultList();
		return listaCotizacion;
	}
	
	//Eliminar Cotizacion
	public void eliminar(int idcotizacion) {
		Cotizacion c = new Cotizacion();
		c = entity.find(Cotizacion.class,idcotizacion);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}
}
