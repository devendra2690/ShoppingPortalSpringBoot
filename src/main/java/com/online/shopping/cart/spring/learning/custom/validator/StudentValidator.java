package com.online.shopping.cart.spring.learning.custom.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> student) {
		
		return Student.class.isAssignableFrom(student);
	}

	@Override
	public void validate(Object object, Errors errors) {

		Student student = (Student) object;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Name is Empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "Address is Empty");
	
		if(student.getId() == 0) {
			errors.rejectValue("id", "","Id cannot be 0.");
		}
	}

}
