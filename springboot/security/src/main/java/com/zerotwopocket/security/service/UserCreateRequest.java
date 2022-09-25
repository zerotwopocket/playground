package com.zerotwopocket.security.service;

import lombok.Data;

@Data
public class UserCreateRequest {
  private String username;
  private String password;
}
