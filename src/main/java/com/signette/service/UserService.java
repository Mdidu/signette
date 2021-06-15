package com.signette.service;

import com.signette.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends GlobalService<User, Long>{
    Optional<User> findByUserMail(String mail);
    boolean existsByUserMail(String mail);
    List<User> findByUserLastname(String lastname);
}
