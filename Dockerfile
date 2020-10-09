FROM openjdk:10
COPY ./target/todo-1.jar .
WORKDIR .
ENTRYPOINT ["java","-jar","todo-1.jar"]
#From java:8-jdk-alpine
