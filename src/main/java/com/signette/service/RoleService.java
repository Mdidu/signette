package com.signette.service;

import com.signette.domains.ERole;
import com.signette.domains.RoleEntity;

import java.util.Optional;

public interface RoleService extends GlobalService<RoleEntity>{
    Optional<RoleEntity> findByRoleType(ERole name);
}
