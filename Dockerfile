FROM java:8-jdk-alpine

COPY ./target/Item-Manager-0.0.1.jar /usr/app/

ENTRYPOINT ["java","-jar","usr/app/Item-Manager-0.0.1.jar"]