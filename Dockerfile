FROM amazoncorretto:11.0.19
VOLUME /tmp
COPY /target/ha-uploaddocs-backend.jar ha-uploaddocs-backend.jar
ENTRYPOINT ["java","-jar","/ha-uploaddocs-backend.jar"]
