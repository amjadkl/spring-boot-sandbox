FROM java:8 

ADD spring-boot-sandbox-1.0-SNAPSHOT.jar /root/app.jar

EXPOSE 8080

#ENV MESSAGE = ${MESSAGE:-Default message from Blue Mix Docker config}

ENV MESSAGE="Default message from Blue Mix Docker config"
CMD java -Dserver.port=$PORT -jar /root/app.jar