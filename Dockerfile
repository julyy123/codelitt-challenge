FROM openjdk:17-alpine
ADD build/libs/codelitt-challenge-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]