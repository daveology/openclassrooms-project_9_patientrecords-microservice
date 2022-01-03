FROM openjdk:8-jdk-alpine

COPY build/libs/openclassrooms_9th-project_patient-microservice-0.1.0-SNAPSHOT.jar /Patient.jar

CMD ["java", "-jar", "/Patient.jar"]
