package com.online.shopping.cart.spring.learning.async;

public class EmployeePhone {
	
	
	public EmployeePhone(int empID, String phoneNo) {
		super();
		this.empID = empID;
		this.phoneNo = phoneNo;
	}

	private int empID;
	private String phoneNo;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
