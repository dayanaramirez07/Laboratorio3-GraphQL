FROM maven:3.8.1-openjdk-17 AS build
COPY pom.xml /app/
COPY src /app/src/
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
COPY --from=build /app/target/search-0.0.1-SNAPSHOT.jar /usr/local/lib/search.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/search.jar"]