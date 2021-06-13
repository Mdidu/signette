package com.signette.repository;

import com.signette.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserMail(String mail);
    boolean existsByUserMail(String mail);
}
