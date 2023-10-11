package com.grievance.Grievance.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grievance.Grievance.Enum.UserType;
import com.grievance.Grievance.repository.UserRepository;

/**
 * A custom security filter for controlling access to specific URLs based on
 * user authentication.
 */

@Component
public class SecurityFilter implements javax.servlet.Filter {

  /**
   * Auto wired UserRepository.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * List of URLs that are accessible only to administrators.
   */
  private static List<String> adminUrls = new ArrayList<String>();

  static {
    adminUrls.add("/grievance/department");
    adminUrls.add("/grievance/user");
    adminUrls.add("/grievance/users");
  }

  /**
   * Constructs a new SecurityFilter instance.
   *
   * @param userRepository2 The user repository for checking user authentication.
   */
  public SecurityFilter(UserRepository userRepository2) {
    this.userRepository = userRepository2;
  }

  /**
   * Checks if a URL belongs to the admin specific URLs.
   *
   * @param currentUrl The current URL to check.
   * @return True if the URL belongs to admin URLs, otherwise false.
   */
  public Boolean checkAdminUrl(String currentUrl) {
    if (adminUrls.contains(currentUrl)) {
      return true;
    }
    return false;
  }

  @Override
  public final void doFilter(ServletRequest request,
      ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    String email = httpServletRequest.getHeader("email");
    String password = httpServletRequest.getHeader("password");
    String currentUrl = httpServletRequest.getRequestURI();
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    if (currentUrl.equals("/grievance/login")) {
      chain.doFilter(request, response);
    } else if (httpServletRequest.getMethod().equals("OPTIONS")) {
      httpServletResponse.setHeader("Access-Control-Allow-Origin",
          "*");
      httpServletResponse.setHeader("Access-Control-Allow-Methods",
          "GET, POST, PUT, DELETE");
      httpServletResponse.setHeader("Access-Control-Allow-Headers",
          "Authorization, Content-Type, email, password");
      httpServletResponse.setContentType("application/json");
      httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    } else if (httpServletRequest.getMethod().equals("OPTIONS")) {
      httpServletResponse.setHeader("Access-Control-Allow-Origin",
          "*");
      httpServletResponse.setHeader("Access-Control-Allow-Methods",
          "GET, POST, PUT, DELETE");
      httpServletResponse.setHeader("Access-Control-Allow-Headers",
          "Authorization, Content-Type, email, password");
      httpServletResponse.setContentType("application/json");
      httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    } else {
      if (email == null || password == null) {
        ((HttpServletResponse) response).sendError(
            HttpServletResponse.SC_UNAUTHORIZED, "Invalid User");
      } else if (userRepository.existsByEmailAndPasswordAndUsertype(
          email, password, UserType.Admin)
          && checkAdminUrl(currentUrl)) {
        chain.doFilter(request, response);
      } else if (userRepository.existsByEmailAndPassword(email,
          password) && !(checkAdminUrl(currentUrl))) {
        chain.doFilter(request, response);
      } else {
        ((HttpServletResponse) response).sendError(
            HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized User");
      }
    }
  }

}
