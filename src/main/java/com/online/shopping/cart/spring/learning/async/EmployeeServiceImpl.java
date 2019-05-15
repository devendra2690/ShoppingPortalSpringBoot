package com.online.shopping.cart.spring.learning.async;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Async("asyncExecutor")
	@Override
	public CompletableFuture<EmployeeAddress> getEmployeeAddress() throws InterruptedException {
		
		EmployeeAddress employeeAddress = new EmployeeAddress(11069,"Cincinnati");
		
		Thread.sleep(5000L);
		
		return CompletableFuture.completedFuture(employeeAddress);
	}

	@Async("asyncExecutor")
	@Override
	public CompletableFuture<EmployeeName> getEmployeeName() throws InterruptedException {

		EmployeeName employeeName = new EmployeeName(11069,"Devendra");
		
		Thread.sleep(5000L);
		
		return CompletableFuture.completedFuture(employeeName);
	}

	@Async("asyncExecutor")
	@Override
	public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException {

		EmployeePhone employeePhone = new EmployeePhone(11069,"5133021677");

		Thread.sleep(5000L);

		return CompletableFuture.completedFuture(employeePhone);
	}

}
