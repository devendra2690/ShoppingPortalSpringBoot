package com.online.shopping.cart;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;


/**
 * @EnableCaching --> Need in order to allow caching in Application
 * 
 * @EnableScheduling --> Schedule JOB which will run after every certain timer period. Example: Pushing Data from CUBE to BDM every 20 minute.
 * @author dpatil
 *
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableAsync
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}
	
	/**
	 * Create async thread pool for executing asyncronous method
	 * 
	 * @return
	 */
	@Bean("asyncExecutor")
	public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("AsynchThread-");
        executor.initialize();
        return executor;
    }
	
	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
}

