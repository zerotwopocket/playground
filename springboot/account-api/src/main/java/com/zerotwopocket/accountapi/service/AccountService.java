package com.zerotwopocket.accountapi.service;

import com.zerotwopocket.accountapi.domain.UserAccount;
import com.zerotwopocket.accountapi.repo.UserAccountRepository;
import com.zerotwopocket.accountapi.web.UserAccountDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
  private final UserAccountRepository userAccountRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserAccount create(UserAccountDto userAccount) {
    return userAccountRepository.save(map(userAccount));
  }

  private UserAccount map(UserAccountDto request) {
    UserAccount acct = new UserAccount();
    acct.setId(request.getId());
    acct.setUsername(request.getUsername());
    acct.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
    return acct;
  }

  @Transactional
  public UserAccount update(UserAccount userAccount) {
    UserAccount currentRecord = find(userAccount.getId());
    currentRecord.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
    userAccountRepository.save(currentRecord);
    return currentRecord;
  }

  public UserAccount find(String username) {
    return userAccountRepository
        .findByUsername(username)
        .orElseThrow(() -> new RuntimeException("Account with username" + username + " not found"));
  }

  @Transactional(readOnly = true)
  public UserAccount find(Long id) {
    return userAccountRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Account with id " + id + " not found"));
  }

  public List<UserAccount> findAll() {
    return userAccountRepository.findAll();
  }

  public void delete(Long id) {
    userAccountRepository.deleteById(id);
  }

  public UserAccount createOrUpdate(UserAccountDto userAccount) {

    UserAccount oldRecord =
        userAccountRepository.findByUsername(userAccount.getUsername()).orElse(null);

    if (oldRecord == null) return create(userAccount);

    oldRecord.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));

    return userAccountRepository.save(oldRecord);
  }
}
