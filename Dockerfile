   FROM eclipse-temurin:17-jdk-alpine
   COPY target/*.jar /target/duc-0.0.1-SNAPSHOT.jar
   ENV spring.datasource.url jdbc:mysql://some-mysql:3306/asm03
   ENV spring.datasource.username root
   ENV spring.datasource.password my-secret-pw
   EXPOSE 8080
   ENTRYPOINT ["java","-jar","duc-0.0.1-SNAPSHOT.jar"]
