# ---------- Build Stage ----------
FROM maven:3.8.4-openjdk-17 AS build

# Set working directory
WORKDIR /app

# Copy only the pom.xml first to leverage Docker cache
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the rest of the project files (source code)
COPY src ./src

# Build the application and skip tests
RUN mvn clean package -DskipTests

# ---------- Runtime Stage ----------
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/demomyapp-0.0.1-SNAPSHOT.jar .

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/demomyapp-0.0.1-SNAPSHOT.jar"]
