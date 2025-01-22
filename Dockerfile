#FROM openjdk:17-jdk-slim
#
## Đặt thư mục làm việc trong container
#WORKDIR /app
#
## Sao chép toàn bộ thư mục target vào container
#COPY target/ /app/
#
## Expose cổng mà ứng dụng sẽ chạy trên (mặc định 8080)
#EXPOSE 8080
#
## Chạy ứng dụng Spring Boot
#ENTRYPOINT ["java", "-jar", "image-thumbnail.jar"]
FROM maven:3.8.5-openjdk17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/image-thumbnail-0.0.1-SNAPSHOT.jar image-thumbnail.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "image-thumbnail.jar"]