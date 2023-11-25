   FROM eclipse-temurin:17-jdk-alpine
   COPY target/duc-0.0.1-SNAPSHOT.jar duc-0.0.1-SNAPSHOT.jar
   ENV spring.datasource.url jdbc:mysql://34.122.244.71:3306/asm03
   ENV spring.datasource.username root
   ENV spring.datasource.password @Ducnt24
   EXPOSE 8080
   ENTRYPOINT ["java","-jar","duc-0.0.1-SNAPSHOT.jar"]
