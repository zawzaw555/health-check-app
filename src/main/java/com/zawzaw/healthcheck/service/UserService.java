package com.zawzaw.healthcheck.service;

import java.util.List;

import com.zawzaw.healthcheck.model.HealthCheck;
import com.zawzaw.healthcheck.model.Muser;

public interface UserService {
	
	/* ユーザー登録 */
	public void signup(Muser user);
	
	/* ユーザーのデータ収得 */
	List<HealthCheck> getHealthCheckList(String userId);
	
	HealthCheck getHealthCheckById(Integer healthCheckId);
}
