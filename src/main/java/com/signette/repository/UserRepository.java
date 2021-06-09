package com.signette.repository;

import com.signette.domains.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByUserMail(String mail);
    boolean existsByUserMail(String mail);
}
