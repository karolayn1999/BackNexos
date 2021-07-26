package com.nexos.pruebaNexos.repositoryImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nexos.pruebaNexos.model.Mercancia;
import com.nexos.pruebaNexos.repository.MercanciaRepository;

@Repository
public class MercanciaRepositoryImpl implements MercanciaRepository{

	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Mercancia findByNombre_producto(String nombre_producto) throws Exception{
		TypedQuery<Mercancia> query = em.createQuery("SELECT m FROM Mercancia m WHERE m.nombre_producto = :nombre_producto",Mercancia.class);
		query.setParameter("nombre_producto", nombre_producto);
		return query.getSingleResult();
	}

}