package com.zerotwopocket.security.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zerotwopocket.security.service.AuthenticationConfigConstants;
import java.util.Date;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class TokenGenerator {
  public String generate(Authentication authentication) {
    return JWT.create()
        .withSubject(((User) authentication.getPrincipal()).getUsername())
        .withExpiresAt(
            new Date(System.currentTimeMillis() + AuthenticationConfigConstants.EXPIRATION_TIME))
        .sign(Algorithm.HMAC512(AuthenticationConfigConstants.SECRET.getBytes()));
  }
}
