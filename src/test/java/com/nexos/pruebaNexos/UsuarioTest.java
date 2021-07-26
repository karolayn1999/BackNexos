package com.nexos.pruebaNexos;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nexos.pruebaNexos.model.Usuario;
import com.nexos.pruebaNexos.service.UsuarioService;

@SpringBootTest
public class UsuarioTest {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Test
	void test() {
		try {
			List<Usuario> usuarios = usuarioService.listarUsuario();
			for(int i=0;i<usuarios.size();i++) {
				System.out.println(usuarios.get(i).getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
