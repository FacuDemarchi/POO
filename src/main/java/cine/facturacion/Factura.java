package cine.facturacion;

import java.util.Date;
import cine.clientes.Cliente;

public class Factura {
    private int id;
    private Cliente cliente;
    private Date fechaEmision;
    private double subtotal;
    private double impuestos;
    private double total;
    private String estado;
    
    public Factura(int id, Cliente cliente, Date fechaEmision, double subtotal, double impuestos, double total, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.fechaEmision = fechaEmision;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.total = total;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public Date getFechaEmision() {
        return fechaEmision;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    public double getImpuestos() {
        return impuestos;
    }

    public double getTotal() {
        return total;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }
}
