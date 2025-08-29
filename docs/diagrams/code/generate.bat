@echo off
echo ========================================
echo    Generador de Diagramas PlantUML
echo ========================================
echo.

REM Crear directorio de imágenes si no existe
if not exist "..\images" mkdir "..\images"
if not exist "..\images\classes" mkdir "..\images\classes"
if not exist "..\images\sequence" mkdir "..\images\sequence"
if not exist "..\images\usecase" mkdir "..\images\usecase"

echo Generando diagramas de clases...
java -jar plantuml.jar -o "%cd%\..\images\classes" classes\*.puml

echo Generando diagramas de secuencia...
java -jar plantuml.jar -o "%cd%\..\images\sequence" sequence\*.puml

echo Generando diagramas de casos de uso...
java -jar plantuml.jar -o "%cd%\..\images\usecase" usecase\*.puml

echo.
echo ========================================
echo    Generación completada exitosamente
echo ========================================
echo.
echo Las imágenes se han generado en:
echo - docs\diagrams\images\classes\
echo - docs\diagrams\images\sequence\
echo - docs\diagrams\images\usecase\
echo.
pause
