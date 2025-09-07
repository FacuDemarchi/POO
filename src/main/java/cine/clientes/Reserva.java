package cine.clientes;
import java.util.ArrayList;
import java.util.Date;
import cine.funciones.Funcion;
import cine.facturacion.Factura;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Funcion funcion;
    private int cantidadEntradas;
    private Date fechaReserva;
    private String estado;
    private double precioTotal;
    private ArrayList<Integer> butacasReservadas;
    private static ArrayList<Reserva> reservas = new ArrayList<>();
    
    public Reserva(int id, Cliente cliente, Funcion funcion, int cantidadEntradas) {
        this.id = id;
        this.cliente = cliente;
        this.funcion = funcion;
        this.cantidadEntradas = cantidadEntradas;
        this.fechaReserva = new Date();
        this.estado = "PENDIENTE";
        this.precioTotal = calcularPrecioTotal();
        this.butacasReservadas = new ArrayList<>();
        addReserva(this);
    }
    
    private double calcularPrecioTotal() {
        return cantidadEntradas * funcion.getPrecioUnitario();
    }
    
    public boolean reservarButacas() {
        ArrayList<Integer> butacasDisponibles = funcion.getButacasDisponiblesLista();
        
        if (butacasDisponibles.size() >= cantidadEntradas) {
            // Las butacas ya fueron seleccionadas en el método crearNuevaReserva
            // Solo confirmar la reserva
            this.estado = "CONFIRMADA";
            return true;
        }
        return false; // No hay suficientes butacas disponibles
    }
    
    public boolean reservarButacasEspecificas(ArrayList<Integer> butacasSeleccionadas) {
        // Verificar que todas las butacas estén disponibles
        for (Integer butaca : butacasSeleccionadas) {
            if (!funcion.getButacasDisponiblesLista().contains(butaca)) {
                return false; // Una o más butacas no están disponibles
            }
        }
        
        // Reservar las butacas específicas
        for (Integer butaca : butacasSeleccionadas) {
            funcion.reservarButaca(butaca);
            butacasReservadas.add(butaca);
        }
        
        this.estado = "CONFIRMADA";
        return true;
    }
    
    public void cancelarReserva() {
        // Liberar las butacas reservadas específicas
        for (Integer numeroButaca : butacasReservadas) {
            funcion.liberarButaca(numeroButaca);
        }
        butacasReservadas.clear(); // Limpiar la lista
        this.estado = "CANCELADA";
    }
    
    public static void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    
    public static ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
    public static void eliminarReserva(int id) {
        reservas.removeIf(reserva -> reserva.getId() == id);
    }
    
    public static ArrayList<Reserva> getReservasPorCliente(int clienteId) {
        ArrayList<Reserva> reservasCliente = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getId() == clienteId) {
                reservasCliente.add(reserva);
            }
        }
        return reservasCliente;
    }
    
    public static ArrayList<Reserva> getReservasPorFuncion(int funcionId) {
        ArrayList<Reserva> reservasFuncion = new ArrayList<>();
        for (Reserva reserva : reservas) {
            // Necesitarías agregar getId() a Funcion
            // if (reserva.getFuncion().getId() == funcionId) {
            //     reservasFuncion.add(reserva);
            // }
        }
        return reservasFuncion;
    }
    
    public static ArrayList<Reserva> getReservasPendientesFactura() {
        ArrayList<Reserva> reservasPendientes = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if ("CONFIRMADA".equals(reserva.getEstado()) && !tieneFactura(reserva)) {
                reservasPendientes.add(reserva);
            }
        }
        return reservasPendientes;
    }
    
    private static boolean tieneFactura(Reserva reserva) {
        // Verificar si la reserva ya tiene una factura asociada
        for (Factura factura : Factura.getFacturas()) {
            if (factura.getReservas().contains(reserva)) {
                return true;
            }
        }
        return false;
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Funcion getFuncion() {
        return funcion;
    }
    
    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
    
    public int getCantidadEntradas() {
        return cantidadEntradas;
    }
    
    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
        this.precioTotal = calcularPrecioTotal(); // Recalcular precio
    }
    
    public Date getFechaReserva() {
        return fechaReserva;
    }
    
    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public double getPrecioTotal() {
        return precioTotal;
    }
    
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    public ArrayList<Integer> getButacasReservadas() {
        return butacasReservadas;
    }
    
    public void setButacasReservadas(ArrayList<Integer> butacasReservadas) {
        this.butacasReservadas = butacasReservadas;
    }
}