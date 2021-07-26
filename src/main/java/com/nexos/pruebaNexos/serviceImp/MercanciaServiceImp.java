package com.nexos.pruebaNexos.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.nexos.pruebaNexos.model.Mercancia;
import com.nexos.pruebaNexos.repository.MercanciaRepository;
import com.nexos.pruebaNexos.repository.MercanciaRepositoryJPA;
import com.nexos.pruebaNexos.service.MercanciaService;

@Service
public class MercanciaServiceImp implements MercanciaService {
	
	@Autowired
	private MercanciaRepository mercanciaRepository;
	
	@Autowired
	private MercanciaRepositoryJPA mercanciaRepositoryJPA;


	@Override
	public List<Mercancia> listarMercancia() {
		return mercanciaRepositoryJPA.findAll();
	}


	@Override
	public void insertarMercancia(Mercancia mercancia) throws Exception {
		mercanciaRepositoryJPA.save(mercancia);
	}


	@Override
	public void actualizarMercancia(Mercancia mercancia) throws Exception {
		mercanciaRepositoryJPA.save(mercancia);
	}


	@Override
	public void eliminarMercancia(Integer id) throws Exception {
		mercanciaRepositoryJPA.deleteById(id);
	}


	@Override
	public Mercancia mercanciaNombre(String nombre_producto) throws Exception{
		return mercanciaRepository.findByNombre_producto(nombre_producto); 
	}
	
}