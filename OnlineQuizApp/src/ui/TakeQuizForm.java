package ui;

import dao.QuizAttemptDAO;
import dao.QuizDAO;
import model.Question;
import model.QuizAttempt;
import model.User;

import java.util.List;
import java.util.Scanner;

public class TakeQuizForm {
    private Scanner scanner = new Scanner(System.in);
    private int correctAnswers = 0;

    public void startQuiz(int quizId, User currentUser) {
        List<Question> questions = QuizDAO.getQuestionsForQuiz(quizId);

        if (questions.isEmpty()) {
            System.out.println("⚠️ No questions found for this quiz.");
            return;
        }

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestionText());
            System.out.println("A. " + q.getOption_a());
            System.out.println("B. " + q.getOption_b());
            System.out.println("C. " + q.getOption_c());
            System.out.println("D. " + q.getOption_d());

            String selected;
            while (true) {
                System.out.print("Your answer (A/B/C/D): ");
                selected = scanner.nextLine().trim().toUpperCase();
                if (selected.matches("[ABCD]")) break;
                System.out.println("❌ Invalid input. Please enter A, B, C, or D.");
            }

            if (selected.equalsIgnoreCase(q.getCorrect_option())) {
                System.out.println("✅ Correct!");
                correctAnswers++;
            } else {
                System.out.println("❌ Incorrect! Correct answer: " + q.getCorrect_option());
            }
        }

        int totalQuestions = questions.size();
        saveResult(currentUser.getId(), quizId, totalQuestions);
        showResult(totalQuestions, currentUser);
    }

    private void saveResult(int userId, int quizId, int totalQuestions) {
        QuizAttempt attempt = new QuizAttempt();
        attempt.setUserId(userId);
        attempt.setQuizId(quizId);
        attempt.setScore(correctAnswers);
        attempt.setTotalQuestions(totalQuestions);
        QuizAttemptDAO.saveAttempt(attempt);
    }

    private void showResult(int totalQuestions, User currentUser) {
        System.out.println("\n🎉 Quiz Completed!");
        System.out.println("✅ Correct Answers: " + correctAnswers + " out of " + totalQuestions);
        new ScoreBoardForm(currentUser).display();
    }
}
