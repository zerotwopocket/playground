package com.zerotwopocket.security.service;

import com.zerotwopocket.security.model.ApiUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {
  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    ApiUser apiUser = userService.readByUsername(username);
    if (apiUser == null) throw new UsernameNotFoundException(username);
    return new User(apiUser.getUsername(), apiUser.getPassword(), Collections.emptyList());
  }
}
