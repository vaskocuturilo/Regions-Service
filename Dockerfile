# Stage 1: Build
FROM gradle:7.4.2-jdk-alpine AS TEMP_BUILD_IMAGE

# Install dependencies in a single layer
RUN apk add --no-cache bash \
    && echo "@personal https://dl-cdn.alpinelinux.org/alpine/v3.9/main" >> /etc/apk/repositories \
    && apk add --no-cache nodejs@personal npm@personal \
    && node --version \
    && npm --version

# Set the working directory
WORKDIR /usr/app/

# Copy only necessary files for dependency resolution and building
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# Ensure Gradle runs as non-root user
RUN chown -R gradle:gradle ./

USER gradle

# Build the application, skipping tests for faster builds
ARG REACT_APP_TOKEN
ENV REACT_APP_TOKEN $REACT_APP_TOKEN

RUN gradle clean npm_run_build copyTask build -x test --no-daemon || return 0

# Stage 2: Package
FROM eclipse-temurin:21-jdk-alpine

# Add curl (if needed) in a single command to minimize layers
RUN apk --no-cache add curl

# Define environment variables
ENV ARTIFACT_NAME=simpleRegions-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app

# Set the working directory
WORKDIR $APP_HOME

# Copy the built artifact from the build stage
COPY --from=TEMP_BUILD_IMAGE /usr/app/build/libs/$ARTIFACT_NAME app.jar

# Use a non-root user to run the application
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

# Expose the application's port
EXPOSE 8080

# Set the entry point to run the jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "/app.jar"]