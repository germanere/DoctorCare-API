   FROM eclipse-temurin:17-jdk-alpine
   COPY target/duc-0.0.1-SNAPSHOT.jar duc-0.0.1-SNAPSHOT.jar
   ENV spring.datasource.url jdbc:mysql://viaduct.proxy.rlwy.net:13365/railway
   ENV spring.datasource.username root
   ENV spring.datasource.password 2BafGf4-FgGBDBaB5GAF6424hAa4c1bf
   EXPOSE 8080
   ENTRYPOINT ["java","-jar","duc-0.0.1-SNAPSHOT.jar"]
