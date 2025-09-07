package cine.salas;

public class Butaca {
    private int numero;
    private String fila;
    private int columna;
    private boolean isPremium;
    private double precio;

    public Butaca(int numero, String fila, int columna, boolean isPremium, double precio) {
        this.numero = numero;
        this.fila = fila;
        this.columna = columna;
        this.isPremium = isPremium;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }

    public String getFila() {
        return fila;
    }
    
    public int getColumna() {
        return columna;
    }

    public boolean isPremium() {
        return isPremium;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }
    
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setIsPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }
}
