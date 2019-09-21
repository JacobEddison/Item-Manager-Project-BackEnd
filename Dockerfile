FROM java:8-jdk-alpine

COPY ./target/ItemManager-0.0.1.jar /usr/app/

ENTRYPOINT ["java","-jar","usr/app/ItemManager-0.0.1.jar"]