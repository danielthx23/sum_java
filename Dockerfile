FROM amazoncorretto:21-alpine

RUN apk add --no-cache maven

RUN mkdir -p /opt/app
WORKDIR /opt/app

COPY pom.xml /opt/app/
RUN mvn install

COPY src /opt/app/src
RUN mvn package

EXPOSE 8080

CMD ["mvn", "exec:java"]
