package com.nexos.pruebaNexos.service;

import java.util.List;

import com.nexos.pruebaNexos.model.Cargo;

public interface CargoService {

	List<Cargo> listarCargos();

	void insertarCargo(Cargo cargo) throws Exception;

}
