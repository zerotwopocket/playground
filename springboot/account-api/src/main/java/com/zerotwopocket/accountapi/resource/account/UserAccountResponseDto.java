package com.zerotwopocket.accountapi.resource.account;

import com.zerotwopocket.accountapi.domain.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAccountResponseDto {
  private Long id;
  private String username;


  public UserAccountResponseDto(UserAccount userAccount){
    this.id = userAccount.getId();
    this.username = userAccount.getUsername();
  }
}
