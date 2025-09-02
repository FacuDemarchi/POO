import cine.cine.Cine;
import cine.peliculas.Pelicula;
import cine.peliculas.Idioma;
import cine.salas.Sala;
import cine.funciones.Funcion;
import cine.clientes.Cliente;
import cine.clientes.Reserva;
import cine.facturacion.Factura;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CINE ===");
        System.out.println("Aplicación iniciada correctamente");
        
        try {
            // Crear instancias de ejemplo
            System.out.println("\n--- Creando entidades del sistema ---");
            
            // Crear idioma
            Idioma idioma = new Idioma("Español", "Inglés", true);
            System.out.println("✓ Idioma creado: " + idioma.getAudio() + " con subtítulos en " + idioma.getSubt());
            
            // Crear película
            Pelicula pelicula = new Pelicula("Avengers: Endgame", 181, "PG-13", "Acción", idioma);
            System.out.println("✓ Película creada: " + pelicula.getTitulo() + " (" + pelicula.getDuracion() + " min)");
            
            // Crear sala
            Sala sala = new Sala(1, 120, false, false);
            System.out.println("✓ Sala creada: Número " + sala.getNumero() + " con " + sala.getButacas() + " butacas");
            
            // Crear función
            Date horario = new Date();
            Funcion funcion = new Funcion(pelicula, sala, horario, 12.50);
            System.out.println("✓ Función creada: " + pelicula.getTitulo() + " en sala " + sala.getNumero());
            
            // Crear cliente
            Cliente cliente = new Cliente(1, "Juan Pérez", "juan@email.com", "123-456-789", new Date());
            System.out.println("✓ Cliente creado: " + cliente.getNombre());
            
            // Crear reserva
            Reserva reserva = new Reserva(1, cliente, funcion, 2, new Date(), "Confirmada", 25.00);
            System.out.println("✓ Reserva creada: " + reserva.getCantidadEntradas() + " entradas para " + cliente.getNombre());
            
            // Crear factura
            Factura factura = new Factura(1, cliente, new Date(), 25.00, 2.50, 27.50, "Pagada");
            System.out.println("✓ Factura creada: Total $" + factura.getTotal());
            
            // Crear cine y agregar elementos
            System.out.println("\n--- Configurando el cine ---");
            Cine cine = new Cine(new Pelicula[]{}, new Sala[]{}, new Funcion[]{});
            
            cine.agregarPelicula(pelicula);
            cine.agregarSala(sala);
            cine.agregarFuncion(funcion);
            
            System.out.println("✓ Cine configurado con:");
            System.out.println("  - " + cine.getCartelera().length + " película(s)");
            System.out.println("  - " + cine.getSalas().length + " sala(s)");
            System.out.println("  - " + cine.getFunciones().length + " función(es)");
            
            // Probar búsquedas
            System.out.println("\n--- Probando funcionalidades ---");
            Pelicula peliculaEncontrada = cine.buscarPelicula("Avengers: Endgame");
            if (peliculaEncontrada != null) {
                System.out.println("✓ Película encontrada: " + peliculaEncontrada.getTitulo());
            }
            
            Sala salaEncontrada = cine.buscarSala(1);
            if (salaEncontrada != null) {
                System.out.println("✓ Sala encontrada: Número " + salaEncontrada.getNumero());
            }
            
            System.out.println("\n=== SISTEMA FUNCIONANDO CORRECTAMENTE ===");
            
        } catch (Exception e) {
            System.err.println("Error en el sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
