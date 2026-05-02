FROM openjdk:17

WORKDIR /app

COPY . .

RUN javac -d . src/com/bank/*.java

CMD ["java", "library.Main"]