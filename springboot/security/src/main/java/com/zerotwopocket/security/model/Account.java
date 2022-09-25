package com.zerotwopocket.security.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Account{
  private String username;
  private String password;
}
