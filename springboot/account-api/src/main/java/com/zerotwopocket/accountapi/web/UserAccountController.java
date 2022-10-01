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

  @GetMapping("{id}")
  @ResponseBody
  public UserAccountResponseDto findById(@PathVariable("id") Long id) {
    UserAccount userAccount = accountService.find(id);
    return new UserAccountResponseDto(userAccount);
  }

  @PostMapping("create")
  @ResponseBody
  public UserAccount createAccount(@RequestBody UserAccountDto userAccount) {
    return accountService.create(userAccount);
  }

  @PostMapping("")
  @ResponseBody
  public UserAccountResponseDto createOrUpdate(@RequestBody UserAccountDto userAccount) {
    UserAccount result = accountService.createOrUpdate(userAccount);
    return new UserAccountResponseDto(result);
  }
}
