FROM @base.image@

COPY entrypoint.sh /opt/app/

COPY encryption-service-@project.version@.jar /opt/app/ccp-app.jar

# Java Options (GC, Memory, ...)
ENV JAVA_OPTS ""

EXPOSE 8080

WORKDIR /opt/app

RUN chmod +x /opt/app/entrypoint.sh

USER docker_ro

ENTRYPOINT ["/opt/app/entrypoint.sh"]
