FROM openjdk:11.0.6-jdk
# Environment Variable that defines the endpoint of sentiment-analysis python api.
#todo
ADD build/libs/range-0.0.1-SNAPSHOT.jar /
EXPOSE 8081
CMD ["java", "-jar", "range-0.0.1-SNAPSHOT.jar"]
