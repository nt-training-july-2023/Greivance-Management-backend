package com.grievance.Grievance.InDto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.grievance.Grievance.Constants.ValidationErrors;
import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.entity.Department;

/**
 * Represents the input data for creating or updating user details.
 */
public class UserDetailsInDto {

  /**
   * The name of the user.
   */
  @NotEmpty(message = ValidationErrors.NAME_ERROR)
  private String name;

  /**
   * The user type (e.g., Admin, Member).
   */
  @Enumerated(EnumType.STRING)
  private UserType userType;

  /**
   * minSize password minimum size.
   */
  private final int minSize = 8;
  /**
   * The user's password.
   */
  @NotEmpty(message = ValidationErrors.PASSWORD_ERROR)
  @Size(min = minSize, message = ValidationErrors.PASSWORD_SIZE_ERROR)
  private String password;

  /**
   * The user's email (user name).
   */
  @NotEmpty(message = ValidationErrors.USER_NAME_ERROR)
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
  private String email;

  /**
   * The department to which the user belongs.
   */
  @NotNull(message = ValidationErrors.DEPARTMENT_ERROR)
  private Department department;

  /**
   * Gets the name of the user.
   *
   * @return The user's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the user.
   *
   * @param name The user's name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the user type.
   *
   * @return The user type (Admin, Member).
   */
  public UserType getUserType() {
    return userType;
  }

  /**
   * Sets the user type.
   *
   * @param userType The user type (Admin, Member).
   */
  public void setUserType(UserType userType) {
    this.userType = userType;
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

  /**
   * Gets the user's email (user name).
   *
   * @return The user's email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the user's email (user name).
   *
   * @param email The user's email.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the department to which the user belongs.
   *
   * @return The user's department.
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * Sets the department to which the user belongs.
   *
   * @param department The user's department.
   */
  public void setDepartment(Department department) {
    this.department = department;
  }
}
