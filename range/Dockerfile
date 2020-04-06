FROM openjdk:8-jdk-alpine
# Environment Variable that defines the endpoint of sentiment-analysis python api.
#todo
ADD build/range-0.0.1-SNAPSHOT.jar /
EXPOSE 8081
CMD ["java", "-jar", "rest-0.0.1-SNAPSHOT.jar"]
