FROM openjdk:18.0.1
EXPOSE 8080
#ADD target/spring-user-docker.jar spring-user-docker.jar

# The application's jar file
ARG JAR_FILE=target/spring-user-docker.jar

# Add the application's jar to the container
ADD ${JAR_FILE} spring-user-docker.jar

ENTRYPOINT ["java", "-jar", "/spring-user-docker"]