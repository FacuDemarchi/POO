package cine.salas;

public class Sala {
    private int numero;
    private int butacas;
    private boolean isPremium;
    private boolean is3D;
    
    public Sala(int numero, int butacas, boolean isPremium, boolean is3D) {
        this.numero = numero;
        this.butacas = butacas;
        this.isPremium = isPremium;
        this.is3D = is3D;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getButacas() {
        return butacas;
    }
    
    public void setButacas(int butacas) {
        this.butacas = butacas;
    }
    
    public boolean isPremium() {
        return isPremium;
    }
    
    public void setPremium(boolean premium) {
        isPremium = premium;
    }
    
    public boolean is3D() {
        return is3D;
    }
    
    public void set3D(boolean is3D) {
        this.is3D = is3D;
    }
}
