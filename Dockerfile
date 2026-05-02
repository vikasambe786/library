FROM openjdk:17

WORKDIR /app

COPY . .

RUN javac -d . src/library/*.java

CMD ["java", "library.Main"]