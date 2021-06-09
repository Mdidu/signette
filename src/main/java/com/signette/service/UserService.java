package com.signette.service;

import com.signette.domains.UserEntity;

import java.util.Optional;

public interface UserService extends GlobalService<UserEntity>{
    Optional<UserEntity> findByMail(String mail);
    boolean existsByMail(String mail);
}
