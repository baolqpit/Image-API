# Sử dụng image Maven với OpenJDK 17
FROM maven:3.8.5-openjdk-17 AS build

# Sao chép mã nguồn vào container
COPY . .

# Chạy lệnh build, bỏ qua bước test
RUN mvn clean package -DskipTests

# Sử dụng image OpenJDK 17 slim cho phần runtime
FROM openjdk:17-jdk-slim

# Sao chép file .jar từ build stage vào container
COPY --from=build /target/image-thumbnail-0.0.1-SNAPSHOT.jar image-thumbnail.jar

# Mở cổng 8080 để ứng dụng có thể được truy cập
EXPOSE 8080

# Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "image-thumbnail.jar"]
