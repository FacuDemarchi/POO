package com.ejemplo.poo;

/**
 * Clase principal del proyecto de Programación Orientada a Objetos
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class Main {
    
    /**
     * Método principal (punto de entrada del programa)
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("Hola! Bienvenido a la Programacion Orientada a Objetos en Java");
        System.out.println("Este es tu primer proyecto Java estructurado correctamente.");
        
        // Aquí puedes agregar tu código
        Persona persona1 = new Persona("Juan", 25);
        persona1.saludar();
    }
}
