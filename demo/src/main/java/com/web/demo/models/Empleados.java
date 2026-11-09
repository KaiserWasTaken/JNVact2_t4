package com.web.demo.models;

public class Empleados {
    private String nombre, apellido, puesto, direccion;
    private int edad, telefono, id;

    public Empleados(String nombre, String apellido, String puesto, String direccion, 
        int edad, int telefono, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.direccion = direccion;
        this.edad = edad;
        this.telefono = telefono;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
