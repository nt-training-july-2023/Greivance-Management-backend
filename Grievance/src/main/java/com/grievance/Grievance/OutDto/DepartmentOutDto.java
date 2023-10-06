package com.grievance.Grievance.OutDto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Represents the output data for the department.
 */
public class DepartmentOutDto {

  /**
   * Represents the unique identifier for the department.
   */
  private long deptId;
  /**
   * Represents the name of the department.
   */
  private String deptName;
  /**
   * Represents a list of user details associated with this department.
   */
  @JsonManagedReference
  private List<UserDetailsOutDto> userDetails;
  /**
   * Represents a list of tickets associated with this department.
   */
  @JsonManagedReference(value = "dep")
  private List<TicketOutDto> tickets;

  /**
   * Gets the unique identifier for the department.
   *
   * @return The department's unique identifier.
   */
  public long getDeptId() {
    return deptId;
  }

  /**
   * Sets the unique identifier for the department.
   *
   * @param deptId The department's unique identifier.
   */
  public void setDeptId(long deptId) {
    this.deptId = deptId;
  }

  /**
   * Gets the name of the department.
   *
   * @return The department's name.
   */
  public String getDeptName() {
    return deptName;
  }

  /**
   * Sets the name of the department.
   *
   * @param deptName The department's name.
   */
  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  /**
   * Gets the list of user details associated with this department.
   *
   * @return The list of user details.
   */
  public List<UserDetailsOutDto> getUserDetails() {
    return userDetails;
  }

  /**
   * Sets the list of user details associated with this department.
   *
   * @param userDetails The list of user details.
   */
  public void setUserDetails(List<UserDetailsOutDto> userDetails) {
    this.userDetails = userDetails;
  }

  /**
   * Gets the list of tickets associated with this department.
   *
   * @return The list of tickets.
   */
  public List<TicketOutDto> getTickets() {
    return tickets;
  }

  /**
   * Sets the list of tickets associated with this department.
   *
   * @param tickets The list of tickets.
   */
  public void setTickets(List<TicketOutDto> tickets) {
    this.tickets = tickets;
  }

  /**
   * Constructs a new DepartmentOutDto with the specified values.
   *
   * @param deptId      The unique identifier for the department.
   * @param deptName    The name of the department.
   * @param userDetails The list of user details associated with this department.
   * @param tickets     The list of tickets associated with this department.
   */
  public DepartmentOutDto(long deptId, String deptName,
      List<UserDetailsOutDto> userDetails,
      List<TicketOutDto> tickets) {
    super();
    this.deptId = deptId;
    this.deptName = deptName;
    this.userDetails = userDetails;
    this.tickets = tickets;
  }

  /**
   * Constructs a new DepartmentOutDto with default values.
   */
  public DepartmentOutDto() {
    super();
  }

  /**
   * Generates a string representation of the DepartmentOutDto object.
   *
   * @return A string containing the department ID.
   */
  @Override
  public String toString() {
    return "DepartmentOutDto [deptId=" + deptId + "";
  }

}
