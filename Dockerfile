FROM gradle:7.4.2-jdk-alpine AS TEMP_BUILD_IMAGE

# Install dependencies
RUN apk add --no-cache bash \
    && echo "@personal https://dl-cdn.alpinelinux.org/alpine/v3.15/main" >> /etc/apk/repositories \
    && apk add --no-cache nodejs@personal npm@personal \
    && node --version \
    && npm --version

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

COPY gradle $APP_HOME/gradle/
COPY --chown=gradle:gradle . /home/gradle/src

COPY . .
RUN gradle clean npm_run_build copyTask build -x test --no-daemon || return 0

FROM eclipse-temurin:17-jdk-alpine
RUN apk --no-cache add curl

ENV ARTIFACT_NAME=simpleRegions-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app

COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker", "/app.jar"]