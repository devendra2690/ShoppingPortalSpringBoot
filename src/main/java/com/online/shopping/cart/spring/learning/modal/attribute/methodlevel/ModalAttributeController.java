package com.online.shopping.cart.spring.learning.modal.attribute.methodlevel;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modalAttribute")
public class ModalAttributeController {

	/**
	 * This method will run always prior to all request mapping method
	 * in controller.
	 * So what this does is to add model attribute defined in below method
	 * to model of all request mapping  method.  
	 *  
	 * @param model
	 */
	@ModelAttribute
	public void addAttribute(Model model) {
		
		model.addAttribute("msg", "Welcome to Spring Learning");
	}
	
	
	@RequestMapping(value="/url1",method=RequestMethod.GET)
	public String url1(Model model) {
		
		// Output will be {"msg", "Welcome to Spring Learning"}. This added by addAttribute()
		System.out.println(model.asMap());
		
		return "url1"+" "+model.asMap();
	}
	
	
	/**
	 * 
	 * In this request ModelAttribute will bind all form data sent from UI
	 * to User class bean 
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/formMapping",method=RequestMethod.POST)
	public String formMapping(@ModelAttribute User user) {
		
		return user.getId()+" = "+user.getName();
	}
}
