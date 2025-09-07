import cine.peliculas.Pelicula;
import cine.salas.Sala;
import cine.funciones.Funcion;
import cine.clientes.Cliente;
import cine.clientes.Reserva;
import cine.facturacion.Factura;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CINE ===");
        System.out.println("Aplicacion iniciada correctamente");
        
        try {            
            // Inicializar datos de ejemplo
            inicializarDatosEjemplo();
            
            // Mostrar menu principal
            mostrarMenuPrincipal();
            
        } catch (Exception e) {
            System.err.println("Error en el sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void inicializarDatosEjemplo() {
        System.out.println("\nInicializando datos de ejemplo...");
            
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
        
        System.out.println("Datos inicializados correctamente.");
    }
    
    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Administrar Funciones");
            System.out.println("2. Administrar Reservas y Facturas");
            System.out.println("3. Ver Informacion del Sistema");
            System.out.println("4. Ver Estadisticas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    menuAdministrarFunciones();
                    break;
                case 2:
                    menuAdministrarReservas();
                    break;
                case 3:
                    mostrarInformacionSistema();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }
    
    private static void menuAdministrarFunciones() {
        int opcion;
        do {
            System.out.println("\n=== ADMINISTRAR FUNCIONES ===");
            System.out.println("1. Crear Nueva Funcion");
            System.out.println("2. Ver Todas las Funciones");
            System.out.println("3. Ver Butacas Disponibles de una Funcion");
            System.out.println("4. Eliminar Funcion");
            System.out.println("0. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    crearNuevaFuncion();
                    break;
                case 2:
                    mostrarTodasLasFunciones();
                    break;
                case 3:
                    verButacasDisponibles();
                    break;
                case 4:
                    eliminarFuncion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }
    
    private static void menuAdministrarReservas() {
        int opcion;
        do {
            System.out.println("\n=== ADMINISTRAR RESERVAS Y FACTURAS ===");
            System.out.println("1. Crear Nueva Reserva");
            System.out.println("2. Ver Todas las Reservas");
            System.out.println("3. Ver Reservas por Cliente");
            System.out.println("4. Cancelar Reserva");
            System.out.println("5. Ver Reservas Pendientes de Factura");
            System.out.println("6. Crear Factura");
            System.out.println("7. Ver Todas las Facturas");
            System.out.println("8. Confirmar Factura");
            System.out.println("0. Volver al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    crearNuevaReserva();
                    break;
                case 2:
                    mostrarTodasLasReservas();
                    break;
                case 3:
                    verReservasPorCliente();
                    break;
                case 4:
                    cancelarReserva();
                    break;
                case 5:
                    verReservasPendientesFactura();
                    break;
                case 6:
                    crearFactura();
                    break;
                case 7:
                    mostrarTodasLasFacturas();
                    break;
                case 8:
                    confirmarFactura();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }
    
    private static void crearNuevaFuncion() {
        System.out.println("\n--- CREAR NUEVA FUNCION ---");
        
        // Mostrar peliculas disponibles
        System.out.println("Peliculas disponibles:");
        ArrayList<Pelicula> peliculas = Pelicula.getPeliculas();
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println((i + 1) + ". " + peliculas.get(i).getTitulo());
        }
        
        System.out.print("Seleccione una pelicula (numero): ");
        int indicePelicula = scanner.nextInt() - 1;
        
        // Mostrar salas disponibles
        System.out.println("\nSalas disponibles:");
        ArrayList<Sala> salas = Sala.getSalas();
        for (int i = 0; i < salas.size(); i++) {
            System.out.println((i + 1) + ". Sala " + salas.get(i).getNumero() + 
                             " (" + salas.get(i).getCantButacas().length + " butacas)");
        }
        
        System.out.print("Seleccione una sala (numero): ");
        int indiceSala = scanner.nextInt() - 1;
        
        System.out.print("Ingrese el precio unitario: $");
        double precio = scanner.nextDouble();
        
        // Crear funcion con horario actual + 1 hora
        Date horario = new Date(System.currentTimeMillis() + 3600000);
        Funcion nuevaFuncion = new Funcion(peliculas.get(indicePelicula), 
                                         salas.get(indiceSala), 
                                         horario, 
                                         precio);
        
        System.out.println("Funcion creada exitosamente!");
        System.out.println("ID: " + nuevaFuncion.hashCode()); // Usar hash como ID temporal
    }
    
    private static void mostrarTodasLasFunciones() {
        System.out.println("\n--- TODAS LAS FUNCIONES ---");
        ArrayList<Funcion> funciones = Funcion.getFunciones();
        
        if (funciones.isEmpty()) {
            System.out.println("No hay funciones creadas.");
            return;
        }
        
        for (int i = 0; i < funciones.size(); i++) {
            Funcion funcion = funciones.get(i);
            System.out.println((i + 1) + ". " + funcion.getPelicula().getTitulo() + 
                             " - Sala " + funcion.getSala().getNumero() + 
                             " - " + funcion.getHorario() + 
                             " - $" + funcion.getPrecioUnitario() +
                             " - Butacas disponibles: " + funcion.getButacasDisponibles());
        }
    }
    
    private static void verButacasDisponibles() {
        System.out.println("\n--- VER BUTACAS DISPONIBLES ---");
        mostrarTodasLasFunciones();
        
        System.out.print("Seleccione una funcion (numero): ");
        int indice = scanner.nextInt() - 1;
        
        ArrayList<Funcion> funciones = Funcion.getFunciones();
        if (indice >= 0 && indice < funciones.size()) {
            Funcion funcion = funciones.get(indice);
            ArrayList<Integer> butacasDisponibles = funcion.getButacasDisponiblesLista();
            
            System.out.println("Butacas disponibles para " + funcion.getPelicula().getTitulo() + ":");
            System.out.println("Total disponibles: " + butacasDisponibles.size());
            System.out.println("Butacas: " + butacasDisponibles);
        } else {
            System.out.println("Funcion no encontrada.");
        }
    }
    
    private static void eliminarFuncion() {
        System.out.println("\n--- ELIMINAR FUNCION ---");
        mostrarTodasLasFunciones();
        
        System.out.print("Seleccione una funcion para eliminar (numero): ");
        int indice = scanner.nextInt() - 1;
        
        ArrayList<Funcion> funciones = Funcion.getFunciones();
        if (indice >= 0 && indice < funciones.size()) {
            funciones.remove(indice);
            System.out.println("Funcion eliminada exitosamente.");
        } else {
            System.out.println("Funcion no encontrada.");
        }
    }
    
    private static void crearNuevaReserva() {
        System.out.println("\n--- CREAR NUEVA RESERVA ---");
        
        // Mostrar clientes
        System.out.println("Clientes disponibles:");
        ArrayList<Cliente> clientes = Cliente.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNombre() + 
                             " (" + clientes.get(i).getEmail() + ")");
        }
        
        System.out.print("Seleccione un cliente (numero): ");
        int indiceCliente = scanner.nextInt() - 1;
        
        // Mostrar funciones disponibles
        System.out.println("\nFunciones disponibles:");
        mostrarTodasLasFunciones();
        
        System.out.print("Seleccione una funcion (numero): ");
        int indiceFuncion = scanner.nextInt() - 1;
        
        System.out.print("Cantidad de entradas: ");
        int cantidad = scanner.nextInt();
        
        // Mostrar butacas disponibles y permitir selección
        Funcion funcion = Funcion.getFunciones().get(indiceFuncion);
        ArrayList<Integer> butacasDisponibles = funcion.getButacasDisponiblesLista();
        
        if (butacasDisponibles.size() < cantidad) {
            System.out.println("No hay suficientes butacas disponibles.");
            return;
        }
        
        System.out.println("\nButacas disponibles: " + butacasDisponibles);
        ArrayList<Integer> butacasSeleccionadas = new ArrayList<>();
        
        // Seleccionar butacas específicas
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Seleccione butaca " + (i + 1) + " de " + cantidad + ": ");
            int butaca = scanner.nextInt();
            
            if (butacasDisponibles.contains(butaca) && !butacasSeleccionadas.contains(butaca)) {
                butacasSeleccionadas.add(butaca);
                System.out.println("Butaca " + butaca + " seleccionada.");
            } else {
                System.out.println("Butaca no disponible o ya seleccionada. Intente otra.");
                i--; // Repetir esta iteración
            }
        }
        
        // Crear reserva
        Reserva nuevaReserva = new Reserva(Reserva.getReservas().size() + 1, 
                                         clientes.get(indiceCliente), 
                                         funcion, 
                                         cantidad);
        
        if (nuevaReserva.reservarButacasEspecificas(butacasSeleccionadas)) {
            System.out.println("Reserva creada exitosamente!");
            System.out.println("ID: " + nuevaReserva.getId());
            System.out.println("Butacas reservadas: " + nuevaReserva.getButacasReservadas());
            System.out.println("Precio total: $" + nuevaReserva.getPrecioTotal());
        } else {
            System.out.println("No se pudo crear la reserva.");
        }
    }
    
    private static void mostrarTodasLasReservas() {
        System.out.println("\n--- TODAS LAS RESERVAS ---");
        ArrayList<Reserva> reservas = Reserva.getReservas();
        
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas creadas.");
            return;
        }
        
        for (Reserva reserva : reservas) {
            System.out.println("ID: " + reserva.getId() + 
                             " - Cliente: " + reserva.getCliente().getNombre() + 
                             " - Pelicula: " + reserva.getFuncion().getPelicula().getTitulo() + 
                             " - Entradas: " + reserva.getCantidadEntradas() + 
                             " - Estado: " + reserva.getEstado() + 
                             " - Total: $" + reserva.getPrecioTotal());
        }
    }
    
    private static void verReservasPorCliente() {
        System.out.println("\n--- RESERVAS POR CLIENTE ---");
        
        System.out.println("Clientes disponibles:");
        ArrayList<Cliente> clientes = Cliente.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNombre());
        }
        
        System.out.print("Seleccione un cliente (numero): ");
        int indice = scanner.nextInt() - 1;
        
        if (indice >= 0 && indice < clientes.size()) {
            Cliente cliente = clientes.get(indice);
            ArrayList<Reserva> reservasCliente = Reserva.getReservasPorCliente(cliente.getId());
            
            System.out.println("Reservas de " + cliente.getNombre() + ":");
            if (reservasCliente.isEmpty()) {
                System.out.println("No tiene reservas.");
            } else {
                for (Reserva reserva : reservasCliente) {
                    System.out.println("- " + reserva.getFuncion().getPelicula().getTitulo() + 
                                     " - " + reserva.getCantidadEntradas() + " entradas - $" + reserva.getPrecioTotal());
                }
            }
        }
    }
    
    private static void cancelarReserva() {
        System.out.println("\n--- CANCELAR RESERVA ---");
        mostrarTodasLasReservas();
        
        System.out.print("Ingrese el ID de la reserva a cancelar: ");
        int idReserva = scanner.nextInt();
        
        ArrayList<Reserva> reservas = Reserva.getReservas();
        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) {
                reserva.cancelarReserva();
                System.out.println("Reserva cancelada exitosamente.");
                return;
            }
        }
        System.out.println("Reserva no encontrada.");
    }
    
    private static void verReservasPendientesFactura() {
        System.out.println("\n--- RESERVAS PENDIENTES DE FACTURA ---");
        ArrayList<Reserva> reservasPendientes = Reserva.getReservasPendientesFactura();
        
        if (reservasPendientes.isEmpty()) {
            System.out.println("No hay reservas pendientes de factura.");
            return;
        }
        
        for (Reserva reserva : reservasPendientes) {
            System.out.println("ID: " + reserva.getId() + 
                             " - Cliente: " + reserva.getCliente().getNombre() + 
                             " - Pelicula: " + reserva.getFuncion().getPelicula().getTitulo() + 
                             " - Butacas: " + reserva.getButacasReservadas() + 
                             " - Total: $" + reserva.getPrecioTotal());
        }
    }
    
    private static void crearFactura() {
        System.out.println("\n--- CREAR FACTURA ---");
        
        // Mostrar solo reservas pendientes de factura
        ArrayList<Reserva> reservasPendientes = Reserva.getReservasPendientesFactura();
        
        if (reservasPendientes.isEmpty()) {
            System.out.println("No hay reservas pendientes de factura.");
            return;
        }
        
        System.out.println("Reservas pendientes de factura:");
        for (int i = 0; i < reservasPendientes.size(); i++) {
            Reserva reserva = reservasPendientes.get(i);
            System.out.println((i + 1) + ". ID: " + reserva.getId() + 
                             " - Cliente: " + reserva.getCliente().getNombre() + 
                             " - Pelicula: " + reserva.getFuncion().getPelicula().getTitulo() + 
                             " - $" + reserva.getPrecioTotal());
        }
        
        System.out.print("Seleccione una reserva (numero): ");
        int indice = scanner.nextInt() - 1;
        
        if (indice >= 0 && indice < reservasPendientes.size()) {
            Reserva reserva = reservasPendientes.get(indice);
            ArrayList<Reserva> reservasParaFactura = new ArrayList<>();
            reservasParaFactura.add(reserva);
            
            // Crear factura
            Factura nuevaFactura = new Factura(Factura.getFacturas().size() + 1, 
                                             reserva.getCliente(), 
                                             reservasParaFactura);
            
            System.out.println("Factura creada exitosamente!");
            System.out.println("ID: " + nuevaFactura.getId());
            System.out.println("Subtotal: $" + nuevaFactura.getSubtotal());
            System.out.println("Impuestos: $" + nuevaFactura.getImpuestos());
            System.out.println("Total: $" + nuevaFactura.getTotal());
            
            // Preguntar si efectuar pago
            System.out.print("\n¿Efectuar pago ahora? (1=Si, 0=No): ");
            int efectuarPago = scanner.nextInt();
            
            if (efectuarPago == 1) {
                nuevaFactura.confirmarFactura();
                System.out.println("Pago efectuado. Factura confirmada.");
            } else {
                System.out.println("Factura creada en estado PENDIENTE.");
            }
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }
    
    private static void mostrarTodasLasFacturas() {
        System.out.println("\n--- TODAS LAS FACTURAS ---");
        ArrayList<Factura> facturas = Factura.getFacturas();
        
        if (facturas.isEmpty()) {
            System.out.println("No hay facturas creadas.");
            return;
        }
        
        for (Factura factura : facturas) {
            System.out.println("ID: " + factura.getId() + 
                             " - Cliente: " + factura.getCliente().getNombre() + 
                             " - Estado: " + factura.getEstado() + 
                             " - Total: $" + factura.getTotal());
        }
    }
    
    private static void confirmarFactura() {
        System.out.println("\n--- CONFIRMAR FACTURA ---");
        mostrarTodasLasFacturas();
        
        System.out.print("Ingrese el ID de la factura a confirmar: ");
        int idFactura = scanner.nextInt();
        
        ArrayList<Factura> facturas = Factura.getFacturas();
        for (Factura factura : facturas) {
            if (factura.getId() == idFactura) {
                factura.confirmarFactura();
                System.out.println("Factura confirmada exitosamente.");
                return;
            }
        }
        System.out.println("Factura no encontrada.");
    }
    
    private static void mostrarInformacionSistema() {
        System.out.println("\n=== INFORMACION DEL SISTEMA ===");
        
        System.out.println("\n--- PELICULAS ---");
        for (Pelicula pelicula : Pelicula.getPeliculas()) {
            System.out.println("- " + pelicula.getTitulo() + " (" + pelicula.getDuracion() + " min) - " + 
                             pelicula.getGenero() + " - " + pelicula.getIdioma() + 
                             (pelicula.getSubtitulos() != null ? " - Subt: " + pelicula.getSubtitulos() : ""));
        }
        
        System.out.println("\n--- SALAS ---");
        for (Sala sala : Sala.getSalas()) {
            System.out.println("- Sala " + sala.getNumero() + " - " + sala.getCantButacas().length + " butacas");
        }
        
        System.out.println("\n--- FUNCIONES ---");
        for (Funcion funcion : Funcion.getFunciones()) {
            System.out.println("- " + funcion.getPelicula().getTitulo() + " - Sala " + funcion.getSala().getNumero() + 
                             " - " + funcion.getHorario() + " - $" + funcion.getPrecioUnitario());
        }
        
        System.out.println("\n--- CLIENTES ---");
        for (Cliente cliente : Cliente.getClientes()) {
            System.out.println("- " + cliente.getNombre() + " (" + cliente.getEmail() + ")");
        }
    }
    
    private static void mostrarEstadisticas() {
        System.out.println("\n=== ESTADISTICAS FINALES ===");
        
        System.out.println("Total de peliculas: " + Pelicula.getPeliculas().size());
        System.out.println("Total de salas: " + Sala.getSalas().size());
        System.out.println("Total de funciones: " + Funcion.getFunciones().size());
        System.out.println("Total de clientes: " + Cliente.getClientes().size());
        System.out.println("Total de reservas: " + Reserva.getReservas().size());
        System.out.println("Total de facturas: " + Factura.getFacturas().size());
        System.out.println("Total facturado: $" + Factura.getTotalFacturado());
    }
}
