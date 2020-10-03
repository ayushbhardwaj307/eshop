package com.upgrad.eshop.config;


import com.upgrad.eshop.security.JwtConfigurer;
import com.upgrad.eshop.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.cors().and().httpBasic()
            .disable()
            .csrf()
            .disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/auth/login")
            .permitAll()
            .antMatchers("/auth/register")
            .permitAll()
            .antMatchers("/users/details")
            .permitAll()
            .antMatchers("/user-addresses")
            .permitAll()
            .antMatchers("/products")
            .permitAll()
            .antMatchers("/products/{id}")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .apply(new JwtConfigurer(jwtTokenProvider));
  }

  @Bean
  public AuthenticationFailureHandler authenticationFailureHandler() {
    return new RestAuthenticationFailureHandler();
  }
}

