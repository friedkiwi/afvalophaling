FROM tomcat:9

# build application
COPY . /src
RUN cd /src && chmod +x ./mvnw && ./mvnw war:war

# install application
RUN cp /src/target/*.war /usr/local/tomcat/webapps/ROOT.war

# cleanup
RUN rm -Rf /src