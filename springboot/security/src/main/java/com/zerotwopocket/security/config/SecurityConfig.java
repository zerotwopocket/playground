package com.zerotwopocket.security.config;

import com.zerotwopocket.security.service.AuthenticationUserDetailService;
import com.zerotwopocket.security.service.JWTAuthenticationFilter;
import com.zerotwopocket.security.service.JWTAuthorizationFilter;
import com.zerotwopocket.security.token.TokenGenerator;
import com.zerotwopocket.security.token.TokenVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final AuthenticationUserDetailService authenticationUserDetailService;

  private final TokenGenerator tokenGenerator;
  private final TokenVerifier tokenVerifier;

  @Bean
  public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    final AuthenticationManagerBuilder sharedObject =
        http.getSharedObject(AuthenticationManagerBuilder.class);
    return sharedObject
        .userDetailsService(authenticationUserDetailService)
        .passwordEncoder(bCryptPasswordEncoder)
        .and()
        .build();
  }

  @Bean
  public SecurityFilterChain filterChain(
      HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
    http.cors()
        .and()
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .anyRequest()
        .authenticated()
        .and()
        .addFilter(new JWTAuthenticationFilter(authenticationManager, tokenGenerator))
        .addFilter(new JWTAuthorizationFilter(authenticationManager, tokenVerifier))
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    return http.build();
  }
}
