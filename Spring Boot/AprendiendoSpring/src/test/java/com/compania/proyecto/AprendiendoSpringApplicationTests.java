package com.compania.proyecto;


import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.compania.proyecto.model.Usuario;
import com.compania.proyecto.repository.IUsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class AprendiendoSpringApplicationTests {

	@Autowired
	private IUsuarioRepository repo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Test
	void contextLoads() {
		Usuario us = new Usuario();
		us.setId(1);
		us.setNombre("marco");
		us.setClave(encoder.encode("123456"));
		Usuario retorno = repo.save(us);
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
