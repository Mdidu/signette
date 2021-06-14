package com.signette.service;

import com.signette.domains.User;

import java.util.Optional;

public interface UserService extends GlobalService<User>{
    Optional<User> findByUserMail(String mail);
    boolean existsByUserMail(String mail);
}
