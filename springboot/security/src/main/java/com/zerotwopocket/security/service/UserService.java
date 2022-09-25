package com.zerotwopocket.security.service;

public interface UserService<T> {
  public T readByUsername(String username);
}
