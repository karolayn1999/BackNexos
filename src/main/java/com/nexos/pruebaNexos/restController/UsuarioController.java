package com.nexos.pruebaNexos.restController;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nexos.pruebaNexos.model.Usuario;
import com.nexos.pruebaNexos.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private static final Logger log = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	@RequestMapping("/listarUsuarios")
	public ResponseEntity<List<Usuario>> listarUsuario(){
		return new ResponseEntity(usuarioService.listarUsuario(),HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping("/registrarUsuario")
	public ResponseEntity<?> insertarUsuario(@RequestBody Usuario usuario) {
		try {
			usuarioService.insertarUsuario(usuario);
			return new ResponseEntity("Usuario registrado",HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity("Error al registrar usuario, consulte log para mas informacion",HttpStatus.BAD_REQUEST);
		}
	}
	
}