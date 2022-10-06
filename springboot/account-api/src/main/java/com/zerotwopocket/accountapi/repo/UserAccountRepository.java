package com.zerotwopocket.accountapi.repo;

import com.zerotwopocket.accountapi.domain.UserAccount;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository
    extends  JpaRepository<UserAccount, Long> {
  Optional<UserAccount> findByUsername(String username);

}
