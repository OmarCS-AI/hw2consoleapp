package hw2;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles user authentication and registration.
 */
class AuthManager {
  private Map<String, User> users = new HashMap<>();
  
  /**
   * Registers a new user in the system.
   */
  public void registerUser(String username, String password, String role) {
      users.put(username, new User(users.size() + 1, username, password, role));
  }
  
  /**
   * Authenticates a user based on username and password.
   */
  public User authenticate(String username, String password) {
      User user = users.get(username);
      return (user != null && user.authenticate(password)) ? user : null;
  }
}
