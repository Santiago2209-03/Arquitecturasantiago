FROM maven:3.10.1-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn -DskipTests package -q

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT}"]
