package com.zerotwopocket.security.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zerotwopocket.security.service.AuthenticationConfigConstants;

// @Component
public class TokenVerifier {
  public DecodedJWT verify(String token) {
    return JWT.require(Algorithm.HMAC512(AuthenticationConfigConstants.SECRET.getBytes()))
        .build()
        .verify(token.replace("Bearer", "").trim());
  }
}
