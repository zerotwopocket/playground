package com.zerotwopocket.security.repo;

import com.zerotwopocket.security.model.ApiUser;

import java.util.Optional;

public interface UserRepository {
  Optional<ApiUser> findByUsername(String username);
}
