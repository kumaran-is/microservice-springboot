package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/*
 * if we're using a Spring Boot project and have a spring-data-* or spring-tx dependencies on the classpath, then 
 * transaction management will be enabled by default.
 * @EnableTransactionManagement
 */
@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class EmployeeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiApplication.class, args);
		log.info("employee-api microservice started......");
	}
	
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
