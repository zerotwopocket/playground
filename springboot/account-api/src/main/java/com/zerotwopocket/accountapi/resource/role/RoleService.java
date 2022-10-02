package com.zerotwopocket.accountapi.resource.role;

import com.zerotwopocket.accountapi.domain.Role;
import com.zerotwopocket.accountapi.repo.RoleRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleService {

  private final RoleRepo roleRepo;

  public List<Role> findAll() {
    return roleRepo.findAll();
  }

  public RoleResponseDto createOrUpdate(RoleRequest roleRequest) {

    Role oldRecord = roleRepo.findByName(roleRequest.getName()).orElse(null);

    if (oldRecord == null)
      return Optional.of(roleRepo.save(map(roleRequest)))
          .map(RoleResponseDto::new)
          .orElse(null);

    oldRecord.setName(roleRequest.getName());
    return Optional.of(roleRepo.save(oldRecord)).map(RoleResponseDto::new).orElse(null);
  }

  private Role map(RoleRequest roleRequest) {
    Role role = new Role();
    role.setId(roleRequest.getId());
    role.setName(roleRequest.getName());
    return role;
  }

  @Transactional
  public void delete(Long id) {
    Role role = roleRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Role with id " + id + "not found"));
    role.setRoles(new HashSet<>());

    roleRepo.save(role);
    roleRepo.deleteById(id);
  }
}
