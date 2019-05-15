package com.online.shopping.cart.spring.learning.async;

import java.util.concurrent.CompletableFuture;

public interface EmployeeService {

	CompletableFuture<EmployeeAddress> getEmployeeAddress() throws InterruptedException;
	CompletableFuture<EmployeeName> getEmployeeName() throws InterruptedException;
	CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException;
}
