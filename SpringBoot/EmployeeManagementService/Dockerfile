FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} springbootboilerplate.jar

ENTRYPOINT ["java","-jar","/springbootboilerplate.jar"]

EXPOSE 7078