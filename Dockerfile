FROM java:8 

# Install maven
RUN apt-get update
RUN apt-get install -y maven

RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]
RUN ["mvn", "package"]

ADD ./target/spring-boot-sandbox-1.0-SNAPSHOT.jar /root/app.jar

EXPOSE 8080

ENV MESSAGE="message from Blue Mix Docker config"
