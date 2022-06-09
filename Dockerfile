FROM adoptopenjdk/openjdk11:alpine-slim
EXPOSE 8080
ADD build/libs/feature-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
