# Plantilla de Diagramas PlantUML

Esta es una plantilla base para generar diagramas UML usando PlantUML en proyectos Java.

## Estructura de Archivos

```
docs/diagrams/
├── code/                           # Código fuente PlantUML (.puml)
│   ├── classes/                    # Diagramas de clases
│   │   ├── 01-diagrama-principal.puml
│   │   ├── 02-diagrama-modelo.puml
│   │   └── 03-diagrama-servicios.puml
│   ├── sequence/                   # Diagramas de secuencia
│   │   ├── 01-flujo-principal.puml
│   │   └── 02-flujos-secundarios.puml
│   ├── usecase/                    # Diagramas de casos de uso
│   │   ├── 01-casos-uso-principales.puml
│   │   └── 02-casos-uso-secundarios.puml
│   ├── plantuml.jar               # Ejecutable PlantUML
│   └── generate.bat               # Script para generar imágenes
└── images/                        # Imágenes generadas (se crea automáticamente)
    ├── classes/
    ├── sequence/
    └── usecase/
```

## Cómo Usar

### 1. Generar Imágenes
Ejecuta el script `generate.bat` desde la carpeta `code/`:
```bash
cd docs/diagrams/code
generate.bat
```

### 2. Personalizar Diagramas
Edita los archivos `.puml` según tu proyecto:

- **Diagramas de Clases**: Modifica las clases, atributos y métodos
- **Diagramas de Secuencia**: Ajusta los flujos de interacción
- **Diagramas de Casos de Uso**: Actualiza los actores y casos de uso

### 3. Agregar Nuevos Diagramas
1. Crea un nuevo archivo `.puml` en la carpeta correspondiente
2. Sigue la numeración existente (ej: `04-nuevo-diagrama.puml`)
3. Ejecuta `generate.bat` para generar la imagen

## Tipos de Diagramas

### Diagramas de Clases
- **01-diagrama-principal.puml**: Vista general del sistema
- **02-diagrama-modelo.puml**: Entidades y modelos de datos
- **03-diagrama-servicios.puml**: Servicios, controladores y utilidades

### Diagramas de Secuencia
- **01-flujo-principal.puml**: Flujo principal de la aplicación
- **02-flujos-secundarios.puml**: Flujos alternativos y opcionales

### Diagramas de Casos de Uso
- **01-casos-uso-principales.puml**: Funcionalidades principales
- **02-casos-uso-secundarios.puml**: Funcionalidades adicionales

## Requisitos

- Java instalado en el sistema
- Archivo `plantuml.jar` (incluido en la plantilla)

## Personalización

### Para un Nuevo Proyecto:
1. Copia toda la carpeta `docs/diagrams/` a tu nuevo proyecto
2. Modifica los archivos `.puml` con las clases y flujos de tu proyecto
3. Actualiza los nombres de paquetes y clases
4. Ejecuta `generate.bat` para generar las imágenes

### Agregar Nuevos Tipos de Diagramas:
1. Crea una nueva carpeta en `code/` (ej: `activity/`)
2. Agrega la carpeta correspondiente en `images/`
3. Modifica `generate.bat` para incluir el nuevo tipo

## Notas

- Los archivos `.puml` son versionables (incluirlos en Git)
- Las imágenes generadas se pueden excluir del control de versiones
- La plantilla incluye ejemplos basados en una clase `Persona` básica
- Todos los diagramas usan el tema `plain` para consistencia visual

## ⚠️ Importante para Nuevos Proyectos

**Si descargas esta plantilla desde GitHub para un nuevo proyecto:**

Puedes eliminar todos los archivos `.puml` de ejemplo de las carpetas:
- `classes/` - Elimina los 3 archivos de ejemplo
- `sequence/` - Elimina los 2 archivos de ejemplo  
- `usecase/` - Elimina los 2 archivos de ejemplo

Estos archivos son solo ejemplos para mostrar la estructura. Una vez que entiendas el formato, puedes borrarlos y crear tus propios diagramas desde cero.

**Comando para limpiar archivos de ejemplo:**
```bash
cd docs/diagrams/code
del classes\*.puml
del sequence\*.puml
del usecase\*.puml
```
