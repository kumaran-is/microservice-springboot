# registry-service
Registry and Discovery service is implemented using [Netflix Eureka Service Registry](https://github.com/spring-cloud/spring-cloud-netflix)

## Table of contents

- [Prerequisites and Installation](#prerequisites-and-installation)
- [Quick Start](#quick-start)
- [Netflix Eureka Service Registry](#netflix-eureka-service-registry)
- [Logging using Logback with SLF4J](#logging-using-logback-with-slf4j)
- [Status and Issues](#status-and-issues)

## Prerequisites and Installation

Library | Version | Notes
:-------|:--------:|-------
[Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) | 11 | Recommended Java version
[Spring Boot](https://spring.io/projects/spring-boot) | 2.5.7 | Recommended Spring Boot version
[Spring Cloud](https://spring.io/projects/spring-cloud) | 2020.0.4 | Provides set of tools to quickly build production grade distirbuted micro-services and deploy to cloud.
[Netflix Eureka Service Registry](https://github.com/spring-cloud/spring-cloud-netflix)| 1.10.16 | Eureka Clients are the independent microservices that are auto registered with Eureka Server to be discovered by other services and clients.
[logback-classic](http://logback.qos.ch/)| 1.2.6 | Java library to provide log functionality
[slf4j](http://www.slf4j.org/)| 1.7.32 | Java library serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.

## Quick Start
TBD

## Netflix Eureka Service Registry
Netflix Eureka is a Java Library that provides client-side service discovery which allows services to find and communicate with each other without hard-coding hostname and port. 

Microservices that are auto registered with Eureka Server are called Eureka Client that can be discovered by other services and clients using name

Each Eureka client can simultaneously act as a server, to replicate its status to a connected peer. In other words, a client retrieves a list of all connected peers of a service registry and makes all further requests to any other services through a load-balancing algorithm.

To be informed about the presence of a client, they have to send a heartbeat signal to the registry.

To implement Netflix Eureka Service Registry we need :

- A service registry (Eureka Server),
- One or more  REST services/micro-services (Eureka Client) which registers itself with Eureka Server 

## Logging using Logback with SLF4J
Logback is one of the most widely used logging frameworks in Spring boot and natively implements the SLF4J. Default log level is `info`. The order of the log levels are `Error < Warn < Info < Debug < Trace`. You can find the log configurations in `logback.xml` under resources folder

## Status and Issues

* [Change History](./../CHANGELOG.md).
* [Issue tracker](https://github.com/kumaran-is/microservice-springboot/issues?state=open)