package com.zerotwopocket.accountapi.repo;


import com.zerotwopocket.accountapi.domain.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
  Optional<Role> findByName(String name);
}
