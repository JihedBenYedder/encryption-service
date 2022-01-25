FROM openjdk:11-jdk-slim

COPY entrypoint.sh /opt/app/

COPY /target/encryption*.jar  /opt/app/app.jar

# Java Options (GC, Memory, ...)
ENV JAVA_OPTS ""

EXPOSE 8080

WORKDIR /opt/app

RUN chmod +x /opt/app/entrypoint.sh

ENTRYPOINT ["sh","entrypoint.sh"]
