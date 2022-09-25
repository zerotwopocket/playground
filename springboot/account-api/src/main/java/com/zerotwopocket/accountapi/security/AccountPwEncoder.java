package com.zerotwopocket.accountapi.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountPwEncoder extends BCryptPasswordEncoder {}
