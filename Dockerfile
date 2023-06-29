FROM openjdk:11
EXPOSE 8080
ADD target/ha-uploaddocs-backend.jar ha-uploaddocs-backend.jar
ENTRYPOINT["java","-jar","/ha-uploaddocs-backend.jar"]