FROM maven:3.8.5-openjdk-17

WORKDIR /album
COPY . .
RUN mvn clean install -Dmaven.test.skip=true

CMD mvn spring-boot:run