FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY ./account/build/libs/* build/lib/

COPY ./account/build/libs/account-0.0.1-SNAPSHOT.jar build/

WORKDIR /app/build
ENTRYPOINT java -jar account-0.0.1-SNAPSHOT.jar