package com.zerotwopocket.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public abstract class AuthenticationUserDetailService<T> implements UserDetailsService {
  private final UserService<T> userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    T apiUser = userService.readByUsername(username);
    if (apiUser == null) throw new UsernameNotFoundException(username);
    return transform(apiUser);
  }

  protected abstract UserDetails transform(T t);
}
