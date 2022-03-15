FROM openjdk:8
EXPOSE 8080
ADD target/wcs-1.0.0.jar wcs-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/wcs-1.0.0.jar"]
