FROM amazoncorretto:17-al2-jdk

WORKDIR /app
CMD ["./gradlew", "clean", "bootJar"]

COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]