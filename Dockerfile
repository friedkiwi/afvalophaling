FROM ibmjava:11-jdk

# build application
COPY . /src
RUN cd /src && chmod +x ./mvnw && ./mvnw compile

CMD cd /src && ./mvnw jetty:run 
