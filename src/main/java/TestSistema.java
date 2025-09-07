import cine.peliculas.Pelicula;
import cine.salas.Sala;
import cine.funciones.Funcion;
import cine.clientes.Cliente;
import cine.clientes.Reserva;
import cine.facturacion.Factura;
import java.util.Date;
import java.util.ArrayList;

public class TestSistema {
    public static void main(String[] args) {
        System.out.println("=== TESTEO COMPLETO DEL SISTEMA DE CINE ===");
        
        try {
            // Inicializar datos de ejemplo primero
            System.out.println("\n0. INICIALIZANDO DATOS DE EJEMPLO...");
            inicializarDatosEjemplo();
            
            // Test 1: Verificar inicializacion de datos
            System.out.println("\n1. TEST: Verificacion de datos inicializados");
            testInicializacion();
            
            // Test 2: Crear funciones
            System.out.println("\n2. TEST: Crear funciones");
            testCrearFunciones();
            
            // Test 3: Crear reservas con seleccion de butacas
            System.out.println("\n3. TEST: Crear reservas");
            testCrearReservas();
            
            // Test 4: Crear facturas
            System.out.println("\n4. TEST: Crear facturas");
            testCrearFacturas();
            
            // Test 5: Verificar estadisticas
            System.out.println("\n5. TEST: Estadisticas finales");
            testEstadisticas();
            
            System.out.println("\n=== TODOS LOS TESTS COMPLETADOS EXITOSAMENTE ===");
            
        } catch (Exception e) {
            System.err.println("ERROR EN TEST: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void inicializarDatosEjemplo() {
        // Crear peliculas
        new Pelicula("Avengers: Endgame", 181, "PG-13", "Accion", "Ingles", "Espanol");
        new Pelicula("Avatar", 162, "PG-13", "Ciencia Ficcion", "Ingles", null);
        new Pelicula("The Dark Knight", 152, "PG-13", "Accion", "Ingles", "Espanol");
        new Pelicula("Spider-Man: No Way Home", 148, "PG-13", "Accion", "Ingles", "Espanol");
        
        // Crear salas
        new Sala(1, 50);
        new Sala(2, 80);
        new Sala(3, 120);
        new Sala(4, 60);
        
        // Crear clientes
        new Cliente(1, "Juan Perez", "juan@email.com", "123-456-789");
        new Cliente(2, "Maria Gomez", "maria@email.com", "987-654-321");
        new Cliente(3, "Pedro Rodriguez", "pedro@email.com", "555-123-456");
        
        System.out.println("Datos de ejemplo inicializados correctamente.");
    }
    
    private static void testInicializacion() {
        // Verificar que se crearon las peliculas
        ArrayList<Pelicula> peliculas = Pelicula.getPeliculas();
        System.out.println("OK Peliculas creadas: " + peliculas.size());
        for (Pelicula p : peliculas) {
            System.out.println("  - " + p.getTitulo());
        }
        
        // Verificar que se crearon las salas
        ArrayList<Sala> salas = Sala.getSalas();
        System.out.println("OK Salas creadas: " + salas.size());
        for (Sala s : salas) {
            System.out.println("  - Sala " + s.getNumero() + " (" + s.getCantButacas() + " butacas)");
        }
        
        // Verificar que se crearon los clientes
        ArrayList<Cliente> clientes = Cliente.getClientes();
        System.out.println("OK Clientes creados: " + clientes.size());
        for (Cliente c : clientes) {
            System.out.println("  - " + c.getNombre());
        }
    }
    
    private static void testCrearFunciones() {
        ArrayList<Pelicula> peliculas = Pelicula.getPeliculas();
        ArrayList<Sala> salas = Sala.getSalas();
        
        // Crear algunas funciones de prueba
        Date horario1 = new Date(System.currentTimeMillis() + 3600000);
        Date horario2 = new Date(System.currentTimeMillis() + 7200000);
        
        Funcion funcion1 = new Funcion(peliculas.get(0), salas.get(0), horario1, 15.0);
        Funcion funcion2 = new Funcion(peliculas.get(1), salas.get(1), horario2, 18.0);
        
        ArrayList<Funcion> funciones = Funcion.getFunciones();
        System.out.println("OK Funciones creadas: " + funciones.size());
        for (Funcion f : funciones) {
            System.out.println("  - " + f.getPelicula().getTitulo() + " - Sala " + f.getSala().getNumero() + 
                             " - $" + f.getPrecioUnitario() + " - Butacas disponibles: " + f.getButacasDisponibles());
        }
    }
    
    private static void testCrearReservas() {
        ArrayList<Cliente> clientes = Cliente.getClientes();
        ArrayList<Funcion> funciones = Funcion.getFunciones();
        
        if (funciones.isEmpty()) {
            System.out.println("ERROR: No hay funciones para crear reservas");
            return;
        }
        
        // Crear reserva 1: 2 entradas
        Cliente cliente1 = clientes.get(0);
        Funcion funcion1 = funciones.get(0);
        
        Reserva reserva1 = new Reserva(1, cliente1, funcion1, 2);
        
        // Seleccionar butacas especificas
        ArrayList<Integer> butacasSeleccionadas1 = new ArrayList<>();
        butacasSeleccionadas1.add(0);
        butacasSeleccionadas1.add(1);
        
        boolean exito1 = reserva1.reservarButacasEspecificas(butacasSeleccionadas1);
        System.out.println("OK Reserva 1 creada: " + (exito1 ? "EXITOSA" : "FALLIDA"));
        if (exito1) {
            System.out.println("  - Cliente: " + reserva1.getCliente().getNombre());
            System.out.println("  - Pelicula: " + reserva1.getFuncion().getPelicula().getTitulo());
            System.out.println("  - Butacas: " + reserva1.getButacasReservadas());
            System.out.println("  - Total: $" + reserva1.getPrecioTotal());
        }
        
        // Crear reserva 2: 1 entrada
        if (clientes.size() > 1 && funciones.size() > 1) {
            Cliente cliente2 = clientes.get(1);
            Funcion funcion2 = funciones.get(1);
            
            Reserva reserva2 = new Reserva(2, cliente2, funcion2, 1);
            
            ArrayList<Integer> butacasSeleccionadas2 = new ArrayList<>();
            butacasSeleccionadas2.add(5);
            
            boolean exito2 = reserva2.reservarButacasEspecificas(butacasSeleccionadas2);
            System.out.println("OK Reserva 2 creada: " + (exito2 ? "EXITOSA" : "FALLIDA"));
            if (exito2) {
                System.out.println("  - Cliente: " + reserva2.getCliente().getNombre());
                System.out.println("  - Pelicula: " + reserva2.getFuncion().getPelicula().getTitulo());
                System.out.println("  - Butacas: " + reserva2.getButacasReservadas());
                System.out.println("  - Total: $" + reserva2.getPrecioTotal());
            }
        }
        
        // Verificar butacas disponibles despues de las reservas
        System.out.println("OK Butacas disponibles despues de reservas:");
        for (Funcion f : funciones) {
            System.out.println("  - " + f.getPelicula().getTitulo() + ": " + f.getButacasDisponibles() + " disponibles");
        }
    }
    
    private static void testCrearFacturas() {
        ArrayList<Reserva> reservasPendientes = Reserva.getReservasPendientesFactura();
        System.out.println("OK Reservas pendientes de factura: " + reservasPendientes.size());
        
        if (reservasPendientes.isEmpty()) {
            System.out.println("ERROR: No hay reservas pendientes para facturar");
            return;
        }
        
        // Crear factura para la primera reserva pendiente
        Reserva reserva = reservasPendientes.get(0);
        ArrayList<Reserva> reservasParaFactura = new ArrayList<>();
        reservasParaFactura.add(reserva);
        
        Factura factura = new Factura(1, reserva.getCliente(), reservasParaFactura);
        
        System.out.println("OK Factura creada:");
        System.out.println("  - ID: " + factura.getId());
        System.out.println("  - Cliente: " + factura.getCliente().getNombre());
        System.out.println("  - Subtotal: $" + factura.getSubtotal());
        System.out.println("  - Impuestos: $" + factura.getImpuestos());
        System.out.println("  - Total: $" + factura.getTotal());
        System.out.println("  - Estado: " + factura.getEstado());
        
        // Confirmar factura (simular pago)
        factura.confirmarFactura();
        System.out.println("OK Factura confirmada - Estado: " + factura.getEstado());
        
        // Verificar que la reserva tambien se confirmo
        System.out.println("OK Reserva confirmada - Estado: " + reserva.getEstado());
    }
    
    private static void testEstadisticas() {
        System.out.println("=== ESTADISTICAS FINALES ===");
        System.out.println("OK Total de peliculas: " + Pelicula.getPeliculas().size());
        System.out.println("OK Total de salas: " + Sala.getSalas().size());
        System.out.println("OK Total de funciones: " + Funcion.getFunciones().size());
        System.out.println("OK Total de clientes: " + Cliente.getClientes().size());
        System.out.println("OK Total de reservas: " + Reserva.getReservas().size());
        System.out.println("OK Total de facturas: " + Factura.getFacturas().size());
        System.out.println("OK Total facturado: $" + Factura.getTotalFacturado());
        
        // Verificar reservas pendientes
        ArrayList<Reserva> reservasPendientes = Reserva.getReservasPendientesFactura();
        System.out.println("OK Reservas pendientes de factura: " + reservasPendientes.size());
        
        // Verificar butacas ocupadas vs disponibles
        ArrayList<Funcion> funciones = Funcion.getFunciones();
        for (Funcion f : funciones) {
            int totalButacas = f.getSala().getCantButacas();
            int disponibles = f.getButacasDisponibles();
            int ocupadas = totalButacas - disponibles;
            System.out.println("OK " + f.getPelicula().getTitulo() + ": " + ocupadas + " ocupadas, " + disponibles + " disponibles");
        }
    }
}
