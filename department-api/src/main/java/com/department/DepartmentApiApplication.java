package com.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/*
 * if we're using a Spring Boot project and have a spring-data-* or spring-tx dependencies on the classpath, then 
 * transaction management will be enabled by default.
 * @EnableTransactionManagement
 */
@Slf4j
@SpringBootApplication
public class DepartmentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApiApplication.class, args);
		log.info("department-api microservice started......");
	}

}
