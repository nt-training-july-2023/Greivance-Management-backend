package com.grievance.Grievance.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grievance.Grievance.Enum.UserType;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long userId;

	@NotEmpty(message = "name is required")
	private String name;

	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$")
	@NotEmpty(message = "Email is required")
	private String email;

	@NotEmpty(message = "Password is required")
	@Size(min = 8, message = "Password should be at least 8 characters")
	private String password;

	@Enumerated(EnumType.STRING)
	private UserType usertype;

	private Boolean isLoggedIn;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "deptId")
	private Department department;

	@JsonManagedReference(value = "user")
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Ticket> tickets;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUsertype() {
		return usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public UserDetails(long userId, @NotEmpty(message = "name is required") String name,
			@Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq.com+$") @NotEmpty(message = "Email is required") String email,
			@NotEmpty(message = "Password is required") String password, UserType usertype, Boolean isLoggedIn,
			Department department, List<Ticket> tickets) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.usertype = usertype;
		this.isLoggedIn = isLoggedIn;
		this.department = department;
		this.tickets = tickets;
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
