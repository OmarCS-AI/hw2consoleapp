package hw2;

import java.util.Scanner;

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
      authManager.registerUser("student1", "password", "student");
      
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
          System.out.println("1. Create Question\n2. View Questions\n3. Exit");
          int choice = scanner.nextInt();
          scanner.nextLine();
          
          switch (choice) {
              case 1:
                  System.out.print("Enter question text: ");
                  String text = scanner.nextLine();
                  questionManager.createQuestion(text, loggedInUser.getUsername());
                  System.out.println("Question created.");
                  break;
              case 2:
                  for (Question q : questionManager.getQuestions()) {
                      System.out.println(q.getId() + ". " + q.getText() + " (by " + q.getCreatedBy() + ")");
                  }
                  break;
              case 3:
                  return;
              default:
                  System.out.println("Invalid choice.");
          }
      }
  }
}
