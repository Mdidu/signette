package com.signette.repository;

import com.signette.domains.ERole;
import com.signette.domains.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    Optional<RoleEntity> findByRoleType(ERole name);
}
