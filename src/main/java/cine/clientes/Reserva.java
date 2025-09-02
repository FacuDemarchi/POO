package cine.clientes;

import java.util.Date;
import cine.funciones.Funcion;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Funcion funcion;
    private int cantidadEntradas;
    private Date fechaReserva;
    private String estado;
    private double precioTotal;
    
    public Reserva(int id, Cliente cliente, Funcion funcion, int cantidadEntradas, Date fechaReserva, String estado, double precioTotal) {
        this.id = id;
        this.cliente = cliente;
        this.funcion = funcion;
        this.cantidadEntradas = cantidadEntradas;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
        this.precioTotal = precioTotal;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public Funcion getFuncion() {
        return funcion;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }
    
    public Date getFechaReserva() {
        return fechaReserva;
    }

    public String getEstado() {
        return estado;
    }
    
    public double getPrecioTotal() {
        return precioTotal;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
    
    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
}
