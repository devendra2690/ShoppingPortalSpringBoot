package com.online.shopping.cart.spring.learning.validationbean;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.cart.spring.learning.modal.attribute.methodlevel.User;

@RestController
@RequestMapping(value="/employeeValidation")
public class EmployeeController {
	
	@RequestMapping(value="/validation",method=RequestMethod.POST)
	public String validateEmployee(@Valid @ModelAttribute Employee employee,BindingResult bindingResult,Model model) {
		
		if(bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getFieldErrors().get(0).getDefaultMessage());
			return "Error";
		}		
		System.out.println(employee);
		return "devendra";
	}
}
