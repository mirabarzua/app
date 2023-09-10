package com.example.demo;

public class Persona {
    private String rut;
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor
    public Persona(String rut, String nombre, String apellido, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Persona(){}

    // Getters
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    // Setters (si es necesario)
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
