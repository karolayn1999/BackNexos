package com.nexos.pruebaNexos.restController;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nexos.pruebaNexos.model.Cargo;
import com.nexos.pruebaNexos.service.CargoService;

@RestController
@RequestMapping("/cargo")
@CrossOrigin(origins = "http://localhost:4200")
public class CargoController {
	
	private static final Logger log = LogManager.getLogger(CargoController.class);
	
	@Autowired
	private CargoService cargoService;

	@GetMapping
	@RequestMapping("/listarCargos")
	public ResponseEntity<List<Cargo>> listarCargos(){
		return new ResponseEntity(cargoService.listarCargos(),HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping("/registrarCargo")
	public ResponseEntity<?> insertarMercancia(@RequestBody Cargo cargo) {
		try {
			cargoService.insertarCargo(cargo);
			return new ResponseEntity("Cargo registrado",HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity("Error al registrar cargo, consulte log para mas informacion",HttpStatus.BAD_REQUEST);
		}
		
	}
	
}