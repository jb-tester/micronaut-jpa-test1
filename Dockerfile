FROM openjdk:14-alpine
COPY target/micronaut-jpa-test1-*.jar micronaut-jpa-test1.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronaut-jpa-test1.jar"]