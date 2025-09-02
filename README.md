# Sistema de Cine - Proyecto de Programación Orientada a Objetos

Este proyecto implementa un sistema completo de gestión de cine utilizando Java y los principios de Programación Orientada a Objetos (POO).

## Descripción del Sistema

El sistema de cine permite gestionar:
- **Películas** con información detallada e idiomas
- **Salas** con diferentes capacidades y características
- **Funciones** que relacionan películas con salas
- **Clientes** y sus reservas
- **Facturación** y detalles de reservas
- **Gestión central** a través de la clase Cine

## Estructura del Proyecto

```
POO/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java                    # Clase principal de ejecución
│           └── cine/                        # Paquete principal del sistema
│               ├── cine/                    # Gestión central del cine
│               │   └── Cine.java
│               ├── peliculas/               # Gestión de películas
│               │   ├── Pelicula.java
│               │   └── Idioma.java
│               ├── salas/                   # Gestión de salas
│               │   ├── Sala.java
│               │   └── Butaca.java
│               ├── funciones/               # Gestión de funciones
│               │   └── Funcion.java
│               ├── clientes/                # Gestión de clientes
│               │   ├── Cliente.java
│               │   └── Reserva.java
│               └── facturacion/             # Gestión de facturación
│                   ├── Factura.java
│                   └── DetalleReserva.java
├── docs/                                    # Documentación y diagramas
│   └── diagrams/
│       ├── code/                           # Archivos PlantUML
│       │   ├── classes/                    # Diagrama de clases
│       │   ├── packages/                   # Diagrama de paquetes
│       │   └── others/                     # Otros diagramas
│       └── images/                         # Imágenes generadas
├── lib/                                     # Librerías externas
└── README.md
```

## Conceptos de POO Implementados

- **Clases y Objetos**: Todas las entidades del sistema
- **Encapsulación**: Atributos privados con getters y setters
- **Constructores**: Constructores con parámetros para todas las clases
- **Métodos**: Métodos de gestión, búsqueda y manipulación
- **Paquetes**: Organización lógica por funcionalidad
- **Relaciones entre clases**: Asociaciones y dependencias
- **Arrays**: Gestión de colecciones de objetos
- **Manejo de excepciones**: Try-catch en el Main

## Cómo Compilar y Ejecutar

### Opción 1: Desde el directorio raíz del proyecto
```bash
# Compilar todas las clases
javac -cp src/main/java src/main/java/cine/**/*.java src/main/java/Main.java

# Ejecutar
java -cp src/main/java Main
```

### Opción 2: Desde el directorio src/main/java
```bash
# Navegar al directorio
cd src/main/java

# Compilar
javac cine/**/*.java Main.java

# Ejecutar
java Main
```

### Opción 3: Compilación individual por paquete
```bash
cd src/main/java

# Compilar paquete por paquete
javac cine/peliculas/*.java
javac cine/salas/*.java
javac cine/funciones/*.java
javac cine/clientes/*.java
javac cine/facturacion/*.java
javac cine/cine/*.java
javac Main.java

# Ejecutar
java Main
```

## Funcionalidades del Sistema

### Gestión de Películas
- Crear películas con título, duración, rating, género e idioma
- Gestionar idiomas con audio y subtítulos
- Buscar películas por título

### Gestión de Salas
- Crear salas con número, capacidad y características (Premium, 3D)
- Gestionar butacas individuales
- Buscar salas por número

### Gestión de Funciones
- Programar funciones asociando películas con salas
- Establecer horarios y precios
- Buscar funciones por título de película

### Gestión de Clientes y Reservas
- Registrar clientes con información personal
- Crear reservas para funciones específicas
- Gestionar estados de reservas

### Facturación
- Generar facturas para reservas
- Calcular subtotales, impuestos y totales
- Gestionar detalles de reservas

### Gestión Central del Cine
- Agregar/eliminar películas, salas y funciones
- Búsquedas centralizadas
- Gestión de arrays de objetos

## Diagramas del Sistema

El proyecto incluye diagramas UML generados con PlantUML:
- **Diagrama de Clases**: Muestra todas las entidades y sus relaciones
- **Diagrama de Paquetes**: Estructura organizacional del código
- **Imágenes PNG**: Generadas automáticamente desde los archivos .puml

### Generar Diagramas
```bash
cd docs/diagrams/code
java -jar plantuml.jar classes/cine.puml
java -jar plantuml.jar others/packages.puml
```

## Próximos Pasos de Desarrollo

1. **Implementar herencia** entre clases relacionadas
2. **Agregar interfaces** para comportamientos comunes
3. **Implementar polimorfismo** en métodos de búsqueda
4. **Mejorar manejo de excepciones** con excepciones personalizadas
5. **Reemplazar arrays** con colecciones (ArrayList, HashMap)
6. **Agregar persistencia** de datos (archivos o base de datos)
7. **Implementar interfaz gráfica** (Swing o JavaFX)
8. **Agregar validaciones** de datos de entrada

## Recursos de Aprendizaje

- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
- [PlantUML Documentation](https://plantuml.com/)
- [UML Class Diagrams](https://www.uml-diagrams.org/class-diagrams.html)
