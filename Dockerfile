# Sử dụng image chứa JDK 17 chính thức
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file .jar vào container
COPY target/image-thumbnail.jar /app/image-thumbnail.jar

# Expose cổng mà Spring Boot sẽ chạy (mặc định là 8080)
EXPOSE 8080

# Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "image-thumbnail.jar"]
