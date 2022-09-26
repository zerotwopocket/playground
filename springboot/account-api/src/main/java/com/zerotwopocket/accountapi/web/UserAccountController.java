package com.zerotwopocket.accountapi.web;

import com.zerotwopocket.accountapi.domain.UserAccount;
import com.zerotwopocket.accountapi.service.AccountService;
import java.util.List;
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

  @GetMapping("")
  @ResponseBody
  public List<UserAccount> findAll() {
    return accountService.findAll();
  }

  @GetMapping("{id}")
  @ResponseBody
  public UserAccount update(@PathVariable("id") Long id) {
    return accountService.find(id);
  }

  @PostMapping("create")
  @ResponseBody
  public UserAccount createAccount(@RequestBody UserAccountDto userAccount) {
    return accountService.create(userAccount);
  }

  @PostMapping("update")
  @ResponseBody
  public UserAccount update(@RequestBody UserAccountDto userAccount) {
    return accountService.create(userAccount);
  }

  @PostMapping("delete/{id}")
  @ResponseBody
  public void delete(@PathVariable("id") Long id) {
    accountService.delete(id);
  }
}
