package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class AppApplicationTests {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Test
	void contextLoads() {
	

	   
	        // Ejecuta una consulta simple para verificar la conexión a la base de datos
	        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM usuario", Integer.class);
	        
	        // Verifica que el resultado sea mayor que 0
	        assertEquals(1, count);
	        
	    }
	

}
