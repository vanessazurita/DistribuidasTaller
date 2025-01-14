# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Definir el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/cursos-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto donde la aplicación escucha
EXPOSE 8002

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]