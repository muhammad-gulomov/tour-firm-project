FROM openjdk:17
EXPOSE 22740
COPY target/tour-firm-project-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]