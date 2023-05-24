FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ADD build/libs/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod","/app.jar"]