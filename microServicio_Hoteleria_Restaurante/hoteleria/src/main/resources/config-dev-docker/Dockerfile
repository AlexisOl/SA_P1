FROM bellsoft/liberica-openjdk-alpine:21.0.3

WORKDIR /app

COPY mcsv-hoteleria.jar /app/mcsv-hoteleria.jar

EXPOSE 8081

#ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "mcsv-hoteleria.jar", "--spring.config.name=application-dev"]