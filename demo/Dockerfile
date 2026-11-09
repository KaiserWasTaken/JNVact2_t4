# Etapa 1: Compilacion (Build)
FROM maven:3.9-eclipse-temurin-25 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Entorno de ejecucion ligero (Runtime)
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 9526
ENTRYPOINT ["java", "-jar", "app.jar"]