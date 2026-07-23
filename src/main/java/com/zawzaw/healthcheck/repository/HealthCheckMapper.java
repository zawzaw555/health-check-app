package com.zawzaw.healthcheck.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zawzaw.healthcheck.model.HealthCheck;

@Mapper
public interface HealthCheckMapper {
	List<HealthCheck> selectHealthCheckList(
			@Param("userId") String userId);
	
	HealthCheck selectHealthCheckById(
			@Param("healthCheckId") Integer healthCheckId);
	
	int deleteHealthCheck(
			@Param("healthCheckId") Integer healthCheckId);
	
	int updateHealthCheck(HealthCheck healthCheck);
}
