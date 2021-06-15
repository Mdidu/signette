package com.signette.service;

import com.signette.domains.ERole;
import com.signette.domains.Role;

import java.util.Optional;

public interface RoleService extends GlobalService<Role, Long>{
    Role findByRoleType(ERole name);
}
