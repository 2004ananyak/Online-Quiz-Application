package model;

import java.sql.Timestamp;

public class QuizAttempt {
    private int userId;
    private int quizId;
    private int score;
    private int totalQuestions;
    private Timestamp attemptTime;

    // ✅ Additional field for display purposes
    private String quizTitle;

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Timestamp getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(Timestamp attemptTime) {
        this.attemptTime = attemptTime;
    }

    // ✅ Getter & Setter for quiz title
    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    // ✅ Helper method for formatted timestamp (optional)
    public String getAttemptedAt() {
        return attemptTime != null ? attemptTime.toString() : "N/A";
    }
}
