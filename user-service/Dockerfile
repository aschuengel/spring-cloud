FROM openjdk:14-alpine
COPY build/libs/user-service*.jar /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]
#CMD echo $EUREKA_CLIENT_SERVICE_URL_DEFAULT_ZONE