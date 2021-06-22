package com.signette.repository;

import com.signette.domains.Role;
import com.signette.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserMail(String mail);
    boolean existsByUserMail(String mail);

    //Recherche un Utilisateur par username OR lastName et par role
    @Query("select u from User u where upper(u.userLastname) like upper(concat('%', ?1, '%')) or upper(u.userUsername) like upper(concat('%', ?2, '%')) and u.role.roleId = ?3")
    List<User> findByUserLastnameContainsIgnoreCaseOrUserUsernameContainsIgnoreCaseAndRole_RoleId(String userLastname, String userUsername, long role_roleId);

    List<User> findByUserLastname(String lastname);
    List<User> findUserByRole_RoleId(Long id);

}
