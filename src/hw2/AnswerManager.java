package hw2;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the CRUD operations for Answers.
 */
class AnswerManager {
  private List<Answer> answers = new ArrayList<>();
  private int answerCounter = 1;
  
  /**
   * Creates a new answer to a specific question.
   */

  public Answer createAnswer(int questionId, String text, String createdBy) {
      if (text.isEmpty()) throw new IllegalArgumentException("Answer cannot be empty.");
      Answer a = new Answer(answerCounter++, questionId, text, createdBy);
      answers.add(a);
      return a;
  }
  
  /**
   * Retrieves answers for a specific question.
   */
  public List<Answer> getAnswersForQuestion(int questionId) {
      List<Answer> result = new ArrayList<>();
      for (Answer a : answers) {
          if (a.getQuestionId() == questionId) result.add(a);
      }
      return result;
  }
}

