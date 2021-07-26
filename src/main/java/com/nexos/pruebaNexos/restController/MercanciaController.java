package com.nexos.pruebaNexos.restController;

import java.util.List;

import javax.persistence.NoResultException;
import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.nexos.pruebaNexos.model.Mercancia;
import com.nexos.pruebaNexos.service.MercanciaService;

@RestController
@RequestMapping("/mercancia")
public class MercanciaController {

	private static final Logger log = LogManager.getLogger(MercanciaController.class);

	@Autowired
	private MercanciaService mercanciaService;

	@GetMapping
	@RequestMapping("/listarMercancia")
	public ResponseEntity<List<Mercancia>> listarMercancia() {
		return new ResponseEntity(mercanciaService.listarMercancia(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{nombre_producto}")
	@RequestMapping("/mercanciaNombre")
	public ResponseEntity<?> mercanciaNombre(@PathParam("nombre_producto") String nombre_producto) {
		try {
			Mercancia existe = mercanciaService.mercanciaNombre(nombre_producto);
			return new ResponseEntity(true, HttpStatus.OK);
		} catch (NoResultException e) {
			return new ResponseEntity(false, HttpStatus.OK);
		}catch (Exception ex) {
			log.error(ex.getMessage());
			return new ResponseEntity("Error al consultar mercancia, consulte log para mas informacion",
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	@RequestMapping("/registrarMercancia")
	public ResponseEntity<?> insertarMercancia(@RequestBody Mercancia mercancia) {
		try {
			mercanciaService.insertarMercancia(mercancia);
			return new ResponseEntity("Mercancia registrada", HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity("Error al registrar mercancia, consulte log para mas informacion",
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
	@RequestMapping("/actualizarMercancia")
	public ResponseEntity<?> actualizarMercancia(@RequestBody Mercancia mercancia) {
		try {
			mercanciaService.actualizarMercancia(mercancia);
			return new ResponseEntity("Mercancia actualizada", HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity("Error al actualizar mercancia, consulte log para mas informacion",
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@RequestMapping("/eliminarMercancia")
	public ResponseEntity<?> eliminarMercancia(@PathParam("id") Integer id) {
		try {
			mercanciaService.eliminarMercancia(id);
			return new ResponseEntity("Mercancia eliminada", HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity("Error al eliminar mercancia, consulte log para mas informacion",
					HttpStatus.BAD_REQUEST);
		}
	}

}