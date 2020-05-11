FROM openjdk:14-alpine
COPY build/libs/eureka*.jar /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]
