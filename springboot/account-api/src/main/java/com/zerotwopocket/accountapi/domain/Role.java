package com.zerotwopocket.accountapi.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
  private Set<UserAccount> roles;

  @ManyToMany(mappedBy = "permissions",fetch = FetchType.EAGER)
  private Set<UserAccount> permissions;
}
