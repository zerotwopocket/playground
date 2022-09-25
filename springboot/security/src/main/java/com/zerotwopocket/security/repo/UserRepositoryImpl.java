package com.zerotwopocket.security.repo;

import com.zerotwopocket.security.model.ApiUser;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {
  @Override
  public Optional<ApiUser> findByUsername(String username) {
    ApiUser apiUser = new ApiUser();
    apiUser.setId(1L);
    apiUser.setUsername("testdevzerotwo");
    apiUser.setPassword("$2a$10$Sf.CEk.tiXfX9aH6l6TCnu5RwwFQurzxiDDZsv./75R8Nf4/6KTQe");//12345
    return Optional.of(apiUser);
  }
}
