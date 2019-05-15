package com.online.shopping.cart.spring.learning.custom.validator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/studentCustomValidator")
public class StudentController {

	@Autowired
	StudentValidator studentValidator;
	
	@InitBinder
	public void dataBinding(WebDataBinder webDataBinder) {
		
		webDataBinder.addValidators(studentValidator);
	}
	
	@RequestMapping(value="/validator",method=RequestMethod.POST)
	public String getStdRecord(@Valid @ModelAttribute Student student,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "error";
		}
		return "Student Name";
	}
}
