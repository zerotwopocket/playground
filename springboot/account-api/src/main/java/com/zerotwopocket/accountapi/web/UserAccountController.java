package com.zerotwopocket.accountapi.web;

import com.zerotwopocket.accountapi.domain.UserAccount;
import com.zerotwopocket.accountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
@Slf4j
public class UserAccountController {

  private final AccountService accountService;

  @PostMapping("create")
  @ResponseBody
  public UserAccount createAccount(@RequestBody UserAccount userAccount) {
    return accountService.create(userAccount);
  }

  @PostMapping("update")
  @ResponseBody
  public UserAccount update(@RequestBody UserAccount userAccount) {
    return accountService.create(userAccount);
  }

//  @GetMapping("{id}")
//  @ResponseBody
//  public UserAccount update(@PathVariable("id") Long id) {
//    return accountService.create(userAccount);
//  }

//  @PostMapping("delete")
//  @ResponseBody
//  public UserAccount update(@PathVariable("id") Long id) {
//    return accountService.create(userAccount);
//  }
}
