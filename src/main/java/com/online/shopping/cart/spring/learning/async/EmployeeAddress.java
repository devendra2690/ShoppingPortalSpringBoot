package com.online.shopping.cart.spring.learning.async;

public class EmployeeAddress {

	public EmployeeAddress(int empID, String city) {
		super();
		this.empID = empID;
		this.city = city;
	}

	private int empID;
	private String city;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
