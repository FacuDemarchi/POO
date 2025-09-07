package cine.salas;
import java.util.ArrayList;

public class Sala {
    private int numero;
    private int cantButacas;
    private static ArrayList<Sala> salas = new ArrayList<>();
    
    public Sala(int numero, int cantButacas) {
        this.numero = numero;
        this.cantButacas = cantButacas;
        addSala(this); // Se auto-registra directamente
    }


    public static void addSala(Sala sala) {
        salas.add(sala);
    }
    
    public static ArrayList<Sala> getSalas() {
        return salas;
    }
    
    public static void eliminarSala(int numero) {
        salas.removeIf(sala -> sala.getNumero() == numero);
    }
    
    public int getNumero() {
        return numero;
    }
    
    public int getCantButacas() {
        return cantButacas;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setCantButacas(int cantButacas) {
        this.cantButacas = cantButacas;
    }
}