package com.zerotwopocket.accountapi.web;

import lombok.Data;

@Data
public class UserAccountDto {
  private Long id;
  private String username;
  private String password;
}
