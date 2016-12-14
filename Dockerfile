FROM java:8 

# Install maven
# RUN apt-get install -y maven

# RUN ["mvn", "package"]

ADD spring-boot-sandbox-1.0-SNAPSHOT.jar /root/app.jar

EXPOSE 8080

ENV DEFAULT_MESSAGE="message from Blue Mix Docker config"
ENV MESSAGE = ${MESSAGE:-DEFAULT_MESSAGE}
CMD ["java", "-jar","/root/app.jar"]