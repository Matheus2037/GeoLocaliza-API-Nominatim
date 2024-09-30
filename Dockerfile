FROM ubuntu:latest
LABEL authors="Matheus"

ENTRYPOINT ["top", "-b"]

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
