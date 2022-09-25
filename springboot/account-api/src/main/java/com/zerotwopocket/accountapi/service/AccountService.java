package com.zerotwopocket.accountapi.service;

import com.zerotwopocket.accountapi.domain.UserAccount;
import com.zerotwopocket.accountapi.repo.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
  private final UserAccountRepository userAccountRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserAccount create(UserAccount userAccount) {
    UserAccount acct = new UserAccount();
    acct.setUsername(userAccount.getUsername());
    acct.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
    return userAccountRepository.save(acct);
  }
}
