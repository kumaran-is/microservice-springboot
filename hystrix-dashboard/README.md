# hystrix-dashboard
Hystrix Dashboard is a web application that provides a dashboard for monitoring the set of application metrics. It displays the health of each Hystrix circuit-breaker in a very simple way.

## Table of contents

- [Prerequisites and Installation](#prerequisites-and-installation)
- [Quick Start](#quick-start)
- [Hystrix Dashboard](#hystrix-dashboard)
- [Logging using Logback with SLF4J](#logging-using-logback-with-slf4j)
- [Status and Issues](#status-and-issues)

## Prerequisites and Installation

Library | Version | Notes
:-------|:--------:|-------
[Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) | 11 | Recommended Java version
[Spring Boot](https://spring.io/projects/spring-boot) | 2.3.4.RELEASE | Recommended Spring Boot version
[Spring Cloud](https://spring.io/projects/spring-cloud) | Hoxton.SR8 | Provides set of tools to quickly build production grade distirbuted micro-services and deploy to cloud.
[Netflix Hystrix Dashboard](https://github.com/spring-cloud-samples/hystrix-dashboard) | 1.5.18 | Dashboard for monitoring the set of application metrics and the health of each Hystrix circuit-breaker.
[Netflix Eureka Client](https://cloud.spring.io/spring-cloud-netflix/multi/multi__service_discovery_eureka_clients.html)| 1.9.25 | Eureka Clients are the independent microservices that are auto registered with Eureka Server to be discovered by other services and clients.
[logback-classic](http://logback.qos.ch/)| 1.2.6 | Java library to provide log functionality
[slf4j](http://www.slf4j.org/)| 1.7.32 | Java library serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.

## Quick Start
TBD

## Hystrix Dashboard
- Copy the url that emits hytrix stream <http://localhost:9191/actuator/hystrix.stream>
- Navigate to <http://localhost:9295/hystrix> and paste the hytrix stream URL and click the `Monitor Stream` to monitor the application metrics and health of each Hystrix circuit-breaker


## Logging using Logback with SLF4J
Logback is one of the most widely used logging frameworks in Spring boot and natively implements the SLF4J. Default log level is `info`. The order of the log levels are `Error < Warn < Info < Debug < Trace`. You can find the log configurations in `logback.xml` under resources folder

## Status and Issues

* [Change History](./../CHANGELOG.md).
* [Issue tracker](https://github.com/kumaran-is/microservice-springboot/issues?state=open)