package com.nexos.pruebaNexos.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nexos.pruebaNexos.model.Usuario;
import com.nexos.pruebaNexos.repository.UsuarioRepository;
import com.nexos.pruebaNexos.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarUsuario() {
		return usuarioRepository.findAll();
	}

	@Override
	public void insertarUsuario(Usuario usuario) throws Exception {
		usuarioRepository.save(usuario);
	}

}