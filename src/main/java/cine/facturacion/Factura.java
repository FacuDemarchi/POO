package cine.facturacion;
import java.util.ArrayList;
import java.util.Date;
import cine.clientes.Cliente;
import cine.clientes.Reserva;

public class Factura {
    private int id;
    private Cliente cliente;
    private Date fechaEmision;
    private double subtotal;
    private double impuestos;
    private double total;
    private String estado;
    private ArrayList<Reserva> reservas;
    private static ArrayList<Factura> facturas = new ArrayList<>();
    
    public Factura(int id, Cliente cliente, ArrayList<Reserva> reservas) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = reservas;
        this.fechaEmision = new Date();
        this.estado = "PENDIENTE";
        this.subtotal = calcularSubtotal();
        this.impuestos = calcularImpuestos();
        this.total = calcularTotal();
        addFactura(this);
    }
    
    private double calcularSubtotal() {
        double subtotal = 0.0;
        for (Reserva reserva : reservas) {
            subtotal += reserva.getPrecioTotal();
        }
        return subtotal;
    }
    
    private double calcularImpuestos() {
        // Asumiendo un 21% de IVA
        return subtotal * 0.21;
    }
    
    private double calcularTotal() {
        return subtotal + impuestos;
    }
    
    public void confirmarFactura() {
        this.estado = "CONFIRMADA";
        // Confirmar todas las reservas asociadas
        for (Reserva reserva : reservas) {
            reserva.setEstado("CONFIRMADA");
        }
    }
    
    public void cancelarFactura() {
        this.estado = "CANCELADA";
        // Cancelar todas las reservas asociadas
        for (Reserva reserva : reservas) {
            reserva.cancelarReserva();
        }
    }
    
    public static void addFactura(Factura factura) {
        facturas.add(factura);
    }
    
    public static ArrayList<Factura> getFacturas() {
        return facturas;
    }
    
    public static void eliminarFactura(int id) {
        facturas.removeIf(factura -> factura.getId() == id);
    }
    
    public static ArrayList<Factura> getFacturasPorCliente(int clienteId) {
        ArrayList<Factura> facturasCliente = new ArrayList<>();
        for (Factura factura : facturas) {
            if (factura.getCliente().getId() == clienteId) {
                facturasCliente.add(factura);
            }
        }
        return facturasCliente;
    }
    
    public static double getTotalFacturado() {
        double total = 0.0;
        for (Factura factura : facturas) {
            if ("CONFIRMADA".equals(factura.getEstado())) {
                total += factura.getTotal();
            }
        }
        return total;
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
    
    public Date getFechaEmision() {
        return fechaEmision;
    }
    
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public double getImpuestos() {
        return impuestos;
    }
    
    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
        // Recalcular totales si cambian las reservas
        this.subtotal = calcularSubtotal();
        this.impuestos = calcularImpuestos();
        this.total = calcularTotal();
    }
}