FROM bellsoft/liberica-openjdk-alpine:21.0.3

WORKDIR /app

COPY mcsv-usuario.jar /app/mcsv-usuario.jar

EXPOSE 8082

#ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT ["java", "-jar", "mcsv-usuario.jar"]