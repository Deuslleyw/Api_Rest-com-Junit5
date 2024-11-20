# Etapa de build
FROM maven:3.8.4-openjdk-17-slim AS build
COPY pom.xml /api_rest/
WORKDIR /api_rest
COPY src /api_rest/src
RUN mvn clean install -DskipTests

# Etapa final
FROM amazoncorretto:17-alpine3.16
ENV PORT=8080
ENV TZ=America/Sao_Paulo

COPY --from=build /api_rest/target/*.jar /usr/src/app/api_rest-service.jar

WORKDIR /usr/src/app

ENTRYPOINT java \
           -noverify \
           -Dfile.encoding=UTF-8 \
           -jar \
           /usr/src/app/api_rest-service.jar \
           --server.port=${PORT}

EXPOSE ${PORT}