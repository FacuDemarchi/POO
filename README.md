# Proyecto de Programación Orientada a Objetos en Java

Este es un proyecto de aprendizaje de Java con enfoque en Programación Orientada a Objetos (POO).

## Estructura del Proyecto

```
POO/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── ejemplo/
│                   └── poo/
│                       ├── Main.java
│                       └── Persona.java
├── lib/                    # Librerías externas
├── docs/                   # Documentación
└── README.md
```

## Conceptos de POO Incluidos

- **Clases**: Persona, Main
- **Objetos**: Instancias de las clases
- **Encapsulación**: Atributos privados con getters y setters
- **Constructores**: Constructor por defecto y con parámetros
- **Métodos**: saludar(), toString()
- **Paquetes**: com.ejemplo.poo

## Cómo Compilar y Ejecutar

### Opción 1: Usando javac y java
```bash
# Compilar
javac -d . src/main/java/com/ejemplo/poo/*.java

# Ejecutar
java com.ejemplo.poo.Main
```

### Opción 2: Desde el directorio src/main/java
```bash
# Navegar al directorio
cd src/main/java

# Compilar
javac com/ejemplo/poo/*.java

# Ejecutar
java com.ejemplo.poo.Main
```

## Próximos Pasos

1. Aprender sobre herencia
2. Implementar interfaces
3. Trabajar con polimorfismo
4. Manejo de excepciones
5. Colecciones (ArrayList, HashMap, etc.)

## Recursos de Aprendizaje

- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
