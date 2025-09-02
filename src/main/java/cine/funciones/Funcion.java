package cine.funciones;

import cine.peliculas.Pelicula;
import cine.salas.Sala;
import java.util.Date;

public class Funcion {
    private Pelicula pelicula;
    private Sala sala;
    private Date horario;
    private double precioUnitario;

    public Funcion(Pelicula pelicula, Sala sala, Date horario, double precioUnitario) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
        this.precioUnitario = precioUnitario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public Date getHorario() {
        return horario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
