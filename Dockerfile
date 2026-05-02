FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN javac -d . src/library/*.java

CMD ["java", "library.Main"]