package com.online.shopping.cart.spring.learning.path.variable;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pathvariable")
public class PathVaribleController {

	/**
	 * 
	 * Get URL data into varible
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/url1/{id}")
	public String getPathVarible(@PathVariable("id") int id) {
		
		return "Path Varible Value is"+id;
	}
	
	
	
	/**
	 * 
	 * Get list of URL variable in Map
	 * @param pathVaribleMap
	 * @return
	 */
	@RequestMapping(value="/url2/{id}/user/{name}")
	public String displayData(@PathVariable Map<String, String> pathVaribleMap) {
		
		System.out.println(pathVaribleMap);
		return "Data of user is "+pathVaribleMap.get("id")+" - "+pathVaribleMap.get("name");
	}
}
