package cine.peliculas;

import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int duracion;
    private String rating;
    private String genero;
    private String idioma;
    private String subtitulos;
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();

    public Pelicula( String titulo, int duracion, String rating, String genero, String idioma ) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.rating = rating;
        this.genero = genero;
        this.idioma = idioma;
        this.subtitulos = null;
        addPelicula(this);
    }

    public Pelicula(String titulo, int duracion, String rating, String genero, String idioma, String subtitulos) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.rating = rating;
        this.genero = genero;
        this.idioma = idioma;
        this.subtitulos = subtitulos;
        addPelicula(this);
    }

    public static void addPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public static ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public static void eliminarPelicula(String titulo) {
        peliculas.removeIf(pelicula -> pelicula.getTitulo().equals(titulo));
    }

    public String getTitulo() {
        return titulo;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public String getRating() {
        return rating;
    }
    
    
    public String getGenero() {
        return genero;
    }
    
    public String getIdioma() {
        return idioma;
    }
    
    
    public String getSubtitulos() {
        return subtitulos;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public void setSubtitulos(String subtitulos) {
        this.subtitulos = subtitulos;
    }
}
