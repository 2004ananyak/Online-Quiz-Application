package dao;

import model.Question;
import model.Quiz;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO {

    public static List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM quizzes")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");

                Quiz quiz = new Quiz(id, title);
                quiz.setDescription(description);
                quizzes.add(quiz);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching quizzes: " + e.getMessage());
        }
        return quizzes;
    }

    public static List<Question> getQuestionsForQuiz(int quizId) {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM questions WHERE quiz_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, quizId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Question question = new Question();
                    question.setId(rs.getInt("id"));
                    question.setQuizId(rs.getInt("quiz_id"));
                    question.setQuestionText(rs.getString("question_text"));
                    question.setOption_a(rs.getString("option_a"));
                    question.setOption_b(rs.getString("option_b"));
                    question.setOption_c(rs.getString("option_c"));
                    question.setOption_d(rs.getString("option_d"));
                    question.setCorrect_option(rs.getString("correct_option"));
                    questions.add(question);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching questions: " + e.getMessage());
        }
        return questions;
    }
}
