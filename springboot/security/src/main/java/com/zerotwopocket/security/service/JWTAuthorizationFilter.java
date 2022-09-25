package com.zerotwopocket.security.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zerotwopocket.security.token.TokenVerifier;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Slf4j
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
  private final TokenVerifier tokenVerifier;
  public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
      TokenVerifier tokenVerifier) {
    super(authenticationManager);
    this.tokenVerifier = tokenVerifier;
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String header = request.getHeader(AuthenticationConfigConstants.HEADER_STRING);

    if (header == null || !header.startsWith(AuthenticationConfigConstants.TOKEN_PREFIX)) {
      chain.doFilter(request, response);
      return;
    }

    UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(request, response);
  }

  private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

    String token = request.getHeader(AuthenticationConfigConstants.HEADER_STRING);

    if (token == null) return null;

    final DecodedJWT decodedJWT = tokenVerifier.verify(token);

    // TODO set claims/roles?

    if (decodedJWT.getSubject() == null) return null;
    return new UsernamePasswordAuthenticationToken(decodedJWT.getSubject(), null, new ArrayList<>());
  }
}
