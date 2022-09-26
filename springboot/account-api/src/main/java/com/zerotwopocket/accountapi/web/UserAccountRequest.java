package com.zerotwopocket.accountapi.web;

import lombok.Data;

@Data
public class UserAccountRequest {
  private String username;
  private String password;
}
