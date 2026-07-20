package com.zawzaw.healthcheck.serviceImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.zawzaw.healthcheck.model.Muser;
import com.zawzaw.healthcheck.repository.UserMapper;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String userId) 
			throws UsernameNotFoundException {
		Muser user = mapper.findUserById(userId);
		if(user == null) {
			throw new UsernameNotFoundException(
						"ユーザーが見つかりません: " + userId
			);
		}
		return User.withUsername(userId)
					.password(user.getPassword())
					.roles("USER")
					.build();
	}
}
