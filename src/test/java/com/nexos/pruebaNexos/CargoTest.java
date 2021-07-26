package com.nexos.pruebaNexos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nexos.pruebaNexos.model.Cargo;
import com.nexos.pruebaNexos.service.CargoService;

@SpringBootTest
public class CargoTest {
	
	@Autowired
	CargoService cargoService;
	
	@Test
	void test() {
		Cargo cargo = new Cargo();
		cargo.setNombre("Gerente");
		try {
			cargoService.insertarCargo(cargo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
