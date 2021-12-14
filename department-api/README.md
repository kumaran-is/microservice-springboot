# department-api
Department API is a micro-service built using [Spring Boot](https://spring.io/projects/spring-boot) and [Spring Cloud](https://spring.io/projects/spring-cloud) to showcase CRUD operations using Spring Web MVC, Spring Data and Mongo database

## Table of contents

- [Prerequisites and Installation](#prerequisites-and-installation)
- [Quick Start](#quick-start)
- [Design, Document and Test API services using SpringFox and Swagger](#design-document-and-test-api-services-using-springfox-and-swagger)
- [Monitor the API Service using Spring Boot Actuator HTTP Endpoints](#monitor-the-aoi-service-using-spring-boot-actuator-http-endpoints)
- [Logging using Logback with SLF4J](#logging-using-logback-with-slf4j)
- [Status and Issues](#status-and-issues)

## Prerequisites and Installation

Library | Version | Notes
:-------|:--------:|-------
[Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) | 11 | Recommended Java version
[Spring Boot](https://spring.io/projects/spring-boot) | 2.5.7 | Recommended NPM version
[Spring Cloud](https://spring.io/projects/spring-cloud) | 12.2.x | Provides set of tools to quickly build production grade distirbuted micro-services and deploy to cloud.
[Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb) | 3.2.7 | Provides POJO centric model and repository style data access layer to interact with MongoDB.
[lombok](https://projectlombok.org/)| 1.18.x | java library tool that generates code for Java POJO like getter/setter, constructors, equals, hashcode  and toString methods to minimize/remove the boilerplate code
[SpringFox](http://springfox.github.io/springfox/)| 3.x | Java Library to document API endpoints based on swagger 3 Specifications
[MongoDB Database](https://docs.mongodb.com/manual/introduction/) | 5.x | A relational database.
[Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html)| 2.5.7 | It provides health and monitoring metrics, traffic and state of the database/appications.
[logback-classic](http://logback.qos.ch/)| 1.2.6 | Java library to provide log functionality
[slf4j](http://www.slf4j.org/)| 1.7.32 | Java library serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.

## Quick Start

## Design, Document and Test API services using SpringFox and Swagger
[SpringFox](http://springfox.github.io/springfox/) is a Java library based on Swagger 3 specification and integrates well with Spring Boot 2 to document and lists all API endpoints with detailed information about them like description, parameters and output schema in JSON format. 

### REST Endpoints
Navigate to Swagger UI <http://localhost:9001/swagger-ui/> and discover all the API endpoints for this mircoservice.

## Monitor the API Service using Spring Boot Actuator HTTP Endpoints
[Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html) exposes set of Hypermedia HTTP Endpoints <http://localhost:9002/actuator> that provides operational information about the running application. It provides health and monitoring metrics, traffic and state of the database from production-ready applications

### Health Check API
Spring Boot Actuator exposes a configurable health-check endpoint which are often required by load balancers or service discovery frameworks like Consul. The health-check is disabled by default. It can be enabled by setting the property `enableHealthCheck` to `true` in the mpropz property file `core\app-properties.json`. Once this is turned on, the Spring Boot Actuator  will by default expose a healthcheck endpoint on:

| Method / Resource  | Description                     |  URL                                                   |
|--------------------|---------------------------------|--------------------------------------------------------|
| `GET /health-check` | Checks the health of the server | <http://localhost:9001/actuator/health> |

## Logging using Logback with SLF4J
Logback is one of the most widely used logging frameworks in Spring boot and natively implements the SLF4J. Default log level is `info`. The order of the log levels are `Error < Warn < Info < Debug < Trace`. You can find the log configurations in `logback.xml` under resources folder

## Status and Issues

* [Change History](./../CHANGELOG.md).
* [Issue tracker](https://github.com/kumaran-is/microservice-springboot/issues?state=open)
