# Online-Quiz-Application
This is a console-based Online Quiz Application built using Java and MySQL. It allows users to register, log in, take quizzes, receive instant feedback on answers, and track their quiz performance history.
Features
*User Registration & Login (with unique usernames)
*Quiz Dashboard listing all available quizzes
*Interactive quiz-taking with one question at a time
*Instant feedback on each answer (Correct/Incorrect)
*Score tracking after each quiz
*Scoreboard showing past attempts with time and score
*Data persistence using MySQL and JDBC

compile: javac -cp "lib\mysql-connector-j-9.3.0.jar" -d bin src\Main.java src\dao\*.java src\model\*.java src\ui\*.java src\utils\*.java
run:  java -cp "lib\mysql-connector-j-9.3.0.jar;bin" Main
