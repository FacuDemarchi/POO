package cine.salas;

public class Sala {
    private int numero;
    private Butaca[] butacas;
    private boolean isPremium;
    private boolean is3D;
    
    public Sala(int numero, Butaca[] butacas, boolean isPremium, boolean is3D) {
        this.numero = numero;
        this.butacas = butacas;
        this.isPremium = isPremium;
        this.is3D = is3D;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public Butaca[] getButacas() {
        return butacas;
    }
    
    public void setButacas(Butaca[] butacas) {
        this.butacas = butacas;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
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
