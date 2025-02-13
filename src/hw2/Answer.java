package hw2;

import java.time.LocalDateTime;

/**
 * Represents an Answer to a Question, including the associated question ID.
 */
class Answer {
  private int id;
  private int questionId;
  private String text;
  private String createdBy;
  private LocalDateTime timestamp;
  
  /**
   * Constructor to create a new Answer.
   */
  public Answer(int id, int questionId, String text, String createdBy) {
      this.id = id;
      this.questionId = questionId;
      this.text = text;
      this.createdBy = createdBy;
      this.timestamp = LocalDateTime.now();
  }
  
  // Getter methods
  public int getId() { return id; }
  public int getQuestionId() { return questionId; }
  public String getText() { return text; }
  public String getCreatedBy() { return createdBy; }
  public LocalDateTime getTimestamp() { return timestamp; }
  
  /**
   * Updates the text of the answer.
   */
  public void setText(String newText) { this.text = newText; }
}
