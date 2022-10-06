package com.zerotwopocket.accountapi.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zerotwopocket.accountapi.repo.UserAccountRepository;
import com.zerotwopocket.accountapi.resource.role.RoleRequest;
import com.zerotwopocket.accountapi.resource.role.RoleResponseDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@EnableTransactionManagement
@Slf4j
class RolesControllerTest {

  public static final String ROLE_ADMIN = "ROLE_ADMIN";
  public static final int ROLE_ID = 1;
  @Autowired MockMvc mockMvc;

  @Autowired UserAccountRepository userAccountRepository;

  @Test
  @Sql("classpath:initial_state.sql")
  void testFindAll() throws Exception {
    MvcResult mvcResult =
        mockMvc
            .perform(MockMvcRequestBuilders.get("/role"))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Matchers.is(ROLE_ID)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", Matchers.is(ROLE_ADMIN)))
            .andReturn();
    String content = mvcResult.getResponse().getContentAsString();
    List<RoleResponseDto> roles = new ObjectMapper().readValue(content, new TypeReference<>() {});
    assertThat(roles).hasSize(1);
  }

  @Test
  @Sql("classpath:initial_state.sql")
  void testCreate() throws Exception {
    RoleRequest request = new RoleRequest();
    request.setName("ROLE_USER");
    String payload = new ObjectMapper().writeValueAsString(request);
    MvcResult result =
        mockMvc
            .perform(post("/role").contentType(MediaType.APPLICATION_JSON).content(payload))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.status().isOk())
//            .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.notNullValue()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("ROLE_USER")))
            .andReturn();

    log.info("after return");

    RoleResponseDto response =
        new ObjectMapper()
            .readValue(result.getResponse().getContentAsString(), RoleResponseDto.class);


    assertThat(userAccountRepository.findAll().size()).isEqualTo(1);


  }

  @Test
  @Sql(scripts = "classpath:initial_state.sql")
  void testUpdate() throws Exception {
    RoleRequest request = new RoleRequest();
    request.setId(1L);
    request.setName("ROLE_USER");
    String payload = new ObjectMapper().writeValueAsString(request);
    mockMvc
        .perform(post("/role").contentType(MediaType.APPLICATION_JSON).content(payload))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @Sql(scripts = "classpath:initial_state.sql")
  void testDelete() throws Exception {
    mockMvc
        .perform(delete("/role/" + 1L))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
