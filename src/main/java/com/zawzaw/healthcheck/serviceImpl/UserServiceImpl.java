package com.zawzaw.healthcheck.serviceImpl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zawzaw.healthcheck.model.HealthCheck;
import com.zawzaw.healthcheck.model.Muser;
import com.zawzaw.healthcheck.repository.HealthCheckMapper;
import com.zawzaw.healthcheck.repository.UserMapper;
import com.zawzaw.healthcheck.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	private final HealthCheckMapper mapper;
	private final PasswordEncoder encoder;
	private final UserMapper userMapper;
	
	/* ユーザー登録 */
	@Override
	public void signup(Muser user) {
		/* パスワードをエンコードします */
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
		
		int count = userMapper.insertUser(user);

        log.info("登録件数={}件", count);
	}
	
	@Override
    public List<HealthCheck> getHealthCheckList(String userId) {
        return mapper.selectHealthCheckList(userId);
    }
	
	@Override
	public HealthCheck getHealthCheckById(Integer healthCheckId) {
	    return mapper.selectHealthCheckById(healthCheckId);
	}
}
