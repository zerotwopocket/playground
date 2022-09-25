package com.zerotwopocket.security.service;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthException extends RuntimeException {

  public AuthException(String message) {
    super(message);
  }
}
