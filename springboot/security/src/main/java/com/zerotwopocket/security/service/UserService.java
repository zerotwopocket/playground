package com.zerotwopocket.security.service;

import com.zerotwopocket.security.model.ApiUser;
import com.zerotwopocket.security.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public ApiUser readByUsername(String username) {
    return userRepository.findByUsername(username).orElseThrow(RuntimeException::new);
  }
}
