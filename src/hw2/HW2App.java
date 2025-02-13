package hw2;

import java.util.Scanner;
import java.util.List;

/**
 * Main application class that handles user interaction via console.
 */
public class HW2App {
    private static Scanner scanner = new Scanner(System.in);
    private static QuestionManager questionManager = new QuestionManager();
    private static AnswerManager answerManager = new AnswerManager();
    private static AuthManager authManager = new AuthManager();
    private static User loggedInUser;

    public static void main(String[] args) {
        // Register a sample user
        authManager.registerUser("student1", "password", "student");
        authManager.registerUser("admin", "adminpass", "admin");
        
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();
            
            loggedInUser = authManager.authenticate(username, password);
            if (loggedInUser != null) {
                System.out.println("Login successful!");
                menu();
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
    }

    /**
     * Displays menu options for logged-in users.
     */
    private static void menu() {
        while (true) {
            System.out.println("1. Create Question\n2. View Questions\n3. Edit Question\n4. Delete Question\n5. Answer Question\n6. View Answers\n7. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    createQuestion();
                    break;
                case 2:
                    viewQuestions();
                    break;
                case 3:
                    editQuestion();
                    break;
                case 4:
                    deleteQuestion();
                    break;
                case 5:
                    answerQuestion();
                    break;
                case 6:
                    viewAnswers();
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * Allows user to create a new question.
     */
    private static void createQuestion() {
        System.out.print("Enter question text: ");
        String text = scanner.nextLine();
        questionManager.createQuestion(text, loggedInUser.getUsername());
        System.out.println("Question created.");
    }

    /**
     * Displays all questions.
     */
    private static void viewQuestions() {
        List<Question> questions = questionManager.getQuestions();
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
        } else {
            for (Question q : questions) {
                System.out.println(q.getId() + ". " + q.getText() + " (by " + q.getCreatedBy() + ")");
            }
        }
    }

    /**
     * Allows user to edit their own question.
     */
    private static void editQuestion() {
        System.out.print("Enter question ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new question text: ");
        String newText = scanner.nextLine();
        boolean success = questionManager.updateQuestion(id, newText, loggedInUser.getUsername());
        if (success) {
            System.out.println("Question updated successfully.");
        } else {
            System.out.println("Failed to update question. Ensure you are the author.");
        }
    }

    /**
     * Allows user to delete their own question.
     */
    private static void deleteQuestion() {
        System.out.print("Enter question ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean success = questionManager.deleteQuestion(id, loggedInUser.getUsername());
        if (success) {
            System.out.println("Question deleted successfully.");
        } else {
            System.out.println("Failed to delete question. Ensure you are the author.");
        }
    }

    /**
     * Allows user to submit an answer to a question.
     */
    private static void answerQuestion() {
        System.out.print("Enter question ID to answer: ");
        int questionId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your answer: ");
        String text = scanner.nextLine();
        answerManager.createAnswer(questionId, text, loggedInUser.getUsername());
        System.out.println("Answer submitted.");
    }

    /**
     * Displays all answers for a given question.
     */
    private static void viewAnswers() {
        System.out.print("Enter question ID to view answers: ");
        int questionId = scanner.nextInt();
        scanner.nextLine();
        List<Answer> answers = answerManager.getAnswersForQuestion(questionId);
        if (answers.isEmpty()) {
            System.out.println("No answers available for this question.");
        } else {
            for (Answer a : answers) {
                System.out.println(a.getId() + ". " + a.getText() + " (by " + a.getCreatedBy() + ")");
            }
        }
    }
}
