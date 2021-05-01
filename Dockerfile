FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
WORKDIR /app
COPY target/location_voiture.jar .
ENTRYPOINT [ "java", "-jar", "location_voiture.jar" ]
