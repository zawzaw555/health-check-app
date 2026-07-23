package com.zawzaw.healthcheck.service;

import com.zawzaw.healthcheck.model.HealthCheck;

public interface HealthCheckService {
	void deleteHealthCheck(Integer healthCheckId);
	
	void updateHealthCheck(HealthCheck healthCheck);
}
