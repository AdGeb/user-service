# Use a lightweight Java runtime (Java 25 for your project)
FROM eclipse-temurin:25-jre-alpine

# Set working directory inside the container
WORKDIR /app

# Copy your built JAR file into the container
COPY build/libs/user-service.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]

