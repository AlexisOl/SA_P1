FROM bellsoft/liberica-openjdk-alpine:21.0.3

WORKDIR /app

COPY mcsv-eureka.jar /app/mcsv-eureka.jar

EXPOSE 8761

#ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", "-jar", "mcsv-eureka.jar"]