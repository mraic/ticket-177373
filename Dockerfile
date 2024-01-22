FROM openjdk:19

EXPOSE 8080

ADD target/aspose-html-test-0.0.1-SNAPSHOT.jar ecs.jar

ENTRYPOINT ["java","-jar","ecs.jar"]