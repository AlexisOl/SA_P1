FROM bellsoft/liberica-openjdk-alpine:21.0.3

WORKDIR /app

COPY mcsv-gateway.jar /app/mcsv-gateway.jar

EXPOSE 8761

#ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", "-jar", "mcsv-gateway.jar"]