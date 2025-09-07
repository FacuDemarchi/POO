@echo off
echo ========================================
echo    Generador de Diagramas PlantUML
echo ========================================
echo.

REM Crear directorio de imágenes si no existe
if not exist "..\images" mkdir "..\images"

echo Generando diagramas desde archivos .puml...
java -jar plantuml.jar -o "%cd%\..\images" *.puml

echo.
echo ========================================
echo    Generación completada exitosamente
echo ========================================
echo.
echo Las imágenes se han generado en:
echo - docs\diagrams\images\
echo.
pause
