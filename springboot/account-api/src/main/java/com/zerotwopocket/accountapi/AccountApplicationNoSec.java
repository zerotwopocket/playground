package com.zerotwopocket.accountapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication(
    exclude = { SecurityAutoConfiguration.class}
)
@Profile("nosecurity")
public class AccountApplicationNoSec {

  public static void main(String[] args) {
    SpringApplication.run(AccountApplicationNoSec.class,args);
  }
}
