package ui;

import dao.QuizAttemptDAO;
import model.QuizAttempt;
import model.User;

import java.util.List;

public class ScoreBoardForm {
    private User currentUser;

    public ScoreBoardForm(User currentUser) {
        this.currentUser = currentUser;
    }

    public void display() {
        System.out.println("\n===== 📊 Your Quiz Attempts =====");

        List<QuizAttempt> attempts = QuizAttemptDAO.getAttemptsByUser(currentUser.getId());

        if (attempts.isEmpty()) {
            System.out.println("❌ No quiz attempts found.");
            return;
        }

        for (QuizAttempt attempt : attempts) {
            System.out.println("📝 Quiz: " + attempt.getQuizTitle());
            System.out.println("   ✅ Score: " + attempt.getScore() + "/" + attempt.getTotalQuestions());
            System.out.println("   🕒 Attempted on: " + attempt.getAttemptedAt());
            System.out.println("-------------------------------------");
        }
    }
}
