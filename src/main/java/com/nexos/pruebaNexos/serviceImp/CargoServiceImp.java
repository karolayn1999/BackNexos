package com.nexos.pruebaNexos.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nexos.pruebaNexos.model.Cargo;
import com.nexos.pruebaNexos.repository.CargoRepository;
import com.nexos.pruebaNexos.service.CargoService;

@Service
public class CargoServiceImp implements CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	@Override
	public List<Cargo> listarCargos() {
		return cargoRepository.findAll();
	}

	@Override
	public void insertarCargo(Cargo cargo) throws Exception {
		cargoRepository.save(cargo);
	}

}