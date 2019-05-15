package com.online.shopping.cart.spring.learning.async;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asyncExecutor")
public class AsyncController {

	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/getDetails",method=RequestMethod.GET)
	public Employee getEmployeeDetails() {
		
		Employee employee = new Employee();
		try {
		
			CompletableFuture<EmployeeAddress> employeeAddress = employeeService.getEmployeeAddress();
			CompletableFuture<EmployeeName> employeeName = employeeService.getEmployeeName();
			CompletableFuture<EmployeePhone> employeePhoneNo = employeeService.getEmployeePhone();
			
			CompletableFuture.allOf(employeeAddress,employeeName,employeePhoneNo).join();
			
			System.out.println("EmployeeAddress--> " + employeeAddress.get());
			System.out.println("EmployeeName--> " + employeeName.get());
			System.out.println("EmployeePhone--> " + employeePhoneNo.get());
			employee.setEmployeeAddress(employeeAddress.get());
			employee.setEmployeeName(employeeName.get());
			employee.setEmployeePhone(employeePhoneNo.get());
		}catch (Exception e) {
		}	
		
		return employee;
	}
}
