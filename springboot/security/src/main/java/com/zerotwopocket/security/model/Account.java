package com.zerotwopocket.security.model;

import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Account{
  private Long id;
  private String username;
  private String password;
  private Set<String> roles;
  private Set<String> permissions;
}
