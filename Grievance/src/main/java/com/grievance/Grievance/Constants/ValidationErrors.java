package com.grievance.Grievance.Constants;

/**
 * This class defines constants for validation error messages.
 */
public class ValidationErrors {

  /**
   * The constructor is marked private to prevent instantiation of this class. All
   * members and methods are static, so no instances of this class are needed.
   */
  public ValidationErrors() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Error message for a required name field.
   */
  public static final  String NAME_ERROR = "Name is required ";

  /**
   * Error message for a required password field.
   */
  public static final String PASSWORD_ERROR = "Password is required";

  /**
   * Error message for a password that should be at least 8 characters long.
   */
  public static final String PASSWORD_SIZE_ERROR = "Password should be at least 8 characters";

  /**
   * Error message for invalid credentials.
   */
  public static final String INVALID_CREDENTIALS = "Invalid Credentials";

  /**
   * Error message for a required email (username) field.
   */
  public static final String USER_NAME_ERROR = "Email (Username) is required";
  /**
   * Error message for a user not found with a specific email.
   */
  public static final String USER_NOT_FOUND_ERROR = "User not found with email :";

  /**
   * Error message for an empty department name.
   */

  public static final String DEPARTMENT_ERROR = "Department name can not be Empty";
  /**
   * Error message for a department that already exists.
   */
  public static final String DEPARTMENT_UNIQUE_ERROR = "Department already Exist";
  /**
   * Error message for a required ticket title.
   */
  public static final String TICKET_TITLE_ERROR = "Title is required";
  /**
   * Error message for a required ticket description.
   */
  public static final String TICKET_DESCRIPTION_ERROR = "Must add description";
  /**
   * Error message for a required comment content.
   */
  public static final String COMMENT_CONTENT_ERROR = "Must add content";
  /**
   * Error message for a department not found with a specific ID.
   */
  public static final String DEPARTMENT_NOT_FOUND_ERROR = "Department not found with given Id";
  /**
   * Error message for a ticket not found with a specific ID.
   */
  public static final String TICKET_NOT_FOUND_ERROR = "Ticket with given Id not found";
  /**
   * Error message for a duplicate email.
   */
  public static final String DUPALICATE_EMAIL_ERROR = "Email already Exist";

}
