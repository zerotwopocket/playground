package com.zerotwopocket.security.token;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@ExtendWith(MockitoExtension.class)
class TokenGeneratorTest {
  @Mock private Authentication authentication;

  @Test
  void execute() {
    TokenGenerator tokenGenerator = new TokenGenerator();
    UserDetails abcd =
        User.builder()
            .username("abcd")
            .password("abcd")
            .authorities(Collections.emptyList())
            .build();
    given(authentication.getPrincipal()).willReturn(abcd);
    String token = tokenGenerator.generate(authentication);
    assertThat(token).isNotNull();
  }
}
