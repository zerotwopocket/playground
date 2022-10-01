package com.zerotwopocket.accountapi.web;

import com.zerotwopocket.accountapi.domain.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAccountResponseDto {
  private Long id;
  private String username;
  private String password;

  public UserAccountResponseDto(UserAccount userAccount){
    this.id = userAccount.getId();
    this.username = userAccount.getUsername();
    this.password = userAccount.getPassword();
  }
}