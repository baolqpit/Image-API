FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép toàn bộ thư mục target vào container
COPY target/ /app/

# Expose cổng mà ứng dụng sẽ chạy trên (mặc định 8080)
EXPOSE 8080

# Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "image-thumbnail.jar"]
