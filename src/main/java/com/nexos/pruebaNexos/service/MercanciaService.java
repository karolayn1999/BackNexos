package com.nexos.pruebaNexos.service;

import java.util.List;

import com.nexos.pruebaNexos.model.Mercancia;

public interface MercanciaService {

	List<Mercancia> listarMercancia();
	
	void insertarMercancia(Mercancia mercancia) throws Exception;

	void actualizarMercancia(Mercancia mercancia) throws Exception;

	void eliminarMercancia(Integer id) throws Exception;

	Mercancia mercanciaNombre(String nombre_producto) throws Exception;

}