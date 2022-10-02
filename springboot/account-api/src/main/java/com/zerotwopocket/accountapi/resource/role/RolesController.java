package com.zerotwopocket.accountapi.resource.role;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RolesController {

  private final RoleService roleService;

  @GetMapping("")
  public List<RoleResponseDto> findAll() {
    return roleService.findAll().stream().map(RoleResponseDto::new).collect(Collectors.toList());
  }

  @PostMapping("")
  public RoleResponseDto create(@RequestBody RoleRequest roleRequest) {
    return roleService.createOrUpdate(roleRequest);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable("id") Long id) {
    roleService.delete(id);
  }
}
