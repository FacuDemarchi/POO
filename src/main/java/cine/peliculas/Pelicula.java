package cine.peliculas;

public class Pelicula {
    private String titulo;
    private int duracion;
    private String rating;
    private String genero;
    private Idioma idioma;
    
    public Pelicula(String titulo, int duracion, String rating, String genero, Idioma idioma) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.rating = rating;
        this.genero = genero;
        this.idioma = idioma;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public String getRating() {
        return rating;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public Idioma getIdioma() {
        return idioma;
    }
    
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
}
