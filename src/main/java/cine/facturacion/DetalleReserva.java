package cine.facturacion;

import cine.salas.Butaca;
import cine.clientes.Reserva;


public class DetalleReserva {
    private int id;
    private Reserva reserva;
    private Butaca butaca;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;

    public DetalleReserva(int id, Reserva reserva, Butaca butaca, int cantidad, double precioUnitario, double precioTotal) {
        this.id = id;
        this.reserva = reserva;
        this.butaca = butaca;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    public int getId() {
        return id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
