package com.nexos.pruebaNexos.repository;

import org.springframework.data.repository.Repository;
import com.nexos.pruebaNexos.model.Mercancia;

public interface MercanciaRepository extends Repository<Mercancia, Integer>{

	Mercancia findByNombre_producto(String nombre_producto) throws Exception;
	
}