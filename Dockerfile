   FROM eclipse-temurin:17-jdk-alpine
   COPY target/duc-0.0.1-SNAPSHOT.jar duc-0.0.1-SNAPSHOT.jar
   ENV spring.datasource.url jdbc:mysql://mysql-155597-0.cloudclusters.net:19856/asm03
   ENV spring.datasource.username admin
   ENV spring.datasource.password qiA0vIUC
   EXPOSE 8080
   ENTRYPOINT ["java","-jar","duc-0.0.1-SNAPSHOT.jar"]
