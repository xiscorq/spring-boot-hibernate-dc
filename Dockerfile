FROM maven:3.8.2-jdk-8

WORKDIR /app
COPY . .
RUN mvn -Duser.home=/var/maven clean install

CMD java -jar target/spring-boot-hibernate-dc-0.0.1-SNAPSHOT.jar