#!/usr/bin/env bash
set -e

java -Djavax.net.ssl.trustStore=truststore.jks -Djavax.net.ssl.truststoretype=JKS -Djavax.net.ssl.trustStorePassword=changeit -Dserver.port=8080 ${JAVA_OPTS} -jar ccp-app.jar

#exec "$@"

