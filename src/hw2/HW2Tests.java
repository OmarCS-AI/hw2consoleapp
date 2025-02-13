package hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class HW2Tests {
  private QuestionManager questionManager;
  private AnswerManager answerManager;
  private AuthManager authManager;
  private User studentUser;
  private User anotherUser;

  @BeforeEach
  void setUp() {
      questionManager = new QuestionManager();
      answerManager = new AnswerManager();
      authManager = new AuthManager();
      authManager.registerUser("student1", "password", "student");
      authManager.registerUser("student2", "password", "student");
      studentUser = authManager.authenticate("student1", "password");
      anotherUser = authManager.authenticate("student2", "password");
  }

  @Test
  void testCreateQuestionSuccessfully() {
      Question q = questionManager.createQuestion("What is Java?", studentUser.getUsername());
      assertNotNull(q);
      assertEquals("What is Java?", q.getText());
      assertEquals("student1", q.getCreatedBy());
  }

  @Test
  void testRetrieveQuestions() {
      questionManager.createQuestion("What is Java?", studentUser.getUsername());
      List<Question> questions = questionManager.getQuestions();
      assertEquals(1, questions.size());
  }

  @Test
  void testEditQuestionSuccessfully() {
      Question q = questionManager.createQuestion("What is Java?", studentUser.getUsername());
      assertTrue(questionManager.updateQuestion(q.getId(), "What is Java programming?", studentUser.getUsername()));
  }

  @Test
  void testDeleteQuestionSuccessfully() {
      Question q = questionManager.createQuestion("What is Java?", studentUser.getUsername());
      assertTrue(questionManager.deleteQuestion(q.getId(), studentUser.getUsername()));
  }

  @Test
  void testCreateAnswerSuccessfully() {
      Question q = questionManager.createQuestion("What is Java?", studentUser.getUsername());
      Answer a = answerManager.createAnswer(q.getId(), "Java is a programming language.", studentUser.getUsername());
      assertNotNull(a);
      assertEquals(q.getId(), a.getQuestionId());
  }

  @Test
  void testRetrieveAnswersForQuestion() {
      Question q = questionManager.createQuestion("What is Java?", studentUser.getUsername());
      answerManager.createAnswer(q.getId(), "Java is a language.", studentUser.getUsername());
      List<Answer> answers = answerManager.getAnswersForQuestion(q.getId());
      assertEquals(1, answers.size());
  }

  @Test
  void testSuccessfulLogin() {
      User user = authManager.authenticate("student1", "password");
      assertNotNull(user);
      assertEquals("student1", user.getUsername());
  }

  @Test
  void testFailedLogin() {
      User user = authManager.authenticate("student1", "wrongpassword");
      assertNull(user);
  }

  @Test
  void testCreateQuestionWithEmptyText() {
      Exception exception = assertThrows(IllegalArgumentException.class, () -> {
          questionManager.createQuestion("", studentUser.getUsername());
      });
      assertEquals("Question cannot be empty.", exception.getMessage());
  }

  @Test
  void testEditQuestionWithDifferentUser() {
      Question q = questionManager.createQuestion("What is Java?", studentUser.getUsername());
      assertFalse(questionManager.updateQuestion(q.getId(), "New text", anotherUser.getUsername()));
  }

  @Test
  void testDeleteQuestionWithDifferentUser() {
      Question q = questionManager.createQuestion("What is Java?", studentUser.getUsername());
      assertFalse(questionManager.deleteQuestion(q.getId(), anotherUser.getUsername()));
  }

  @Test
  void testCreateAnswerWithEmptyText() {
      Question q = questionManager.createQuestion("What is Java?", studentUser.getUsername());
      Exception exception = assertThrows(IllegalArgumentException.class, () -> {
          answerManager.createAnswer(q.getId(), "", studentUser.getUsername());
      });
      assertEquals("Answer cannot be empty.", exception.getMessage());
  }
}


