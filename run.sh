#!/bin/bash

# Script para ejecutar la aplicación Universidad API
# Uso: ./run.sh

echo "╔════════════════════════════════════════╗"
echo "║     Universidad API - Startup Script   ║"
echo "╚════════════════════════════════════════╝"
echo ""

# Verificar que Maven está instalado
if ! command -v mvn &> /dev/null && [ ! -f "./mvnw" ]; then
    echo "❌ Error: Maven o mvnw no encontrado"
    exit 1
fi

# Usar mvnw si existe, de lo contrario usar mvn
MAVEN_CMD="./mvnw"
if [ ! -f "./mvnw" ]; then
    MAVEN_CMD="mvn"
fi

echo "ℹ️  Compilando proyecto..."
$MAVEN_CMD clean package -DskipTests -q

if [ $? -eq 0 ]; then
    echo "✅ Compilación exitosa"
    echo ""
    echo "ℹ️  Iniciando aplicación..."
    echo "🌐 URL: http://localhost:8081"
    echo "📡 REST API: http://localhost:8081/students"
    echo "📡 SOAP WSDL: http://localhost:8081/ws/students.wsdl"
    echo ""
    echo "Presiona Ctrl+C para detener la aplicación"
    echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
    echo ""
    
    java -jar target/demo-0.0.1-SNAPSHOT.jar
else
    echo "❌ Error en la compilación"
    exit 1
fi
