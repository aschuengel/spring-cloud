FROM openjdk:14-alpine
COPY build/libs/app-service*.jar /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]