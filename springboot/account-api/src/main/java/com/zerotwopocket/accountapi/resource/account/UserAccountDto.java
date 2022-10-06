package com.zerotwopocket.accountapi.resource.account;

import lombok.Data;

@Data
public class UserAccountDto {
  private Long id;
  private String username;
  private String password;
}
