package com.zerotwopocket.accountapi.service;

import com.zerotwopocket.accountapi.domain.Role;
import com.zerotwopocket.accountapi.domain.UserAccount;
import com.zerotwopocket.accountapi.repo.RoleRepo;
import com.zerotwopocket.accountapi.repo.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("devlocal-no-sec")
public class AppInitializer {

  public static final String RAW_PASSWORD = "12345";
  public static final String TESTDEV = "testdev";
  public static final String ROLE_ADMIN = "ROLE_ADMIN";
  private final UserAccountRepository userAccountRepository;
  private final RoleRepo roleRepo;
  private final BCryptPasswordEncoder passwordEncoder;

  public void init(){
    UserAccount userAccount = new UserAccount();
    userAccount.setUsername(TESTDEV);
    userAccount.setPassword(passwordEncoder.encode(RAW_PASSWORD));
    userAccountRepository.save(userAccount);

    Role role = new Role();
    role.setName(ROLE_ADMIN);
    roleRepo.save(role);
  }

}
