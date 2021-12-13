## 0.2.0 (2021-12-13)

#### Features
* Implemented [Netflix Eureka service registry](https://github.com/spring-cloud/spring-cloud-netflix) using Spring Cloud (spring-cloud-starter-netflix-eureka-server)

## 0.1.0 (2021-12-13)

#### Features

* Initial micro-service project generated using [Spring Initializr](https://start.spring.io/)

* Implemented 2 micro-services:

 (1) `department-api` micro-service using [Spring Boot](https://spring.io/projects/spring-boot), [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb) and [MongoDB Database](https://docs.mongodb.com/manual/introduction/)

  (2) `employee-api` micro-service using [Spring Boot](https://spring.io/projects/spring-boot), [Spring Data JPA](https://spring.io/projects/spring-data-jpa) and [MySQL Database](https://www.mysql.com/)

*  `employee-api` micro-service invokes `department-api` micro-service using Spring RestTemplate to get department details

* Implemented logging using [logback-classic](http://logback.qos.ch/) and  [slf4j](http://www.slf4j.org/)

* Implemented swagger using [SpringFox](http://springfox.github.io/springfox/)

* Implemented health-check and monitoring metrics using [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)
