package com.zawzaw.healthcheck.config;

import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	    @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
	                .requestMatchers("/login").permitAll()
					.requestMatchers("/signup","/signup/signup").permitAll()
					.requestMatchers("/error").permitAll()
					.requestMatchers("/h2-console/**").permitAll()
	                .anyRequest().authenticated()
	            )
	            .formLogin(form -> form
	                .loginPage("/login")          // 自作ログイン画面を表示
	                .loginProcessingUrl("/login") // ログイン情報の送信先
	                .usernameParameter("userId")  // ログイン画面のparameter
	                .passwordParameter("password")// ログイン画面のparameter
	                .defaultSuccessUrl("/user/list", true)
	                .failureUrl("/login?error")
	                .permitAll()
	            )
	            .logout(logout -> logout
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/login?logout")
	                .permitAll()
	            );
	        http.csrf(csrf -> csrf.disable());
			http.headers(headers -> headers.frameOptions(option -> option.disable()));
			return http.build();
	    }
	    @Bean
		PasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}
}
