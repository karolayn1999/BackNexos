package com.nexos.pruebaNexos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nexos.pruebaNexos.service.MercanciaService;

@SpringBootTest
public class MercanciaTest {
	
	@Autowired
	MercanciaService mercanciaService;
	
	@Test
	void test() {
		try {
			mercanciaService.eliminarMercancia(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}