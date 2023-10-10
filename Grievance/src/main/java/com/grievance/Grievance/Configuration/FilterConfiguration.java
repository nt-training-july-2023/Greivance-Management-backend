package com.grievance.Grievance.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.grievance.Grievance.repository.UserRepository;

/**
 * Configuration class for registering custom filters.
 */
@Configuration
public class FilterConfiguration {
  /**
   * Injecting UserRepository.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   *
   * @param userRepository
   */
  public FilterConfiguration(UserRepository userRepository) {
    super();
    this.userRepository = userRepository;
  }

  /**
   * Bean definition for registering the SecurityFilter with URL patterns.
   *
   * @return A FilterRegistrationBean for SecurityFilter.
   */
  @Bean
  FilterRegistrationBean<SecurityFilter> registrationBeanAdmin() {
    FilterRegistrationBean<SecurityFilter> registrationBean = new FilterRegistrationBean<SecurityFilter>();
    registrationBean.setFilter(new SecurityFilter(userRepository));
    registrationBean.addUrlPatterns("/*");
    return registrationBean;
  }
}
