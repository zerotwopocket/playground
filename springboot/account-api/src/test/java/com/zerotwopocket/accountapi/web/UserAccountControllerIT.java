package com.zerotwopocket.accountapi.web;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class UserAccountControllerIT {

  @Autowired private MockMvc mockMvc;

  @Test
  void findAllTest() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/account"))
        .andDo(print())
        .andExpect(status().isOk())
    //        .andExpect(MockMvcResultMatchers.jsonPath())
    ;
  }

  @Test
  @Sql(scripts = "classpath:initial_state.sql")
  void findByIdTest() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/account/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.username", is("testdev1664407134797")))
        .andExpect(jsonPath("$.password", is("$2a$10$9y0Ln5gfzf.xrBzVNWxAP.9m3xPSnDTwTphtDitpMN6fBaY5rVglO")));
  }

  @Test
  void findByUsernameTest() throws Exception {

    // TODO

  }

  @Test
  void createTest() throws Exception {

    UserAccountDto createReq = new UserAccountDto();
    String username = String.format("testdev%d", System.currentTimeMillis());
    String password = "123123";
    createReq.setUsername(username);
    createReq.setPassword(password);
    String payload = new ObjectMapper().writeValueAsString(createReq);
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", Matchers.notNullValue()));
  }

  @Test
  void updateTest() throws Exception {
    // TODO
  }

  @Test
  void deleteByIdTest() throws Exception {
    // TODO
  }
}