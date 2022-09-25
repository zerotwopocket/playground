package com.zerotwopocket.security.token;

import com.zerotwopocket.security.token.TokenVerifier;
import org.junit.jupiter.api.Test;

class TokenVerifierTest {

  private String token =
      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";

  @Test
  void verify() {
    TokenVerifier underTest = new TokenVerifier();
    underTest.verify(token);
  }
}
