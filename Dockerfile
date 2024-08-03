FROM maven:3.8-openjdk-18

WORKDIR /app

COPY pom.xml .

COPY src ./src


EXPOSE 3000

RUN mvn clean package

RUN mv target/*.jar target/core.jar

ENTRYPOINT ["java", "-jar", "target/core.jar"]