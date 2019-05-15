package com.online.shopping.cart.spring.learning.validationbean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Employee {

	// @NotEmpty(message="id Cannot be empty")
	@Range(min=1,message="ID should be atleast size 1")
	private int id;

	@NotNull(message = "firstName Cannot be empty")
	private String firstName;

	@NotNull(message = "Last Name Cannot be empty")
	private String lastName;

	// @NotEmpty(message="phoneNo Cannot be empty")
	@Range(min=10,max=10,message="Phone Should be 10 digit number") 
	private int phoneNo;

	@NotNull(message = "emailID Cannot be empty")
	@Email(message="Email should be valid")
	private String emailID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", emailID=" + emailID + "]";
	}

}
