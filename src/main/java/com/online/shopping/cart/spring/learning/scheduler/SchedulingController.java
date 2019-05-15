package com.online.shopping.cart.spring.learning.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/scheduler")
public class SchedulingController {

	@Autowired
	SchedulerService schedulerService;
	
	@RequestMapping(value="/url1")
	public String sceduler() {
		
		schedulerService.schedulerJob();
		
		return "Success";
	}
}
