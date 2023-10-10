package com.grievance.Grievance.InDto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.grievance.Grievance.Constants.ValidationErrors;

/**
 * Represents the input data for user login.
 */
public class LoginInDto {

  /**
   * minSize password minimum size.
   */

  private final int minSize = 8;
  /**
   * The user's email address.
   */
  @NotEmpty(message = ValidationErrors.USER_NAME_ERROR)
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
  @Column(unique = true)
  private String email;
  /**
   * The user's password.
   */
  @NotEmpty(message = ValidationErrors.PASSWORD_ERROR)
  @Size(min = minSize, message = ValidationErrors.PASSWORD_SIZE_ERROR)
  private String password;

  /**
   * Gets the user's email address.
   *
   * @return The email address.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the user's email address.
   *
   * @param email The email address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the user's password.
   *
   * @return The user's password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the user's password.
   *
   * @param password The user's password.
   */
  public void setPassword(String password) {
    this.password = password;
  }

}
