package com.zerotwopocket.accountapi;

import com.zerotwopocket.accountapi.service.AppInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Profile("devlocal-no-sec")
public class AccountApplicationNoSec {

  @Autowired private AppInitializer appInitializer;

  public static void main(String[] args) {
    SpringApplication.run(AccountApplicationNoSec.class, args);
  }

  @EventListener
  public void appReady(ApplicationReadyEvent event) {
    appInitializer.init();
  }
}
