FROM bellsoft/liberica-openjdk-alpine:21.0.3

WORKDIR /app

COPY mcsv-facturacion.jar /app/mcsv-facturacion.jar

EXPOSE 8083

#ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", "-jar", "mcsv-facturacion.jar"]