package com.zawzaw.healthcheck.service;

import com.zawzaw.healthcheck.model.HealthCheck;

public interface HealthCheckService {
	
	void insertHealthCheck(HealthCheck healthCheck);
	
	void deleteHealthCheck(Integer healthCheckId);
	
	void updateHealthCheck(HealthCheck healthCheck);
	
	void calculateHealthCheck(HealthCheck healthCheck);
}
