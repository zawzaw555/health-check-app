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
	public void insertHealthCheck(HealthCheck healthCheck) {
		
		calculateHealthCheck(healthCheck);
		
		healthCheckMapper.insertHealthCheck(healthCheck);
	}
	
	@Override
	public void deleteHealthCheck(Integer healthCheckId) {
		healthCheckMapper.deleteHealthCheck(healthCheckId);
	}
	
	@Override
	public void updateHealthCheck(HealthCheck healthCheck) {
		
		calculateHealthCheck(healthCheck);
		
		healthCheckMapper.updateHealthCheck(healthCheck);
	}
	
	@Override
	public void calculateHealthCheck(HealthCheck healthCheck) {
		double height = healthCheck.getHeight() / 100.0;
		double weight = healthCheck.getWeight();
		
		double bmi = weight / (height * height);
		
		healthCheck.setBmi(Math.round(bmi * 10.0) / 10.0 );
		
		if ( bmi < 18.5 ) {
			healthCheck.setResult("低体重");
		} else if ( bmi < 25.0 ) {
			healthCheck.setResult("普通体重");
		} else if ( bmi < 30.0 ) {
			healthCheck.setResult("肥満1度");
		}else if ( bmi < 35.0 ) {
			healthCheck.setResult("肥満2度");
		} else if ( bmi < 40.0 ) {
			healthCheck.setResult("肥満3度");
		} else {
			healthCheck.setResult("肥満4度");
		}
	}
}
