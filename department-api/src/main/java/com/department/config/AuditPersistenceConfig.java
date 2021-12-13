package com.department.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.department.audit.AuditorAwareImpl;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorAware")
public class AuditPersistenceConfig {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

}
