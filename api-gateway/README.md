# api-gateway
API Gateway is implemented using using [Spring Cloud Gateway](https://cloud.spring.io/spring-cloud-gateway/reference/html/). Implemented Circuit Breaker using [Netflix Hystrix](https://github.com/Netflix/Hystrix)

## Table of contents

- [Prerequisites and Installation](#prerequisites-and-installation)
- [Quick Start](#quick-start)
- [Spring Cloud Gateway](#spring-cloud-gateway)
- [Netflix Hystrix Circuit Breaker](#netflix-hystrix-circuit-breaker)
- [Logging using Logback with SLF4J](#logging-using-logback-with-slf4j)
- [Status and Issues](#status-and-issues)

## Prerequisites and Installation

Library | Version | Notes
:-------|:--------:|-------
[Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) | 11 | Recommended Java version
[Spring Boot](https://spring.io/projects/spring-boot) | 2.3.4.RELEASE | Recommended Spring Boot version
[Spring Cloud](https://spring.io/projects/spring-cloud) | Hoxton.SR8 | Provides set of tools to quickly build production grade distirbuted micro-services and deploy to cloud.
[Spring Cloud Gateway](https://cloud.spring.io/spring-cloud-gateway/reference/html/)] | 2.2.5 | Spring library to route APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.
[Netflix Hystrix Circuit Breaker](https://github.com/spring-cloud-samples/hystrix-dashboard) | 1.5.18 | dashboard for monitoring the set of application metrics and the health of each Hystrix circuit-breaker.
[Netflix Eureka Client](https://cloud.spring.io/spring-cloud-netflix/multi/multi__service_discovery_eureka_clients.html)| 1.9.25 | Eureka Clients are the independent microservices that are auto registered with Eureka Server to be discovered by other services and clients.
[logback-classic](http://logback.qos.ch/)| 1.2.6 | Java library to provide log functionality
[slf4j](http://www.slf4j.org/)| 1.7.32 | Java library serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.

## Quick Start
TBD

## Spring Cloud Gateway
API Gateway built on top of the Spring Ecosystem. Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, rate limit, service aggregation, filtering, routing and fault tolerance (resiliency). Custom filter can be implemented to perform role based authentication, pre and post processing request/response, encrypt data etc.

## Netflix Hystrix Circuit Breaker
Netflix Hystrix implements circuit breaker for distributed systems. Hystrix is a latency and fault tolerance library designed to isolate points of access to remote systems, services and 3rd party libraries, stop cascading failure and enable resilience in complex distributed systems where failure is inevitable.
Retry and handle the error gracefuly, we don't want calling service to collapse and throw exceptions to the client.



Note: Hystrix is no longer in active development, and is currently deprecated.

Resilience4j is a recommended lightweight fault tolerance library inspired by Netflix Hystrix, but designed for Java 8 and functional/reactive programming. It provides adaptive implementations that react to an application’s real time performance rather than pre-configured settings (for example, through adaptive concurrency limits)

Netflix Hystrix aggregate data from all the servicesv into a single stream of metrics supporting the dashboard application, which in turn streams the aggregated data to the browser for display in the UI. You can find the hystrix stream <http://localhost:9191/actuator/hystrix.stream>. 

Hystrix stream can be monitored on Hystrix Dashboard to monitor the application metrics and health of each Hystrix circuit-breaker 


## Logging using Logback with SLF4J
Logback is one of the most widely used logging frameworks in Spring boot and natively implements the SLF4J. Default log level is `info`. The order of the log levels are `Error < Warn < Info < Debug < Trace`. You can find the log configurations in `logback.xml` under resources folder

## Status and Issues

* [Change History](./../CHANGELOG.md).
* [Issue tracker](https://github.com/kumaran-is/microservice-springboot/issues?state=open)