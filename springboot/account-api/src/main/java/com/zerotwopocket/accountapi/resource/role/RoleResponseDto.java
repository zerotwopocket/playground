package com.zerotwopocket.accountapi.resource.role;

import com.zerotwopocket.accountapi.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleResponseDto {
  private Long id;
  private String name;

  public RoleResponseDto(Role role) {
    this.id = role.getId();
    this.name = role.getName();
  }
}
