# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM openjdk:11.0.11-jre-slim-buster
RUN addgroup -system dezmenevil && adduser -system admin --ingroup dezmenevil
RUN apt-get update && apt-get install -y curl
USER admin:dezmenevil
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java -Duser.timezone=CET $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]