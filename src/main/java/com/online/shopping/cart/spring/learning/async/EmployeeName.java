package com.online.shopping.cart.spring.learning.async;

public class EmployeeName {

	
	
	public EmployeeName(int empID, String empName) {
		super();
		this.empID = empID;
		this.empName = empName;
	}

	private int empID;
	private String empName;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
