FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -q

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
COPY nasa_apod_home ./nasa_apod_home
COPY nasa_apod_gallery_redesign ./nasa_apod_gallery_redesign
COPY nasa_apod_about ./nasa_apod_about
COPY nasa_apod_community ./nasa_apod_community
COPY nasa_apod_api_developers ./nasa_apod_api_developers
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
