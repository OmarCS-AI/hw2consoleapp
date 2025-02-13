package hw2;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the CRUD operations for Questions.
 */
class QuestionManager {
  private List<Question> questions = new ArrayList<>();
  private int questionCounter = 1;
  
  /**
   * Creates a new question.
   */
  public Question createQuestion(String text, String createdBy) {
      if (text.isEmpty()) throw new IllegalArgumentException("Question cannot be empty.");
      Question q = new Question(questionCounter++, text, createdBy);
      questions.add(q);
      return q;
  }
  
  /**
   * Retrieves all questions.
   */
  public List<Question> getQuestions() { return questions; }
  
  /**
   * Updates a question's text if the user is the original author.
   */
  public boolean updateQuestion(int id, String newText, String user) {
      for (Question q : questions) {
          if (q.getId() == id && q.getCreatedBy().equals(user)) {
              q.setText(newText);
              return true;
          }
      }
      return false;
  }
  
  /**
   * Deletes a question if the user is the original author.
   */
  public boolean deleteQuestion(int id, String user) {
      return questions.removeIf(q -> q.getId() == id && q.getCreatedBy().equals(user));
  }
}