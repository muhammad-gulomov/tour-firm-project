FROM openjdk:17
EXPOSE 22740
COPY app.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
