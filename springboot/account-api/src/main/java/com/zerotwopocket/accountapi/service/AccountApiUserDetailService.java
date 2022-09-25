package com.zerotwopocket.accountapi.service;

import com.zerotwopocket.accountapi.domain.UserAccount;
import com.zerotwopocket.security.service.AuthenticationUserDetailService;
import java.util.Collections;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AccountApiUserDetailService extends AuthenticationUserDetailService<UserAccount> {
  public AccountApiUserDetailService(UserAccountService userAccountService) {
    super(userAccountService);
  }

  @Override
  protected UserDetails transform(UserAccount userAccount) {
    return new User(userAccount.getUsername(), userAccount.getPassword(), Collections.emptyList());
  }
}
