package ui;

import dao.UserDAO;
import model.User;

import java.util.Scanner;

public class LoginForm {
    private Scanner scanner = new Scanner(System.in);
    private UserDAO dao = new UserDAO();

    public void display() {
        while (true) {
            System.out.println("\n===== Welcome to the Quiz App =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> {
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        User loggedInUser = dao.loginUser(username, password);
        if (loggedInUser != null) {
            System.out.println(" Login successful!");
            new QuizDashboard(loggedInUser).display();  // ✅ Pass the user object
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void register() {
        System.out.print("Choose username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Choose password: ");
        String password = scanner.nextLine().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        User user = new User(username, password);
        if (dao.registerUser(user)) {
            System.out.println("Registered successfully! You can now login.");
        } else {
            System.out.println(" Registration failed. Username may already exist.");
        }
    }

    public static void main(String[] args) {
        new LoginForm().display();
    }
}
