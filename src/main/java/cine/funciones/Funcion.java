package cine.funciones;
import java.util.ArrayList;
import java.util.Date;
import cine.peliculas.Pelicula;
import cine.salas.Sala;

public class Funcion {
    private Pelicula pelicula;
    private Sala sala;
    private Date horario;
    private double precioUnitario;
    private ArrayList<Boolean> butacas;
    private static ArrayList<Funcion> funciones = new ArrayList<>();
    
    public Funcion(Pelicula pelicula, Sala sala, Date horario, double precioUnitario) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario; 
        this.precioUnitario = precioUnitario;
        this.butacas = inicializarButacas(sala.getCantButacas());
        addFuncion(this);
    }
    
    private ArrayList<Boolean> inicializarButacas(int cantidadButacas) {
        ArrayList<Boolean> butacas = new ArrayList<>();
        for (int i = 0; i < cantidadButacas; i++) {
            butacas.add(false); // Todas las butacas empiezan disponibles
        }
        return butacas;
    }
    
    public static void addFuncion(Funcion funcion) {
        funciones.add(funcion);
    }
    
    public static ArrayList<Funcion> getFunciones() {
        return funciones;
    }
    
    public static void eliminarFuncion(int id) {
        // Necesitarías agregar un ID a Funcion para eliminar por ID
        // Por ahora, eliminar por índice o por otros criterios
    }
    
    public boolean reservarButaca(int numeroButaca) {
        if (numeroButaca >= 0 && numeroButaca < butacas.size() && !butacas.get(numeroButaca)) {
            butacas.set(numeroButaca, true);
            return true; // Reserva exitosa
        }
        return false; // Butaca ocupada o número inválido
    }
    
    public boolean liberarButaca(int numeroButaca) {
        if (numeroButaca >= 0 && numeroButaca < butacas.size() && butacas.get(numeroButaca)) {
            butacas.set(numeroButaca, false);
            return true; // Liberación exitosa
        }
        return false; // Butaca ya libre o número inválido
    }
    
    public int getButacasDisponibles() {
        int disponibles = 0;
        for (Boolean ocupada : butacas) {
            if (!ocupada) {
                disponibles++;
            }
        }
        return disponibles;
    }
    
    public ArrayList<Integer> getButacasDisponiblesLista() {
        ArrayList<Integer> butacasDisponibles = new ArrayList<>();
        for (int i = 0; i < butacas.size(); i++) {
            if (!butacas.get(i)) {
                butacasDisponibles.add(i); // Agregar el número de butaca (índice)
            }
        }
        return butacasDisponibles;
    }
    
    // Getters y Setters
    public Pelicula getPelicula() {
        return pelicula;
    }
    
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
    public Sala getSala() {
        return sala;
    }
    
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public Date getHorario() {
        return horario;
    }
    
    public void setHorario(Date horario) {
        this.horario = horario;
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public ArrayList<Boolean> getButacas() {
        return butacas;
    }
    
    public void setButacas(ArrayList<Boolean> butacas) {
        this.butacas = butacas;
    }
}