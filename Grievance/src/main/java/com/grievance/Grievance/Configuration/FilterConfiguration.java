package com.grievance.Grievance.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.grievance.Grievance.repository.UserRepository;

@Configuration
public class FilterConfiguration {

	@Autowired
	UserRepository userRepository;

	public FilterConfiguration(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Bean
	FilterRegistrationBean<SecurityFilter> registrationBeanAdmin() {
		FilterRegistrationBean<SecurityFilter> registrationBean = new FilterRegistrationBean<SecurityFilter>();
		registrationBean.setFilter(new SecurityFilter(userRepository));
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}
}
