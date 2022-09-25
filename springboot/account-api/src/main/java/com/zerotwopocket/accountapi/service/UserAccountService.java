package com.zerotwopocket.accountapi.service;

import com.zerotwopocket.accountapi.domain.UserAccount;
import com.zerotwopocket.accountapi.repo.UserAccountRepository;
import com.zerotwopocket.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountService implements UserService<UserAccount> {
  private final UserAccountRepository userAccountRepository;

  @Override
  public UserAccount readByUsername(String username) {
    return userAccountRepository.findByUsername(username).orElseThrow(RuntimeException::new);
  }
}
