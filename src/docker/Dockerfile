FROM @base.image@

COPY entrypoint.sh /opt/app/

COPY /target/encryption-service*.jar  /opt/app/app.jar

# Java Options (GC, Memory, ...)
ENV JAVA_OPTS ""

EXPOSE 8080

WORKDIR /opt/app

RUN chmod +x /opt/app/entrypoint.sh

USER docker_ro

ENTRYPOINT ["/opt/app/entrypoint.sh"]
