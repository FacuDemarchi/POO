package com.ejemplo.poo;

/**
 * Clase que representa una Persona
 * Ejemplo básico de Programación Orientada a Objetos
 */
public class Persona {
    
    // Atributos (variables de instancia)
    private String nombre;
    private int edad;
    
    /**
     * Constructor por defecto
     */
    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = 0;
    }
    
    /**
     * Constructor con parámetros
     * @param nombre el nombre de la persona
     * @param edad la edad de la persona
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    /**
     * Método que hace que la persona salude
     */
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " anios.");
    }
    
    /**
     * Método toString para mostrar información de la persona
     */
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
    }
}
