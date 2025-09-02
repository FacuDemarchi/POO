package cine.salas;

public class Butaca {
    private int numero;
    private String fila;
    private int columna;
    private boolean isOcupada;

    public Butaca(int numero, String fila, int columna, boolean isOcupada) {
        this.numero = numero;
        this.fila = fila;
        this.columna = columna;
        this.isOcupada = isOcupada;
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

    public boolean isOcupada() {
        return isOcupada;
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

    public void setIsOcupada(boolean isOcupada) {
        this.isOcupada = isOcupada;
    }
}
