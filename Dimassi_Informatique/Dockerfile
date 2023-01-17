# 1er etape
FROM maven:3-openjdk-17-slim AS build
WORKDIR /app
COPY ./ /app
RUN mvn clean install -DskipTests
# 2ème étape
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/*.jar DimassiInformatique.jar
ENV PORT 8081
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","DimassiInformatique.jar"]