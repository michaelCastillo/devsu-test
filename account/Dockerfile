FROM openjdk:17-jdk-slim-buster

CMD [ "./gradlew build" ]

WORKDIR /app

COPY ./build/libs/* build/lib/

COPY ./build/libs/account-0.0.1-SNAPSHOT.jar build/

WORKDIR /app/build
ENTRYPOINT java -jar account-0.0.1-SNAPSHOT.jar
EXPOSE 8080