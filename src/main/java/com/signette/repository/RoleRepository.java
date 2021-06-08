package com.signette.repository;

import com.signette.domains.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
}
