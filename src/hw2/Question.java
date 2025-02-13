package hw2;

import java.time.LocalDateTime;

/**
 * Represents a Question with an ID, text, creator, and timestamp.
 */
class Question {
  private int id;
  private String text;
  private String createdBy;
  private LocalDateTime timestamp;
  
  /**
   * Constructor to create a new Question.
   */
  public Question(int id, String text, String createdBy) {
      this.id = id;
      this.text = text;
      this.createdBy = createdBy;
      this.timestamp = LocalDateTime.now();
  }
  
  // Getter methods
  public int getId() { return id; }
  public String getText() { return text; }
  public String getCreatedBy() { return createdBy; }
  public LocalDateTime getTimestamp() { return timestamp; }
  
  /**
   * Updates the text of the question.
   */
  public void setText(String newText) { this.text = newText; }
}