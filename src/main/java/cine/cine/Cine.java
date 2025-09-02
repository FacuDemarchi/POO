package cine.cine;

import cine.peliculas.Pelicula;
import cine.salas.Sala;
import cine.funciones.Funcion;
import java.util.Arrays;


public class Cine {
    private Pelicula[] cartelera;
    private Sala[] salas;
    private Funcion[] funciones;

    public Cine(Pelicula[] cartelera, Sala[] salas, Funcion[] funciones) {
        this.cartelera = cartelera;
        this.salas = salas;
        this.funciones = funciones;
    }

    public Pelicula[] getCartelera() {
        return cartelera;
    }

    public Sala[] getSalas() {
        return salas;
    }
    
    public Funcion[] getFunciones() {
        return funciones;
    }

    public void setCartelera(Pelicula[] cartelera) {
        this.cartelera = cartelera;
    }
    
    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

    public void setFunciones(Funcion[] funciones) {
        this.funciones = funciones;
    }

    public void agregarPelicula(Pelicula pelicula) {
        this.cartelera = Arrays.copyOf(this.cartelera, this.cartelera.length + 1);
        this.cartelera[this.cartelera.length - 1] = pelicula;
    }

    public void agregarSala(Sala sala) {
        this.salas = Arrays.copyOf(this.salas, this.salas.length + 1);
        this.salas[this.salas.length - 1] = sala;
    }

    public void agregarFuncion(Funcion funcion) {
        this.funciones = Arrays.copyOf(this.funciones, this.funciones.length + 1);
        this.funciones[this.funciones.length - 1] = funcion;
    }

    public void eliminarPelicula(Pelicula pelicula) {
        this.cartelera = Arrays.copyOf(this.cartelera, this.cartelera.length - 1);
    }

    public void eliminarSala(Sala sala) {
        this.salas = Arrays.copyOf(this.salas, this.salas.length - 1);
    }

    public void eliminarFuncion(Funcion funcion) {
        this.funciones = Arrays.copyOf(this.funciones, this.funciones.length - 1);
    }

    public Pelicula buscarPelicula(String titulo) {
        for (Pelicula pelicula : this.cartelera) {
            if (pelicula.getTitulo().equals(titulo)) {
                return pelicula;
            }
        }
        return null;
    }

    public Sala buscarSala(int numero) {
        for (Sala sala : this.salas) {
            if (sala.getNumero() == numero) {
                return sala;
            }
        }
        return null;
    }

    public Funcion buscarFuncion(String titulo) {
        for (Funcion funcion : this.funciones) {
            if (funcion.getPelicula().getTitulo().equals(titulo)) {
                return funcion;
            }
        }
        return null;
    }
}
