package com.zerotwopocket.security.service;

public class AuthenticationConfigConstants {
  private AuthenticationConfigConstants() {}
  public static String SECRET = "tankinamall";
  // public static long EXPIRATION_TIME = 864000000; // 10 days
  public static long EXPIRATION_TIME = 60000; // 1 min
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/api/user";
}
