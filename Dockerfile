FROM openjdk:8-jdk-alpine as builder

WORKDIR /app
COPY . /app

RUN ./gradlew --no-daemon stage

FROM openjdk:8-jre-alpine

COPY --from=builder /app/build/libs/hello-kotlin-ktor.jar /hello-kotlin-ktor.jar

ENV PORT 8080

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/hello-kotlin-ktor.jar"]
