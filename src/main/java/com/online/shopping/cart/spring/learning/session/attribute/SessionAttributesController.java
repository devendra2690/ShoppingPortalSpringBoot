package com.online.shopping.cart.spring.learning.session.attribute;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.online.shopping.cart.spring.learning.modal.attribute.methodlevel.User;

@RestController
@SessionAttributes("user")
@RequestMapping(value="/sessionAttributes")
public class SessionAttributesController {

	/**
	 * In this scenario, if user access http://localhost:8080/sessionAttributes/url1
	 * then Spring will instantiate user object and will be set in session with defined value in any.
	 *  
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/url1")
	public String setSessionAttribut(Model model) {
		
		User user = new User();
		user.setName("Devendra");
		model.addAttribute("user",user);
		
		return null;
	}
	
	/**
	 * In this scenario, if user access http://localhost:8080/sessionAttributes/url2,
	 * then spring will check if user instance is available in session, if it is available then user will
	 * return that instance by updating property value received from @ModelAttribute.
	 * 
	 * Suppose user access http://localhost:8080/sessionAttributes/url1 first then session will store user object
	 * with value "Devendra"
	 * Then suppose if user access if user access http://localhost:8080/sessionAttributes/url2 with only attribute value for id and not 
	 * sending name then Spring will copy user object stored in first access and only update id attribute value. It will
	 * not update name attribute value and it will remain "Devendra"
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/url2",method=RequestMethod.POST)
	public String getSessionAttribute(@ModelAttribute User user) {
		
		
		return "Data for user is "+user.getId()+" - "+user.getName();
	}	
}
