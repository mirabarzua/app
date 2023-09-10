package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    

    @Autowired
    JdbcTemplate jdbcTemplate;
    

    public boolean validarCredenciales(String username, String password) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE username = ? AND password = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);

        return count == 1;
    }

    public Persona obtenerUsuarioPorRut(String username) {
        String rut = obtenerRutPorUsername(username);
        String sql = "SELECT * FROM persona WHERE rut = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, rowNum) -> {
            
            Persona p = new Persona();
            p.setRut(resultSet.getString("rut"));
            p.setNombre(resultSet.getString("nombre"));
            p.setApellido(resultSet.getString("apellido"));
            p.setTelefono(resultSet.getString("telefono"));

            return p;
        }, rut);
    }

    public String obtenerRutPorUsername(String username) {
        String sql = "SELECT rut FROM usuario WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, username);
        } catch (Exception e) {
            // Manejo de excepciones si el usuario no se encuentra o si ocurre un error
            return null; // Puedes devolver un valor por defecto o manejar el error según tus necesidades
        }
    }
}