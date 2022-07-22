package com.fastPaperWork.DAO;

import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import com.fastPaperWork.model.SeguimientoEnvio;

import com.fastPaperWork.utilities.JPAUtil;

public class SeguimientoEnvioDAO {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Guardar Usuario
	public void guardar(SeguimientoEnvio seguimientoEnvio) {
		entity.getTransaction().begin();
		entity.persist(seguimientoEnvio);
		entity.getTransaction().commit();
	}
	//Editar Usuario
	public void editar(SeguimientoEnvio seguimientoEnvio) {
		entity.getTransaction().begin();
		entity.merge(seguimientoEnvio);
		entity.getTransaction().commit();	
	}
	
	//Buscar Usuario
	public SeguimientoEnvio buscar(int idseguimiento_envio) {
		SeguimientoEnvio s = new SeguimientoEnvio();
		s=entity.find(SeguimientoEnvio.class, idseguimiento_envio);
		return s;
	}
	
	//Listar Usuario
	public List<SeguimientoEnvio> obtenerSeguimientoEnvio(){
			List<SeguimientoEnvio> listaSeguimientoEnvio = new ArrayList<>();
			Query q = entity.createQuery("SELECT s FROM SeguimientoEnvio s");
			listaSeguimientoEnvio =q.getResultList();
			return listaSeguimientoEnvio;
	}	

	//Eliminar Usuario
			public void eliminar(int idseguimiento_envio) {
				SeguimientoEnvio s = new SeguimientoEnvio();
				s = entity.find(SeguimientoEnvio.class,idseguimiento_envio);
				entity.getTransaction().begin();
				entity.remove(s);
				entity.getTransaction().commit();
		}
}
