FROM amazoncorretto:11.0.19
VOLUME /tmp
ADD target/*.jar ha-uploaddocs-backend.jar
ENTRYPOINT ["java","-jar","/ha-uploaddocs-backend.jar"]
