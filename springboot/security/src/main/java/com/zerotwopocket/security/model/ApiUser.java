package com.zerotwopocket.security.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ApiUser {
  private Long id;
  private String username;
  private String password;
}
