package com.wipro.spring.security.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(customizer -> customizer.disable())
						   .authorizeHttpRequests().requestMatchers("/api/userEntity/getHello")
						   .permitAll()
						   .and()
						   .authorizeHttpRequests().requestMatchers("/api/userEntity/*")
						   .authenticated().and()
						   .formLogin(Customizer.withDefaults())
						   .httpBasic(Customizer.withDefaults())
						   .build();
		
	}
	
	@Bean
	public AuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		//daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return daoAuthenticationProvider;
	}
	
	
	
	
//	@Bean
//	protected UserDetailsService getUserDetailsService() {
//		
//		List<UserDetails> list = new ArrayList<UserDetails>();
//		
//		list.add(User.withDefaultPasswordEncoder().username("abdulabbu07").password("abbu123").roles("USER").build());
//		
//		list.add(User.withDefaultPasswordEncoder().username("admin123").password("admin123").roles("ADMIN").build());
//		
//		list.add(User.withDefaultPasswordEncoder().username("trainee123").password("trainee123").roles("TRAINEE").build());
//		
//		return new InMemoryUserDetailsManager(list);
//	}

}
