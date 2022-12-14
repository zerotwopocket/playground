package com.zerotwopocket.security.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zerotwopocket.security.model.LoginRequest;
import com.zerotwopocket.security.token.TokenGenerator;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private final AuthenticationManager authenticationManager;
  private final TokenGenerator tokenGenerator;

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

    try {
      LoginRequest loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
      return authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              loginRequest.getUsername(), loginRequest.getPassword(), new ArrayList<>()));
    } catch (IOException e) {
      throw new AuthException(e.getMessage());
    }
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult) {
    String token = tokenGenerator.generate(authResult);
    response.addHeader(
        AuthenticationConfigConstants.HEADER_STRING,
        AuthenticationConfigConstants.TOKEN_PREFIX + token);
  }
}
