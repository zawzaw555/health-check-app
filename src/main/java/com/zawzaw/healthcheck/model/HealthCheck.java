package com.zawzaw.healthcheck.model;

import java.time.LocalDate;

import lombok.Data;

@Data
		/* HealthCheckクラスは　健康診断データ用 */
public class HealthCheck {
	
	private Integer healthCheckId;
	private String userId;
	private LocalDate checkDate;
	private String result;
	
	private Double bmi;
	private Double height;
	private Double weight;
	
	private Integer systolicBloodPressure;
	private Integer diastolicBloodPressure;
	
}