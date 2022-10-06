package com.zerotwopocket.accountapi.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.zerotwopocket.accountapi.resource.account.UserAccountController;
import com.zerotwopocket.accountapi.resource.account.AccountService;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// @ExtendWith(SpringExtension.class)
@WebMvcTest(
    value = UserAccountController.class,
    excludeAutoConfiguration = SecurityAutoConfiguration.class)
class UserAccountControllerTest {
  @Autowired private MockMvc mockMvc;
  @MockBean private AccountService accountService;

  @Test
  void findAllTest() throws Exception {
    given(accountService.findAll()).willReturn(Collections.emptyList());
    mockMvc
        .perform(MockMvcRequestBuilders.get("/account").accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
