package hw2;

/**
 * Represents a user in the system.
 * Users have an ID, username, password, and role (e.g., student, admin).
 */
class User {
  private int id;
  private String username;
  private String password;
  private String role;
  
  /**
   * Constructor to initialize a User object.
   */
  public User(int id, String username, String password, String role) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.role = role;
  }
  // Getter methods
  public int getId() { return id; }
  public String getUsername() { return username; }
  public String getRole() { return role; }
  
  /**
   * Authenticates the user by checking the password.
   */
  public boolean authenticate(String password) { return this.password.equals(password); }
}

