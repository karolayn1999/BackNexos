package com.nexos.pruebaNexos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexos.pruebaNexos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}