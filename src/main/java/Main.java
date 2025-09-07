import cine.cine.Cine;
import cine.peliculas.Pelicula;
import cine.peliculas.Idioma;
import cine.salas.Sala;
import cine.funciones.Funcion;
import cine.clientes.Cliente;
import java.util.Date;
import cine.salas.Butaca;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import cine.clientes.Reserva;
import cine.facturacion.Factura;

public class Main {
    public static Cine cine;
    public static List<Cliente> clientes = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CINE ===");
        System.out.println("Aplicacion iniciada correctamente");
        
        try {            
            // Crear idiomas
            Idioma subIngles = new Idioma("Ingles", "Ingles", true);
            Idioma ingeles = new Idioma("Ingles", "Ingles", false);
            Idioma subEspanol = new Idioma("Ingles", "Espanol", true);
            Idioma espanol = new Idioma("Espanol", "Espanol", false);
            
            // Crear peliculas
            Pelicula Avengers = new Pelicula("Avengers: Endgame", 181, "PG-13", "Accion", ingeles);
            Pelicula Avatar = new Pelicula("Avatar", 181, "PG-13", "Accion", subIngles);
            Pelicula TheDarkKnight = new Pelicula("The Dark Knight", 181, "PG-13", "Accion", subEspanol);
            Pelicula TheDarkKnightRises = new Pelicula("The Dark Knight Rises", 181, "PG-13", "Accion", espanol);

            // Crear butacas
            Butaca[] butacasSala1 = crearButacas();
            Butaca[] butacasSala2 = crearButacas();
            Butaca[] butacasSala3 = crearButacas();
            Butaca[] butacasSala4 = crearButacas();
            
            // Crear salas con sus propias butacas
            Sala sala = new Sala(1, butacasSala1, false, false);
            Sala sala2 = new Sala(2, butacasSala2, false, false);
            Sala sala3 = new Sala(3, butacasSala3, false, false);
            Sala sala4 = new Sala(4, butacasSala4, false, false);
            
            // Crear cliente
            Cliente cliente = new Cliente(1, "Juan Perez", "juan@email.com", "123-456-789", new Date());
            Cliente cliente2 = new Cliente(2, "Maria Gomez", "maria@email.com", "123-456-789", new Date());
            Cliente cliente3 = new Cliente(3, "Pedro Rodriguez", "pedro@email.com", "123-456-789", new Date());
            Cliente cliente4 = new Cliente(4, "Ana Lopez", "ana@email.com", "123-456-789", new Date());

            // Listado de clientes
            clientes.add(cliente);
            clientes.add(cliente2);
            clientes.add(cliente3);
            clientes.add(cliente4);

            // Crear funciones con menu de opciones
            System.out.println("--- Menu de opciones ---");
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Crear funcion");
            System.out.println("2. Crear reserva");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("--- Crear funcion ---");
                    crearFuncion(cine, scanner);
                    break;
                case 2:
                    System.out.println("--- Crear reserva ---");
                    break;
                case 3:
                    System.out.println("--- Salir ---");
                    break;
            }

            // Crear cine y agregar elementos
            Cine cine = new Cine(new Pelicula[]{}, new Sala[]{}, new Funcion[]{});
            
            cine.agregarPelicula(Avengers);
            cine.agregarPelicula(Avatar);
            cine.agregarPelicula(TheDarkKnight);
            cine.agregarPelicula(TheDarkKnightRises);
            cine.agregarSala(sala);
            cine.agregarSala(sala2);
            cine.agregarSala(sala3);
            cine.agregarSala(sala4);

            // Crear reserva con menu de opciones
            System.out.println("--- Crear reserva ---");
            System.out.println("1. Mostrar reservas");
            System.out.println("2. Crear reserva");
            System.out.println("3. Salir");
            int opcion2 = scanner.nextInt();
            switch (opcion2) {
                case 1:
                    System.out.println("--- Mostrar reservas ---");
                    break;
                case 2:
                    System.out.println("--- Crear reserva ---");
                    break;
                case 3:
                    System.out.println("--- Salir ---");
                    break;
            }

            // Crear factura con menu de opciones
            
            System.out.println("+ Cine configurado con:");
            System.out.println("  - " + cine.getCartelera().length + " pelicula(s)");
            System.out.println("  - " + cine.getSalas().length + " sala(s)");
            System.out.println("  - " + cine.getFunciones().length + " funcion(es)");
            
            

        } catch (Exception e) {
            System.err.println("Error en el sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Butaca[] crearButacas() {
        Butaca[] butacas = new Butaca[120];
        char fila = 'A';
        for (int i = 0; i < 120; i++) {
            if (i % 10 == 0 && i > 0) {
                fila++;
            }
            butacas[i] = new Butaca(i, String.valueOf(fila), i % 10 + 1, false, 10);
        }
        return butacas;
    }

    public static void mostrarFunciones(Cine cine) {
        Funcion[] funciones = cine.getFunciones();
        for (int i = 0; i < funciones.length; i++) {
            Funcion funcion = funciones[i];
            System.out.println(
                    (i) + ". Funcion: " + funcion.getPelicula().getTitulo() + " - " + funcion.getSala().getNumero()
                            + " - " + funcion.getHorario() + " - " + funcion.getPrecioUnitario());
        }
    }

    public static void mostrarPeliculas(Cine cine) {
        Pelicula[] peliculas = cine.getCartelera();
        for (int i = 0; i < peliculas.length; i++) {
            Pelicula pelicula = peliculas[i];
            System.out.println((i) + ". Pelicula: " + pelicula.getTitulo() + " - " + pelicula.getGenero() + " - "
                    + pelicula.getIdioma().getAudio() + " - " + pelicula.getIdioma().getSubt());
        }
    }

    public static void mostrarSalas(Cine cine) {
        Sala[] salas = cine.getSalas();
        for (int i = 0; i < salas.length; i++) {
            Sala sala = salas[i];
            System.out.println((i) + ". Sala: " + sala.getNumero() + " - " + sala.getButacas().length + " butaca(s)");
        }
    }

    public static void crearFuncion(Cine cine, Scanner scanner) {
        System.out.println("--- Funciones ---");
        mostrarFunciones(cine);
        System.out.println("--- Peliculas ---");
        mostrarPeliculas(cine);
        System.out.println("seleccione el id de la pelicula: ");
        int idPelicula = scanner.nextInt();
        System.out.println("--- Salas ---");
        mostrarSalas(cine);
        System.out.println("Seleccione el id de la sala: ");
        int idSala = scanner.nextInt();
        Funcion funcion = new Funcion(cine.getCartelera()[idPelicula], cine.getSalas()[idSala], new Date(), 10);
        cine.agregarFuncion(funcion);
    }

    public static void crearReserva(Cine cine, Scanner scanner) {
        System.out.println("--- Reservas ---");
        Reserva reserva = new Reserva(1, clientes.get(0), cine.getFunciones()[0], 1, new Date(), "Activa", 10);
        
    }

    public static void crearFactura(Reserva reserva) {
        Factura factura = new Factura(1, clientes.get(0), new Date(), 10, 10, 10, "Activa");
    }
}