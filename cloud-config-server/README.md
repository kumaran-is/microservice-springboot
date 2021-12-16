# cloud-config-server

[Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/reference/html/) provides server-side and client-side support for externalized configuration in a distributed system. It is easy to manage configurations in one centralized location for hundreds of micro-servcies deployed in different environments like dev, stage, prod etc .

## Table of contents

- [Prerequisites and Installation](#prerequisites-and-installation)
- [Quick Start](#quick-start)
- [Centralized Configurations](#centralized-configurations)
- [Spring Cloud Bus](#spring-cloud-bus)
- [Status and Issues](#status-and-issues)

## Prerequisites and Installation

Library | Version | Notes
:-------|:--------:|-------
[Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) | 11 | Recommended Java version
[Spring Boot](https://spring.io/projects/spring-boot) | 2.5.7 | Recommended NPM version
[Spring Cloud](https://spring.io/projects/spring-cloud) | 12.2.x | Provides set of tools to quickly build production grade distirbuted micro-services and deploy to cloud.
[Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/reference/html/) | 2.5.7 | External application configurations in one central locations i.e `Spring Cloud Config Server` in the distributed system.
[Spring Cloud Bus](https://spring.io/projects/spring-cloud-bus#overview) | 2.5.7 | External application configurations in one central locations i.e `Spring Cloud Config Server` in the distributed system.

## Quick Start
TBD

## Centralized Configurations

Application configurations are different for different micro-services and environments.
As number of micro-services increases its get difficult to manage configurations for each micro-services. [Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/reference/html/) solves this problem by externalizing all the configurations in one central locations i.e `Spring Cloud Config Server` in the distributed system. Micro-services access its configurations from this centralized `Spring Cloud Config Server` using  `Spring Cloud Config Client`. `Spring Cloud Config Server` can be deployed in clusters for high-availability and scaling. Micro-services `Spring Cloud Config Client` can also perform retry when config server is unavailable or down for some period.

Following are the some of the backends that are supported by `Spring Cloud Config Server` to store configuration files

- Git Repo
- Vault
- Redis
- AWS S3

For this demo service, we have uploaded all the configuration files to public github repo : <https://github.com/kumaran-is/external-config>

`Spring Cloud Config Server`  can be secured using Spring security, encryption/decryption

 By default, `Spring Cloud Config Client` looks for configuration files that match the application name (for example, EMPLOYEE-API.properties is targeted at the spring.application.name=EMPLOYEE-API, while application.properties is targeted at all applications).

 You can also maintain configurations for different environments using Spring profile.
 For dev, the file name should be  <applicationname>-<environment>.properties (for example, EMPLOYEE-API-dev.properties is targeted for dev environment similarly EMPLOYEE-API-prod.properties is targeted for prod environment whereas EMPLOYEE-API.properties is default properties for all the environments for EMPLOYEE-API service. application.properties is common for all the services/environments).

 To activate the profile for a given environment, add below line to the micro-service application.properties

 ```
    spring.profiles.active=dev
 ```

Profiles can also be activated via the environment variable: 

```
    export spring_profiles_active=dev
```    

You can also access configurations directly from `Spring Cloud Config Server` via browser

<http://localhost:9296/application/default>
<http://localhost:9296/application/dev>
<http://localhost:9296/EMPLOYEE-API/default>
<http://localhost:9296/EMPLOYEE-API/dev>
<http://localhost:9296/EMPLOYEE-API/prod>

## Spring Cloud Bus

Spring Cloud Bus uses lightweight message broker like RabbitMQ, Kafka etc to link distributed system nodes. The primary usage is to broadcast configuration changes or other management information to all the instances of same micro-service running on different ports. Spring Cloud Bus uses AMQP broker or Kafka as the transport to carry out the events to all the micro-services listening on it.

To refresh configuration changes a restart of the client(micro-services) is required every time. There are 2 solutions to refresh the configurations without restarting the micro-services instances

Solution 1: 
          - Add @RefreshScope annotation to micro-service controller
          - Enable the `actuator endoints` in the properties `management.endpoints.web.exposure.include=*`
          - Invoke the actuator refresh `POST` endpoint <http://localhost:9002/actuator/refresh>.This will refresh the configuration changes for that instances alone running on port 9002
          - If there are more than one instances running on different ports, then we need to call refresh `POST` calls on all the instances which is not the ideal solution.
          
Solution 2: 
            - Use [Spring Cloud Bus](https://spring.io/projects/spring-cloud-bus#overview) to automatically notify the configuration changes to all the instances of micro-services. 
            - Add @RefreshScope annotation to micro-service controller
            - Enable the `actuator endoints` in the properties `management.endpoints.web.exposure.include=*`
            -  Add dependency `spring-cloud-starter-bus-amqp` to the micro-service pom.xml

            ```
                <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-bus-amqp</artifactId>
                </dependency>
            ``` 
            -  Run RabbitMQ server using RabbitMQ docker image. RabbbitMQ starts on port `5672`. You can check the RabbitMQ dashboard <http://localhost:15672/#/>

            ```
              docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.8-management
            ```  

            - For micro-service to listen to RabbitMQ event messages, add below configurations to micro-service `application.properties`
         
            ```
            spring.rabbitmq.host=localhost
            spring.rabbitmq.port=5672
            spring.rabbitmq.username=guest
            spring.rabbitmq.password=guest

            ``` 

            - Invoke the actuator refresh `POST` endpoint <http://localhost:9002/actuator/busrefresh>.This will refresh the configuration changes for all instances of micro-services running on different ports



## Status and Issues

* [Change History](./../CHANGELOG.md).
* [Issue tracker](https://github.com/kumaran-is/microservice-springboot/issues?state=open)