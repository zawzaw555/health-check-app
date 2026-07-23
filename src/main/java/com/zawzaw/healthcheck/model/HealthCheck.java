package com.zawzaw.healthcheck.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
		/* HealthCheckクラスは　健康診断データ用 */
public class HealthCheck {
	
	private Integer healthCheckId;
	private String userId;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkDate;
	private String result;
	
	private Double bmi;
	private Double height;
	private Double weight;
	
	private Integer systolicBloodPressure;
	private Integer diastolicBloodPressure;
	
}