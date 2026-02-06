# 1단계: 빌드 스테이지
# 젠킨스 에이전트 환경과 맞추기 위해 Gradle 8.5/JDK 17 사용
FROM gradle:9.3-jdk17 AS build
WORKDIR /home/gradle/project

# Gradle 설정 파일만 먼저 복사 (의존성 캐싱으로 빌드 속도 향상)
COPY build.gradle settings.gradle ./
RUN gradle build --no-daemon > /dev/null 2>&1 || true

# 전체 소스 복사 및 실제 빌드
COPY . .
RUN gradle build --no-daemon -x test

# 2단계: 실행 스테이지 (최종 이미지 용량 최소화)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# 빌드 스테이지에서 생성된 jar 파일만 추출
# 젠킨스 파이프라인에서 버전 관리가 용이하도록 이름을 app.jar로 고정
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

EXPOSE 8080

# 컨테이너 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]