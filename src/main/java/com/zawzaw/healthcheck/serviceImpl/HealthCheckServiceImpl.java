package com.zawzaw.healthcheck.serviceImpl;

import org.springframework.stereotype.Service;

import com.zawzaw.healthcheck.model.HealthCheck;
import com.zawzaw.healthcheck.repository.HealthCheckMapper;
import com.zawzaw.healthcheck.service.HealthCheckService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HealthCheckServiceImpl implements HealthCheckService {
	private final HealthCheckMapper healthCheckMapper;
	
	@Override
	public void deleteHealthCheck(Integer healthCheckId) {
		healthCheckMapper.deleteHealthCheck(healthCheckId);
	}
	
	@Override
	public void updateHealthCheck(HealthCheck healthCheck) {
		healthCheckMapper.updateHealthCheck(healthCheck);
	}
}
