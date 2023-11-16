   FROM openjdk:17
   COPY target/*.jar duc-0.0.1-SNAPSHOT.jar
   EXPOSE 8080
   ENTRYPOINT ["java","-jar","duc-0.0.1-SNAPSHOT.jar"]
