package com.signette.repository;

import com.signette.domains.ERole;
import com.signette.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleType(ERole name);
}
