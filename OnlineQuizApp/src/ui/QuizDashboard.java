package ui;

import dao.QuizDAO;
import model.Quiz;
import model.User;

import java.util.List;
import java.util.Scanner;

public class QuizDashboard {
    private Scanner scanner = new Scanner(System.in);
    private User currentUser;

    public QuizDashboard(User currentUser) {
        this.currentUser = currentUser;
    }

    public void display() {
        QuizDAO dao = new QuizDAO();
        List<Quiz> quizzes = dao.getAllQuizzes();

        if (quizzes.isEmpty()) {
            System.out.println("⚠️ No quizzes available.");
            return;
        }

        System.out.println("\n===== Available Quizzes =====");
        for (int i = 0; i < quizzes.size(); i++) {
            System.out.println((i + 1) + ". " + quizzes.get(i).getTitle());
        }

        System.out.print("Select a quiz (1-" + quizzes.size() + "): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice >= 1 && choice <= quizzes.size()) {
                int quizId = quizzes.get(choice - 1).getId();
                new TakeQuizForm().startQuiz(quizId, currentUser);
            } else {
                System.out.println("❌ Invalid selection.");
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Please enter a valid number.");
        }
    }
}
