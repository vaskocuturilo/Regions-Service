FROM gradle:7.4.2-jdk-alpine AS TEMP_BUILD_IMAGE

RUN apk add --no-cache bash
RUN echo "@personal http://dl-cdn.alpinelinux.org/alpine/v3.15/main" >> /etc/apk/repositories
RUN apk add nodejs@personal npm@personal
RUN node --version
RUN npm --version

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

COPY gradle $APP_HOME/gradle/
COPY --chown=gradle:gradle . /home/gradle/src

COPY . .

ARG REACT_APP_TOKEN
ENV REACT_APP_TOKEN $REACT_APP_TOKEN

RUN gradle clean npm_run_build copyTask build -x test --no-daemon || return 0

FROM eclipse-temurin:17-jdk-alpine
RUN apk --no-cache add curl

ENV ARTIFACT_NAME=simpleRegions-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app

COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker", "/app.jar"]