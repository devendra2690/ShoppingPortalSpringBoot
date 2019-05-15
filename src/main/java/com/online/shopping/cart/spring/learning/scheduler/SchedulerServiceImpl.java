package com.online.shopping.cart.spring.learning.scheduler;

import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

@Repository
public class SchedulerServiceImpl implements SchedulerService{

	@Override
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void schedulerJob() {
		
		System.out.println("Current time is :: " + Calendar.getInstance().getTime());
	}
}
