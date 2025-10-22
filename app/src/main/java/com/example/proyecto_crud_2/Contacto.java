package com.example.proyecto_crud_2;

public class Contacto {
    private String nombre;
    private String telefono;
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Contacto(String id, String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}