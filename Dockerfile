FROM eclipse-temurin:21-jdk

WORKDIR /ads

COPY target/*.jar ads-dental-surgeries-1.0.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","ads-dental-surgeries-1.0.jar"]