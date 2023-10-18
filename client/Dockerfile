FROM openjdk:17-jdk-slim-buster

CMD [ "./gradlew build" ]

WORKDIR /app

COPY ./build/libs/* build/lib/

COPY ./build/libs/client-0.0.1-SNAPSHOT.jar build/

WORKDIR /app/build
ENTRYPOINT java -jar client-0.0.1-SNAPSHOT.jar
EXPOSE 8080