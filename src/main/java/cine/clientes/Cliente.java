package cine.clientes;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private Date fechaRegistro;
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = new Date();
        addCliente(this);
    }

    public static void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void eliminarCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    
    public String getTelefono() {
        return telefono;
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}