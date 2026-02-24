FROM tomcat:9.0
COPY target/sample-webapp.war /usr/local/tomcat/webapps/
EXPOSE 8080
