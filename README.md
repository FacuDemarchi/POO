# Sistema de Cine - Proyecto de Programación Orientada a Objetos

Este proyecto implementa un sistema completo de gestión de cine utilizando Java y los principios de Programación Orientada a Objetos (POO).

## Descripción del Sistema

El sistema de cine permite gestionar:
- **Películas** con información detallada, idiomas y subtítulos
- **Salas** con diferentes capacidades y gestión de butacas
- **Funciones** que relacionan películas con salas y horarios
- **Clientes** y sus reservas con selección específica de butacas
- **Facturación** completa con impuestos y estados de pago
- **Menús interactivos** para administración del sistema

## Estructura del Proyecto

```
POO/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java                    # Aplicación principal con menús interactivos
│           ├── TestSistema.java             # Suite de pruebas automatizadas
│           └── cine/                        # Paquete principal del sistema
│               ├── peliculas/               # Gestión de películas
│               │   └── Pelicula.java
│               ├── salas/                   # Gestión de salas
│               │   └── Sala.java
│               ├── funciones/               # Gestión de funciones
│               │   └── Funcion.java
│               ├── clientes/                # Gestión de clientes y reservas
│               │   ├── Cliente.java
│               │   └── Reserva.java
│               └── facturacion/             # Gestión de facturación
│                   └── Factura.java
├── docs/                                    # Documentación y diagramas
│   └── diagrams/
│       ├── code/                           # Archivos PlantUML
│       │   ├── cine.puml                   # Diagrama de clases
│       │   ├── packages.puml               # Diagrama de paquetes
│       │   ├── generate.bat                # Script de generación automática
│       │   └── plantuml.jar                # Librería PlantUML
│       └── images/                         # Imágenes generadas
│           ├── Cine.png
│           └── Packages.png
├── lib/                                     # Archivos compilados (.class)
└── README.md
```

## Características Principales

### 🎬 Gestión de Películas
- Información completa: título, duración, rating, género
- Soporte para idiomas y subtítulos (opcional)
- Auto-registro en lista estática global

### 🏢 Gestión de Salas
- Salas con diferentes capacidades (50, 80, 120, 60 butacas)
- Sistema de numeración de butacas automático
- Auto-registro en lista estática global

### 🎭 Gestión de Funciones
- Asociación de películas con salas
- Horarios y precios configurables
- Sistema de butacas ocupadas/disponibles
- Métodos para reservar y liberar butacas específicas

### 👥 Gestión de Clientes y Reservas
- Registro de clientes con información personal
- **Selección específica de butacas** en reservas
- Estados de reserva (PENDIENTE, CONFIRMADA, CANCELADA)
- Cálculo automático de precios totales

### 💰 Sistema de Facturación
- Facturas con subtotal, impuestos (21%) y total
- Estados de factura (PENDIENTE, CONFIRMADA)
- Confirmación de pago que actualiza reservas asociadas
- Cálculo de total facturado del sistema

### 🖥️ Interfaz de Usuario
- **Menú principal** con opciones organizadas
- **Menú de administración de funciones** (crear, ver, eliminar, ver butacas)
- **Menú de reservas y facturas** (crear reservas, facturar, confirmar pagos)
- **Información del sistema** y estadísticas en tiempo real

## Conceptos de POO Implementados

- **Clases y Objetos**: Todas las entidades del sistema
- **Encapsulación**: Atributos privados con getters y setters
- **Constructores**: Constructores con parámetros y sobrecarga
- **Métodos estáticos**: Para gestión global de listas de objetos
- **Paquetes**: Organización lógica por funcionalidad
- **Relaciones entre clases**: Asociaciones y dependencias
- **ArrayList**: Gestión dinámica de colecciones de objetos
- **Auto-registro**: Los objetos se registran automáticamente en listas globales
- **Manejo de excepciones**: Try-catch en el Main

## Cómo Compilar y Ejecutar

### Compilación y Ejecución
```bash
# Navegar al directorio de código
cd src/main/java

# Compilar todas las clases
javac *.java cine/**/*.java

# Ejecutar la aplicación principal
java Main

# Ejecutar las pruebas automatizadas
java TestSistema
```

### Generar Diagramas
```bash
# Navegar al directorio de diagramas
cd docs/diagrams/code

# Ejecutar el script de generación automática
generate.bat
```

## Funcionalidades del Sistema

### 🎯 Menú Principal
1. **Administrar Funciones** - Crear, ver, eliminar funciones
2. **Administrar Reservas y Facturas** - Gestión completa de reservas y facturación
3. **Ver Información del Sistema** - Estado actual de todos los componentes
4. **Ver Estadísticas** - Métricas y totales del sistema

### 🎬 Administración de Funciones
- Crear nuevas funciones seleccionando película, sala y precio
- Ver todas las funciones con información detallada
- Ver butacas disponibles de una función específica
- Eliminar funciones del sistema

### 🎫 Administración de Reservas y Facturas
- **Crear reservas** con selección específica de butacas
- Ver todas las reservas del sistema
- Ver reservas por cliente
- Cancelar reservas existentes
- **Crear facturas** para reservas pendientes
- Confirmar pagos y actualizar estados
- Ver todas las facturas y estadísticas

### 🔍 Características Avanzadas
- **Selección específica de butacas**: El usuario puede elegir exactamente qué butacas reservar
- **Validación de disponibilidad**: El sistema verifica que las butacas estén disponibles
- **Cálculo automático de precios**: Precios totales con impuestos incluidos
- **Estados de transacciones**: Seguimiento completo del estado de reservas y facturas
- **Estadísticas en tiempo real**: Métricas actualizadas del sistema

## Pruebas del Sistema

El archivo `TestSistema.java` incluye pruebas automatizadas que verifican:

✅ **Inicialización de datos** (4 películas, 4 salas, 3 clientes)
✅ **Creación de funciones** con horarios y precios
✅ **Sistema de reservas** con selección específica de butacas
✅ **Facturación completa** con cálculos de impuestos
✅ **Estados de transacciones** y confirmaciones
✅ **Estadísticas finales** y métricas del sistema

### Ejecutar Pruebas
```bash
cd src/main/java
javac TestSistema.java
java TestSistema
```

## Resultados de las Pruebas

El sistema ha sido probado exitosamente y muestra:
- **4 películas** creadas correctamente
- **4 salas** con capacidades variables (50-120 butacas)
- **3 clientes** registrados
- **2 funciones** programadas
- **2 reservas** con butacas específicas seleccionadas
- **1 factura** generada y confirmada con pago
- **Total facturado**: $36.3 (incluyendo impuestos del 21%)

## Diagramas del Sistema

El proyecto incluye diagramas UML generados con PlantUML:
- **Diagrama de Clases** (`Cine.png`): Muestra todas las entidades y sus relaciones
- **Diagrama de Paquetes** (`Packages.png`): Estructura organizacional del código

### Generar Diagramas Automáticamente
```bash
cd docs/diagrams/code
generate.bat
```

## Próximos Pasos de Desarrollo

1. **Persistencia de datos** - Guardar información en archivos o base de datos
2. **Interfaz gráfica** - Implementar GUI con Swing o JavaFX
3. **Validaciones avanzadas** - Mejorar validación de datos de entrada
4. **Reportes** - Generar reportes de ventas y estadísticas
5. **Sistema de usuarios** - Implementar roles y permisos
6. **Reservas online** - Integración con sistema web
7. **Notificaciones** - Sistema de alertas y recordatorios

## Tecnologías Utilizadas

- **Java** - Lenguaje de programación principal
- **PlantUML** - Generación de diagramas UML
- **ArrayList** - Gestión de colecciones dinámicas
- **Scanner** - Entrada de datos por consola
- **Date** - Manejo de fechas y horarios

## Recursos de Aprendizaje

- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
- [PlantUML Documentation](https://plantuml.com/)
- [UML Class Diagrams](https://www.uml-diagrams.org/class-diagrams.html)

---

**Estado del Proyecto**: ✅ **COMPLETADO Y FUNCIONAL**

El sistema de cine está completamente implementado, probado y listo para uso. Todas las funcionalidades principales están operativas y han sido validadas mediante pruebas automatizadas.