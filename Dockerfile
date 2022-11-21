FROM maven:3.8.2-jdk-8
#FROM gradle:7.5.1-jdk8

WORKDIR /app
COPY . .
RUN mvn -Duser.home=/var/maven clean install
#RUN gradle init

CMD mvn -Duser.home=/var/maven spring-boot:run
#CMD gradle bootRun