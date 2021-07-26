package com.nexos.pruebaNexos.service;

import java.util.List;

import com.nexos.pruebaNexos.model.Usuario;

public interface UsuarioService {

	List<Usuario> listarUsuario();

	void insertarUsuario(Usuario usuario) throws Exception;

}
