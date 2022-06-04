FROM ibmjava:11-jdk
LABEL org.opencontainers.image.authors="yvanj@cyber.gent"

# build application
COPY . /src
RUN cd /src && chmod +x ./mvnw && ./mvnw compile

# entrypoint
CMD cd /src && ./mvnw jetty:run 
EXPOSE 8080/tcp
